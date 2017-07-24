package com.mreturn.biliclient.ui.video;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.mreturn.biliclient.R;
import com.mreturn.biliclient.adapter.CommonFragmentPagerAdapter;
import com.mreturn.biliclient.api.CustomObserver;
import com.mreturn.biliclient.api.RetrofitHelper;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.bean.VideoDetailsInfo;
import com.mreturn.biliclient.event.AppBarStateChangeEvent;
import com.mreturn.biliclient.ui.base.BaseRxActivity;
import com.mreturn.biliclient.utils.DisplayUtils;
import com.mreturn.biliclient.utils.ImageLoader;
import com.mreturn.biliclient.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mReturn
 * on 2017/7/24.
 */

public class VideoDetailActivity extends BaseRxActivity {

    @BindView(R.id.iv_video_preview)
    ImageView ivVideoPreview;
    @BindView(R.id.tv_av)
    TextView tvAv;
    @BindView(R.id.tv_player)
    TextView tvPlayer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.tab_layout)
    SlidingTabLayout tabLayout;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private int aid;
    private String imgUrl;
    List<Fragment> fragments = new ArrayList<>();
    String[] titles;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_detail;
    }

    public static void launch(Context context, int aid, String imgUrl) {
        Intent intent = new Intent(context, VideoDetailActivity.class);
        intent.putExtra(Constant.AID, aid);
        intent.putExtra(Constant.EXTRA_IMG_URL, imgUrl);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null) {
            aid = intent.getIntExtra(Constant.AID, -1);
            imgUrl = intent.getStringExtra(Constant.EXTRA_IMG_URL);
        }
        ImageLoader.display(ivVideoPreview, imgUrl, R.drawable.bili_default_image_tv);

        getVideoData();


        fab.setClickable(false);
        fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.gray_20)));
        fab.setTranslationY(-getResources().getDimension(R.dimen.floating_action_button_size_half));
        fab.setOnClickListener(v ->
                ToastUtil.show("play")
        );
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) ->
                setViewsTranlation(verticalOffset)
        );
        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeEvent() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state, int verticalOffset) {
                if (state == State.COLLAPSED){
                    tvPlayer.setVisibility(View.VISIBLE);
                    tvAv.setVisibility(View.GONE);
                    toolbar.setContentInsetsRelative(DisplayUtils.dp2px(VideoDetailActivity.this,150),0);
                }else {
                    tvPlayer.setVisibility(View.GONE);
                    tvAv.setVisibility(View.VISIBLE);
                    toolbar.setContentInsetsRelative(DisplayUtils.dp2px(VideoDetailActivity.this,15),0);
                }
            }
        });

    }

    private void getVideoData() {
        RetrofitHelper.getAppApi()
                .getVideoDetails(aid)
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CustomObserver<VideoDetailsInfo>() {
                    @Override
                    protected void onSuccess(VideoDetailsInfo videoDetailsInfo) {
                        if (videoDetailsInfo != null && videoDetailsInfo.getData() != null){
                            setVideoData(videoDetailsInfo.getData());
                        }else {
                            ToastUtil.show("未获取到数据");
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e) {
                        ToastUtil.show("获取数据失败");
                    }
                });
    }

    private void setVideoData(VideoDetailsInfo.VideoDetail data) {
        fab.setClickable(true);
        fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
        collapsingToolbar.setTitle("");

        fragments.clear();
        fragments.add(VideoInfoFragment.newInstance(data));
        fragments.add(VideoCommentFragment.newInstance(aid));
        initViewPager(data);

    }

    private void initViewPager(VideoDetailsInfo.VideoDetail detail) {
        titles = new String[]{"简介","评论" + "(" + detail.getStat().getReply() + ")"};
        viewPager.setAdapter(new CommonFragmentPagerAdapter(getSupportFragmentManager(),fragments));
        viewPager.setOffscreenPageLimit(titles.length);
        tabLayout.setViewPager(viewPager,titles);
        setSlidingTabIndicatorWidth(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                setSlidingTabIndicatorWidth(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setSlidingTabIndicatorWidth(int pos) {
        if (titles != null && titles.length > pos) {
            String title = titles[pos];
            TextView tv = tabLayout.getTitleView(pos);
            TextPaint paint = tv.getPaint();
            float textWidth = paint.measureText(title);
            tabLayout.setIndicatorWidth(textWidth / 2);
        }
    }

    private void setViewsTranlation(int value) {
        fab.setTranslationY(value);
        if (value == 0) {
            fab.animate().scaleX(1f).scaleY(1f)
                    .setInterpolator(new OvershootInterpolator())
                    .start();
            fab.setClickable(true);
        } else if (value < 0) {
            fab.animate().scaleX(0f).scaleY(0f)
                    .setInterpolator(new AccelerateDecelerateInterpolator())
                    .start();
            fab.setClickable(false);
        }
    }

    @Override
    protected void initToolBar() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        //未收缩时toobar字体颜色
        collapsingToolbar.setExpandedTitleColor(Color.TRANSPARENT);
        //收缩时
        collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);
        //状态栏透明
//        SystemBarHelper.immersiveStatusBar(this);
//        SystemBarHelper.setHeightAndPadding(this,toolbar);
        tvAv.setText("av"+aid);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
