package com.mreturn.biliclient.ui.Home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.ui.base.BaseRxLazyFragment;

import butterknife.BindView;

/**
 * Created by mReturn
 * on 2017/7/12.
 */
public class HomeRegionFragment extends BaseRxLazyFragment {

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_region;
    }

    @Override
    protected void initView(Bundle state) {

    }
}
