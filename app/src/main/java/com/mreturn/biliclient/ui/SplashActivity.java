package com.mreturn.biliclient.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mreturn.biliclient.R;
import com.mreturn.biliclient.utils.SystemUiUtil;
import com.trello.rxlifecycle2.components.RxActivity;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by mReturn
 * on 2017/6/20.
 */

public class SplashActivity extends RxActivity {
    private Unbinder bind;
    private final int SPLASH_TIME = 2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        bind = ButterKnife.bind(this);
        SystemUiUtil.showStatusBar(getWindow(),false);
        initSplash();
    }

    private void initSplash() {
        Observable.timer(SPLASH_TIME, TimeUnit.SECONDS)
                .compose(this.<Long>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( to -> {
                    toMain();
                });
    }

    private void toMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
