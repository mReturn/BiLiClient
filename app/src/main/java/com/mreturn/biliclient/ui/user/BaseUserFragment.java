package com.mreturn.biliclient.ui.user;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.ui.base.BaseRxLazyFragment;
import com.mreturn.biliclient.widget.CustomEmptyView;

import butterknife.BindView;

/**
 * Created by mReturn
 * on 2017/7/11.
 */

public abstract class BaseUserFragment extends BaseRxLazyFragment {
    @BindView(R.id.recycle_view)
    protected RecyclerView mRecycleView;
    @BindView(R.id.empty_view)
    protected CustomEmptyView emptyView;

    View footView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_base_user;
    }

    @Override
    protected void initView(Bundle state) {
        emptyView.setImageRes(R.drawable.img_tips_error_space_no_data);
        emptyView.setEmptyText("ㄟ( ▔, ▔ )ㄏ 再怎么找也没有啦");
        prepareData();
        initRecyclerView();
    }

    protected void showEmptyView() {
        emptyView.setVisibility(View.VISIBLE);
    }
    protected void hideEmptyView() {
        emptyView.setVisibility(View.GONE);
    }


    protected abstract void prepareData();

    protected abstract void initRecyclerView();
}
