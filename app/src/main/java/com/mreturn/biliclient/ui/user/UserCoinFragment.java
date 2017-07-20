package com.mreturn.biliclient.ui.user;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.LoadMoreRvAdapter;
import com.mreturn.biliclient.adapter.helper.CustomerOnScrollListener;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.bean.UserInfo;
import com.mreturn.biliclient.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/19.
 * 投币
 */

public class UserCoinFragment extends BaseUserFragment {

    int vmid;
    int pageNum = 1;
    int pageSize = 10;
    LoadMoreRvAdapter adapter;
    List<UserInfo.DataBean.CoinArchiveBean.CoinItemBean> archiveList = new ArrayList<>();

    public static UserCoinFragment newInstance(UserInfo.DataBean.CoinArchiveBean coinArchiveBean, int vmid) {
        UserCoinFragment fragment = new UserCoinFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.EXTRA_MID, vmid);
        bundle.putParcelable(Constant.EXTRA_DATA, coinArchiveBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void prepareData() {
        vmid = getArguments().getInt(Constant.EXTRA_MID);
        UserInfo.DataBean.CoinArchiveBean coinArchiveBean = getArguments().getParcelable(Constant.EXTRA_DATA);
        if (coinArchiveBean != null && coinArchiveBean.getCount() > 0) {
            archiveList.addAll(coinArchiveBean.getItem());
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
//                adapter.addFooter();
//                mRecycleView.scrollToPosition(adapter.getItemCount() - 1);
                pageNum++;
            }
        });

    }


    @SuppressWarnings("unchecked")
    private void setAdapter() {
        if (adapter == null) {
            adapter = new LoadMoreRvAdapter(getActivity(), R.layout.item_user_archive, archiveList) {
                @Override
                protected void bindData(BaseViewHolder holder, int position) {
                    UserInfo.DataBean.CoinArchiveBean.CoinItemBean item = archiveList.get(position);
                    ImageLoader.display(holder.getImageView(R.id.iv_img), item.getCover()
                            , R.drawable.bili_default_image_tv);
                    holder.setText(R.id.tv_title, item.getTitle());
                    holder.setText(R.id.tv_play, item.getPlay() + "");
                    holder.setText(R.id.tv_danmaku, item.getDanmaku() + "");
                    holder.setClickListener(R.id.root_view,v -> {
                        //TODO click
                    });
                }
            };
            mRecycleView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }
}
