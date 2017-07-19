package com.mreturn.biliclient.ui.Home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.ui.MainActivity;
import com.mreturn.biliclient.ui.base.BaseRxLazyFragment;
import com.mreturn.biliclient.widget.CustomEmptyView;

import butterknife.BindView;

/**
 * Created by mReturn
 * on 2017/7/17.
 */

public class CollectFragment extends BaseRxLazyFragment {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.empty_view)
    CustomEmptyView emptyView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collect;
    }

    @Override
    protected void initView(Bundle state) {
        toolbar.setTitle("我的收藏");
        toolbar.setNavigationIcon(R.drawable.ic_navigation_drawer);
        toolbar.setNavigationOnClickListener(v -> {
            Activity activity = getActivity();
            if (activity instanceof MainActivity){
                ((MainActivity) activity).toggleDrawer();
            }
        });
        emptyView.setImageRes(R.drawable.img_tips_error_fav_no_data);
        emptyView.setEmptyText("目前还没有收藏");
    }

}
