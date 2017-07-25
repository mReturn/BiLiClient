package com.mreturn.biliclient.ui.user;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.LoadMoreRvAdapter;
import com.mreturn.biliclient.adapter.helper.CustomerOnScrollListener;
import com.mreturn.biliclient.api.CustomObserver;
import com.mreturn.biliclient.api.RetrofitHelper;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.bean.UserArchiveInfo;
import com.mreturn.biliclient.bean.UserInfo;
import com.mreturn.biliclient.ui.video.VideoDetailActivity;
import com.mreturn.biliclient.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mReturn
 * on 2017/7/19.
 * 投稿
 */

public class UserArchiveFragment extends BaseUserFragment {


    int vmid;
    int pageNum = 1;
    int pageSize = 10;
    LoadMoreRvAdapter adapter;
    List<UserInfo.DataBean.ArchiveBean.ArchiveItemBean> archiveList = new ArrayList<>();

    public static UserArchiveFragment newInstance(UserInfo.DataBean.ArchiveBean archiveBean, int vmid) {
        UserArchiveFragment fragment = new UserArchiveFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.EXTRA_MID, vmid);
        bundle.putParcelable(Constant.EXTRA_DATA, archiveBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void prepareData() {
        vmid = getArguments().getInt(Constant.EXTRA_MID);
        UserInfo.DataBean.ArchiveBean archiveBean = getArguments().getParcelable(Constant.EXTRA_DATA);
        if (archiveBean != null && archiveBean.getCount() > 0) {
            archiveList.addAll(archiveBean.getItem());
        } else {
            showEmptyView();
        }
    }

    @Override
    protected void initRecyclerView() {
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setAdapter();

        mRecycleView.addOnScrollListener(new CustomerOnScrollListener() {
            @Override
            public void onLoadMore() {
                adapter.addFooter();
                mRecycleView.scrollToPosition(adapter.getItemCount() - 1);
                pageNum++;
                getMoreData();
            }
        });

    }

    private void getMoreData() {
        RetrofitHelper.getAppApi()
                .getArchive(pageNum, vmid)
                .compose(bindToLifecycle())
                .map(new Function<UserArchiveInfo, List<UserInfo.DataBean.ArchiveBean.ArchiveItemBean>>() {
                    @Override
                    public List<UserInfo.DataBean.ArchiveBean.ArchiveItemBean> apply(@NonNull UserArchiveInfo userArchiveInfo) throws Exception {
                        return userArchiveInfo.getData().getItem();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<List<UserInfo.DataBean.ArchiveBean.ArchiveItemBean>>() {
                    @Override
                    public void accept(@NonNull List<UserInfo.DataBean.ArchiveBean.ArchiveItemBean> archiveItemBeen) throws Exception {
                        if (archiveItemBeen.size() < pageSize) {
                            adapter.removeFooter();
                        }
                    }
                })
                .subscribe(new CustomObserver<List<UserInfo.DataBean.ArchiveBean.ArchiveItemBean>>() {
                    @Override
                    protected void onSuccess(List<UserInfo.DataBean.ArchiveBean.ArchiveItemBean> archiveItemBeen) {
                        adapter.removeFooter();
                        archiveList.addAll(archiveItemBeen);
                        setAdapter();
                    }

                    @Override
                    protected void onFailure(Throwable e) {
                        adapter.removeFooter();
                    }
                });
    }

    @SuppressWarnings("unchecked")
    private void setAdapter() {
        if (adapter == null) {
            adapter = new LoadMoreRvAdapter(getActivity(), R.layout.item_user_archive, archiveList) {
                @Override
                protected void bindData(BaseViewHolder holder, int position) {
                    UserInfo.DataBean.ArchiveBean.ArchiveItemBean item = archiveList.get(position);
                    ImageLoader.display(holder.getImageView(R.id.iv_img), item.getCover()
                            , R.drawable.bili_default_image_tv);
                    holder.setText(R.id.tv_title, item.getTitle());
                    holder.setText(R.id.tv_play, item.getPlay() + "");
                    holder.setText(R.id.tv_danmaku, item.getDanmaku() + "");
                    holder.setClickListener(R.id.root_view, v ->
                            VideoDetailActivity.launch(getContext(), Integer.parseInt(item.getParam()), item.getCover())
                    );
                }
            };
            mRecycleView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

}
