package com.mreturn.biliclient.ui.Home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.ui.base.BaseLazyFragment;
import com.mreturn.biliclient.widget.CustomEmptyView;

import butterknife.BindView;

/**
 * Created by mReturn
 * on 2017/7/11.
 */

public abstract class BaseHomeContentFragment extends BaseLazyFragment{
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.empty_view)
    CustomEmptyView emptyView;
    @BindView(R.id.swip_refresh_layout)
    SwipeRefreshLayout swipRefreshLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_content;
    }

    @Override
    protected void initView(Bundle state) {
        isPrepared = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible)
            return;
        initRefreshLayout();
        initRecyclerView();
        isPrepared = false;
    }


    protected abstract void initRefreshLayout();

    protected abstract void initRecyclerView();
}
