package com.mreturn.biliclient.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatDelegate;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.ui.Home.HomeFragment;
import com.mreturn.biliclient.ui.base.BaseRxActivity;
import com.mreturn.biliclient.utils.SpUtils;
import com.mreturn.biliclient.utils.ToastUtil;

import butterknife.BindView;

public class MainActivity extends BaseRxActivity implements NavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.nav_home)
    NavigationView navHome;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private Fragment[] fragments;
    private int currentTabIndex;
    private int index;
    private long exitTime;
    HomeFragment mHomeFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolBar() {
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initFragments();
        intNavView();
    }

    private void initFragments() {
        if (mHomeFragment == null){
            mHomeFragment = new HomeFragment();
            //显示主界面
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fl_main, mHomeFragment)
                    .show(mHomeFragment)
                    .commit();
        }
    }

    //初始化左侧菜单栏
    private void intNavView() {
        navHome.setNavigationItemSelectedListener(this);
        View navHeadView = navHome.getHeaderView(0);
        ImageView ivSwitchMode = (ImageView) navHeadView.findViewById(R.id.iv_switch_mode);
        ivSwitchMode.setOnClickListener(a -> switchThemeMode(ivSwitchMode));
        boolean isNight = (boolean) SpUtils.get(this, Constant.IS_NIGHT_MODE, false);
        if (isNight) {
            ivSwitchMode.setImageResource(R.drawable.ic_switch_daily);
        } else {
            ivSwitchMode.setImageResource(R.drawable.ic_switch_night);
        }
    }

    // 切换主题
    private void switchThemeMode(ImageView iv) {
        boolean isNight = (boolean) SpUtils.get(this, Constant.IS_NIGHT_MODE, false);
        if (isNight) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            SpUtils.put(this, Constant.IS_NIGHT_MODE, false);
        } else {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            SpUtils.put(this, Constant.IS_NIGHT_MODE, true);
        }

//        ToastUtil.show(getSupportFragmentManager().getFragments().size()+"");
        recreate();
    }


    /**
     * 改变侧滑菜单状态
     */
    public void toggleDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        ToastUtil.show(item.getTitle() + "");
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else if (mHomeFragment != null && mHomeFragment.isSearchViewOpen()) {
            mHomeFragment.closeSearchView();
        } else {
            exitApp();
        }
    }

    private void exitApp() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            exitTime = System.currentTimeMillis();
            ToastUtil.show(R.string.click_exit);
        } else {
            System.exit(0);
        }
    }
}
