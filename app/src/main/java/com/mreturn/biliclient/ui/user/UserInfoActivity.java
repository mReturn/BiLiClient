package com.mreturn.biliclient.ui.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.mreturn.biliclient.R;
import com.mreturn.biliclient.api.CustomObserver;
import com.mreturn.biliclient.api.RetrofitHelper;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.bean.UserInfo;
import com.mreturn.biliclient.event.AppBarStateChangeEvent;
import com.mreturn.biliclient.ui.base.BaseRxActivity;
import com.mreturn.biliclient.utils.ImageLoader;
import com.mreturn.biliclient.utils.SystemBarHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mReturn
 * on 2017/7/19.
 */

public class UserInfoActivity extends BaseRxActivity {
    @BindView(R.id.iv_user_pic)
    ImageView ivUserPic;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.user_sex)
    ImageView userSex;
    @BindView(R.id.iv_level)
    ImageView ivLevel;
    @BindView(R.id.tv_follow_users)
    TextView tvFollowUsers;
    @BindView(R.id.tv_fans)
    TextView tvFans;
    @BindView(R.id.tv_author_verified)
    TextView tvAuthorVerified;
    @BindView(R.id.ll_author_verified)
    LinearLayout llAuthorVerified;
    @BindView(R.id.tv_user_desc)
    TextView tvUserDesc;
    @BindView(R.id.iv_user_avatar)
    ImageView ivUserAvatar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.sliding_tabs)
    SlidingTabLayout slidingTabs;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.pb)
    ContentLoadingProgressBar pb;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout csToolbar;
    @BindView(R.id.line)
    View lineView;

    private int mid;
    private String name;
    private String avatar;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_info;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null) {
            mid = intent.getIntExtra(Constant.EXTRA_MID, -1);
            name = intent.getStringExtra(Constant.EXTRA_NAME);
            avatar = intent.getStringExtra(Constant.EXTRA_AVATAR);
        }
        tvUserName.setText(name);
        ImageLoader.displayCircleImg(ivUserAvatar, avatar, R.drawable.ico_user_default);

        getUserIfo();
    }

    @Override
    protected void initToolBar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //StatusBar 透明
        SystemBarHelper.immersiveStatusBar(this);
        SystemBarHelper.setHeightAndPadding(this, toolbar);
        //AppBar状态监听
        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeEvent() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state, int verticalOffset) {
                if (state == State.EXPANDED) {
                    csToolbar.setTitle("");
                    lineView.setVisibility(View.VISIBLE);

                } else if (state == State.COLLAPSED) {
                    csToolbar.setTitle(name);
                    lineView.setVisibility(View.GONE);
                } else {
                    csToolbar.setTitle("");
                    lineView.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    private void getUserIfo() {
        RetrofitHelper.getAppApi()
                .getUserInfo(mid)
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver<UserInfo>() {
                    @Override
                    protected void onSuccess(UserInfo userInfo) {
                        pb.setVisibility(View.GONE);
                        if (userInfo != null){
                            setUserData(userInfo);
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e) {
                        pb.setVisibility(View.GONE);
                    }
                });
    }

    private void setUserData(UserInfo userInfo) {
//        ImageLoader.displayCircleImg(ivUserAvatar, userInfo.getCard().getFace(), R.drawable.ico_user_default);
//        tvUserName.setText(userInfo.getCard().getName());
        UserInfo.DataBean.CardBean cardBean = userInfo.getData().getCard();
        tvFollowUsers.setText(cardBean.getAttention() + "");
        tvFans.setText(cardBean.getFans() + "");
        setuserLevel(cardBean.getLevel_info().getCurrent_level());
        //性别
        switch (cardBean.getSex()) {
            case "男":
                userSex.setImageResource(R.drawable.ic_user_male);
                break;
            case "女":
                userSex.setImageResource(R.drawable.ic_user_female);
                break;
            default:
                userSex.setImageResource(R.drawable.ic_user_gay_border);
                break;
        }
        //签名信息
        if (!TextUtils.isEmpty(cardBean.getSign())){
            tvUserDesc.setText(cardBean.getSign());
        }else {
            tvUserDesc.setText("这个人懒死了,什么都没有写(・－・。)");
        }
        //认证信息
        if (cardBean.isApprove()){
            llAuthorVerified.setVisibility(View.VISIBLE);
            if (!TextUtils.isEmpty(cardBean.getDescription())){
                tvAuthorVerified.setText(cardBean.getDescription());
            }else {
                tvAuthorVerified.setText("这个人懒死了,什么都没有写(・－・。)");
            }
        }else {
            llAuthorVerified.setVisibility(View.GONE);
        }

        intViewPager(userInfo);
    }

    //设置等级
    private void setuserLevel(int level) {
        switch (level){
            case 0:
                ivLevel.setImageResource(R.drawable.ic_lv0);
            break;
            case 1:
                ivLevel.setImageResource(R.drawable.ic_lv1);
            break;
            case 2:
                ivLevel.setImageResource(R.drawable.ic_lv2);
            break;
            case 3:
                ivLevel.setImageResource(R.drawable.ic_lv3);
            break;
            case 4:
                ivLevel.setImageResource(R.drawable.ic_lv4);
            break;
            case 5:
                ivLevel.setImageResource(R.drawable.ic_lv5);
            break;
            case 6:
                ivLevel.setImageResource(R.drawable.ic_lv6);
            break;
            default:
                break;
        }
    }

    private void intViewPager(UserInfo userInfo) {
        fragments.add(UserArchiveFragment.newInstance(userInfo.getData().getArchive(),mid));
        fragments.add(UserArchiveFragment.newInstance(userInfo.getData().getArchive(),mid));
        fragments.add(UserArchiveFragment.newInstance(userInfo.getData().getArchive(),mid));
        fragments.add(UserArchiveFragment.newInstance(userInfo.getData().getArchive(),mid));
        fragments.add(UserArchiveFragment.newInstance(userInfo.getData().getArchive(),mid));
        fragments.add(UserArchiveFragment.newInstance(userInfo.getData().getArchive(),mid));
        viewPager.setOffscreenPageLimit(fragments.size());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
