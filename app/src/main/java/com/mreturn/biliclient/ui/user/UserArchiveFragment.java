package com.mreturn.biliclient.ui.user;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.adapter.LoadMoreRvAdapter;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.bean.UserInfo;
import com.mreturn.biliclient.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/19.
 * 投稿
 */

public class UserArchiveFragment extends BaseUserFragment {


    List<UserInfo.DataBean.ArchiveBean.ArchiveItemBean> archiveList = new ArrayList<>();
    int vmid;
    LoadMoreRvAdapter adapter;

    public static UserArchiveFragment newInstance(UserInfo.DataBean.ArchiveBean archiveBean, int vmid) {
        UserArchiveFragment fragment = new UserArchiveFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.EXTRA_MID,vmid);
        bundle.putParcelable(Constant.EXTRA_DATA,archiveBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void prepareData() {
        vmid = getArguments().getInt(Constant.EXTRA_MID);
        UserInfo.DataBean.ArchiveBean archiveBean = getArguments().getParcelable(Constant.EXTRA_DATA);
        if (archiveBean != null){
            archiveList.addAll(archiveBean.getItem());
        }
    }

    @Override
    protected void initRecyclerView() {
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setAdapter();
        adapter.addFooter();

    }

    @SuppressWarnings("unchecked")
    private void setAdapter() {
        if (adapter == null){
            adapter = new LoadMoreRvAdapter(getActivity(), R.layout.item_user_archive,archiveList) {
                @Override
                protected void bindData(BaseViewHolder holder, int position) {
                    UserInfo.DataBean.ArchiveBean.ArchiveItemBean item = archiveList.get(position);
                    ImageLoader.display(holder.getImageView(R.id.iv_img),item.getCover()
                            ,R.drawable.bili_default_image_tv);
                    holder.setText(R.id.tv_play,item.getPlay()+"");
                    holder.setText(R.id.tv_danmaku,item.getDanmaku()+"");
                }
            };
            mRecycleView.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }
    }

}
