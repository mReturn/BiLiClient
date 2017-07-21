package com.mreturn.biliclient.ui.user;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.BaseRecycleViewAdapter;
import com.mreturn.biliclient.adapter.BaseViewHolder;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.bean.UserInfo;
import com.mreturn.biliclient.utils.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mReturn
 * on 2017/7/19.
 * 兴趣圈
 */

public class UserCommunityFragment extends BaseUserFragment {

    private List<UserInfo.DataBean.CommunityBean.CommunityItemBean> communityList = new ArrayList<>();
    private int vmid;

    public static UserCommunityFragment newInstance(UserInfo.DataBean.CommunityBean communityBean,int vmid){
        UserCommunityFragment fragment = new UserCommunityFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.EXTRA_MID,vmid);
        bundle.putParcelable(Constant.EXTRA_DATA,communityBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void prepareData() {
        vmid = getArguments().getInt(Constant.EXTRA_MID);
        UserInfo.DataBean.CommunityBean communityBean = getArguments().getParcelable(Constant.EXTRA_DATA);
        if (communityBean != null && communityBean.getCount()>0){
            communityList.addAll(communityBean.getItem());
        }else {
            showEmptyView();
        }

    }

    @Override
    protected void initRecyclerView() {
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        setAdapter();
    }

    @SuppressWarnings("unchecked")
    private void setAdapter() {
        mRecycleView.setAdapter(new BaseRecycleViewAdapter(getContext(),communityList) {
            @Override
            public int getItemLayoutId(int layoutID) {
                return R.layout.item_user_community;
            }

            @Override
            public void bindData(BaseViewHolder holder, int position) {
                UserInfo.DataBean.CommunityBean.CommunityItemBean item = communityList.get(position);
                ImageLoader.display(holder.getImageView(R.id.iv_img),item.getThumb(),R.drawable.bili_default_image_tv);
                holder.setText(R.id.tv_title,item.getName());
                holder.setText(R.id.tv_desc,item.getDesc());
                holder.setText(R.id.tv_post_nickname,item.getPost_nickname());
                holder.setText(R.id.tv_post_count,item.getPost_count()+"");
                holder.setText(R.id.tv_member_nickname,item.getMember_nickname());
                holder.setText(R.id.tv_member_count,item.getMember_count()+"");
            }

        });
    }
}
