package com.mreturn.biliclient.ui.user;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.LoadMoreRvAdapter;
import com.mreturn.biliclient.adapter.helper.CustomerOnScrollListener;
import com.mreturn.biliclient.api.CustomObserver;
import com.mreturn.biliclient.api.RetrofitHelper;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.bean.UserInfo;
import com.mreturn.biliclient.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mReturn
 * on 2017/7/19.
 * 追番
 */

public class UserSeasonFragment extends BaseUserFragment {

    private int vmid;
    private int pageNum = 1;
    private int pageSize = 10;
    private LoadMoreRvAdapter adapter;
    private List<UserInfo.DataBean.SeasonBean.SeasonItemBean> seasonList = new ArrayList<>();

    public static UserSeasonFragment newInstance(UserInfo.DataBean.SeasonBean seasonBean, int vmid) {
        UserSeasonFragment fragment = new UserSeasonFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.EXTRA_MID, vmid);
        bundle.putParcelable(Constant.EXTRA_DATA, seasonBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void prepareData() {
        vmid = getArguments().getInt(Constant.EXTRA_MID);
        UserInfo.DataBean.SeasonBean seasonBean = getArguments().getParcelable(Constant.EXTRA_DATA);
        if (seasonBean != null && seasonBean.getCount() > 0) {
            seasonList.addAll(seasonBean.getItem());
        } else {
            showEmptyView();
        }
    }

    @Override
    protected void initRecyclerView() {
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        setAdapter();
        mRecycleView.addOnScrollListener(new CustomerOnScrollListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                getMoreSeason();
            }
        });
    }

    private void getMoreSeason() {
        RetrofitHelper.getAppApi()
                .getSeason(pageNum, vmid)
                .compose(bindToLifecycle())
                .map(userSeasonInfo -> userSeasonInfo.getData().getItem())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver<List<UserInfo.DataBean.SeasonBean.SeasonItemBean>>() {
                    @Override
                    protected void onSuccess(List<UserInfo.DataBean.SeasonBean.SeasonItemBean> seasonItemBeen) {
                        seasonList.addAll(seasonItemBeen);
                        setAdapter();
                    }

                    @Override
                    protected void onFailure(Throwable e) {
                    }
                });

    }

    @SuppressWarnings("unchecked")
    private void setAdapter() {
        if (adapter == null) {
            adapter = new LoadMoreRvAdapter(getActivity(), R.layout.item_user_season, seasonList) {
                @Override
                protected void bindData(BaseViewHolder holder, int position) {
                    UserInfo.DataBean.SeasonBean.SeasonItemBean item = seasonList.get(position);
                    ImageLoader.display(holder.getImageView(R.id.iv_img), item.getCover(), R.drawable.bili_default_image_tv);
                    holder.setText(R.id.tv_title, item.getTitle());
                    String updateStr;
                    if (item.getFinish() == 1) {
                        updateStr = "全" + item.getTotal_count() + "话";
                    } else {
                        updateStr = "更新至第" + item.getNewest_ep_index() + "话";
                    }
                    holder.setText(R.id.tv_update, updateStr);
                }
            };
            mRecycleView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }
}
