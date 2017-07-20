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
 * 收藏
 */

public class UserFavouriteFragment extends BaseUserFragment {

    private List<UserInfo.DataBean.FavouriteBean.FavouriteItemBean> favouriteList = new ArrayList<>();

    public static UserFavouriteFragment newInstance (UserInfo.DataBean.FavouriteBean favouriteBean){
        UserFavouriteFragment userFavouriteFragment = new UserFavouriteFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.EXTRA_DATA,favouriteBean);
        userFavouriteFragment.setArguments(bundle);
        return userFavouriteFragment;
    }

    @Override
    protected void prepareData() {
        UserInfo.DataBean.FavouriteBean favouriteBean = getArguments().getParcelable(Constant.EXTRA_DATA);
        if (favouriteBean != null && favouriteBean.getCount()>0){
            favouriteList.addAll(favouriteBean.getItem());
        }else {
            showEmptyView();
        }

    }

    @Override
    protected void initRecyclerView() {
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setAdapter();
    }

    @SuppressWarnings("unchecked")
    private void setAdapter() {
        mRecycleView.setAdapter(new BaseRecycleViewAdapter(getContext(),favouriteList) {
            @Override
            public int getItemLayoutId(int layoutID) {
                return R.layout.item_user_favourite;
            }

            @Override
            public void bindData(BaseViewHolder holder, int position) {
                UserInfo.DataBean.FavouriteBean.FavouriteItemBean item = favouriteList.get(position);
                holder.setText(R.id.tv_title,item.getName());
                holder.setText(R.id.tv_left_count,item.getCur_count()+"");
                holder.setText(R.id.tv_pub_count,item.getCur_count()+"个内容");
                if (item.getCur_count()>0){
                    ImageLoader.display(holder.getImageView(R.id.iv_img),
                            item.getCover().get(0).getPic(),R.drawable.bili_default_image_tv);
                }else {
                    holder.setImgResource(R.id.iv_img,R.drawable.bili_default_image_tv);
                }
            }

        });
    }
}
