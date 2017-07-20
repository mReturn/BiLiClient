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
 * 游戏
 */

public class UserGameFragment extends BaseUserFragment {
    private List<UserInfo.DataBean.GameBean.GameItemBean> gameList = new ArrayList<>();

    public static UserGameFragment newInstance (UserInfo.DataBean.GameBean gameBean){
        UserGameFragment fragment = new UserGameFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constant.EXTRA_DATA,gameBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void prepareData() {
        UserInfo.DataBean.GameBean gameBean = getArguments().getParcelable(Constant.EXTRA_DATA);
        if (gameBean != null && gameBean.getCount()>0){
            gameList.addAll(gameBean.getItem());
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
        mRecycleView.setAdapter(new BaseRecycleViewAdapter(getContext(),gameList) {
            @Override
            public int getItemLayoutId(int layoutID) {
                return R.layout.item_user_game;
            }

            @Override
            public void bindData(BaseViewHolder holder, int position) {
                UserInfo.DataBean.GameBean.GameItemBean item = gameList.get(position);
                ImageLoader.display(holder.getImageView(R.id.iv_img),item.getIcon(),R.drawable.bili_default_image_tv);
                holder.setText(R.id.tv_title,item.getName());
                holder.setText(R.id.tv_desc,item.getSummary());
            }

        });
    }
}
