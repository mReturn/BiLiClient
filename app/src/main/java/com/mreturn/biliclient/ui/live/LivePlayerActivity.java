package com.mreturn.biliclient.ui.live;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.ui.base.BaseRxActivity;
import com.mreturn.biliclient.utils.ImageLoader;
import com.mreturn.biliclient.widget.dialog.CircleImageView;

import butterknife.BindView;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * Created by mReturn
 * on 2017/7/18.
 */

public class LivePlayerActivity extends BaseRxActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.video_view)
    SurfaceView videoView;
    @BindView(R.id.rl_loading)
    RelativeLayout rlLoading;
    @BindView(R.id.iv_right_play)
    ImageView ivRightPlay;
    @BindView(R.id.iv_bottom_play)
    ImageView ivBottomPlay;
    @BindView(R.id.iv_fullscreen)
    ImageView ivFullscreen;
    @BindView(R.id.bottom_layout)
    RelativeLayout bottomLayout;
    @BindView(R.id.live_layout)
    FrameLayout liveLayout;
    @BindView(R.id.iv_avatar)
    CircleImageView ivAvatar;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_live_num)
    TextView tvLiveNum;
    @BindView(R.id.iv_loading)
    ImageView ivLoading;

    private int cid;
    private int online;
    private int mid;
    private String title;
    private String avatar;
    private String name;

    private IjkMediaPlayer ijkMediaPlayer;
    private SurfaceHolder holder;
    private int flag = 0;
    private boolean isPlay = false;
    private AnimationDrawable animationDrawable;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_live_player;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null){
            cid = intent.getIntExtra(Constant.EXTRA_CID,0);
            title = intent.getStringExtra(Constant.EXTRA_TITLE);
            online = intent.getIntExtra(Constant.EXTRA_ONLINE, 0);
            avatar = intent.getStringExtra(Constant.EXTRA_AVATAR);
            name = intent.getStringExtra(Constant.EXTRA_NAME);
            mid = intent.getIntExtra(Constant.EXTRA_MID, 0);
        }
        
        initPlayer();
        setUserInfo();
        startAnim();
    }

    private void initPlayer() {
        holder = videoView.getHolder();
        ijkMediaPlayer = new IjkMediaPlayer();
        getLiveUrl();
    }

    private void getLiveUrl() {
//        <video>
//        <result>suee</result>
//        <timelength>0</timelength>
//        <stream><![CDATA[http]]></stream>
//        <src>0</src>
//        <durl>
//        <order>1</order>
//        <length>0</length>
//        <url><![CDATA[http://xl.live-play.acgvideo.com/live-xl/646001/live_87919354_1422045.flv?wsSecret=06de9994bb80e798f48220d9a0afdc27&wsTime=1500374509]]></url>
//        <b1url><![CDATA[http://xl.live-play.acgvideo.com/live-xl/744061/live_87919354_1422045.flv?wsSecret=2978d713cf67af2a06300aa894315bfb&wsTime=1500374509]]></b1url>
//        <b2url><![CDATA[http://xl.live-play.acgvideo.com/live-xl/404104/live_87919354_1422045.flv?wsSecret=060aacf147835e0e8ade678b5b52f0a1&wsTime=1500374509]]></b2url>
//        <b3url><![CDATA[http://xl.live-play.acgvideo.com/live-xl/807483/live_87919354_1422045.flv?wsSecret=a14b691e04b55d201362b2fa6986de7f&wsTime=1500374509]]></b3url>
//        </durl>
//        <accept_quality><![CDATA[4]]></accept_quality>
//        <current_quality>4</current_quality>
//        </video>

//        RetrofitHelper.getLiveApi()
//                .getLiveUrl(cid)
//                .compose(bindToLifecycle())



    }

    private void setUserInfo() {
        ImageLoader.displayCircleImg(ivAvatar,avatar,R.drawable.ico_user_default);
        tvUserName.setText(name);
        tvLiveNum.setText(online+"");
    }

    private void startAnim() {
        animationDrawable = (AnimationDrawable) ivLoading.getBackground();
        animationDrawable.start();
    }



    @Override
    protected void initToolBar() {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}
