package com.mreturn.bilibili.ui.Home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.mreturn.bilibili.R;
import com.mreturn.bilibili.ui.base.BaseLazyFragment;
import com.mreturn.bilibili.widget.CustomEmptyView;

import butterknife.BindView;

/**
 * Created by mReturn
 * on 2017/7/5.
 */

public class HomeLiveFragment extends BaseLazyFragment {

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.empty_view)
    CustomEmptyView emptyView;
    @BindView(R.id.swip_refresh_layout)
    SwipeRefreshLayout swipRefreshLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_live;
    }

    @Override
    protected void initView(Bundle state) {

    }

}
