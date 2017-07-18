package com.mreturn.biliclient.ui.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bilibili.magicasakura.utils.ThemeUtils;
import com.mreturn.biliclient.R;
import com.mreturn.biliclient.utils.ThemeHelper;
import com.mreturn.biliclient.widget.dialog.ThemePickDialog;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by mReturn
 * on 2017/6/21.
 */

public abstract class BaseRxActivity extends RxAppCompatActivity implements ThemePickDialog.onConfirmListener{
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
        //初始化页面
        initView(savedInstanceState);
        //初始化ToolBar
        initToolBar();
    }

    @Override
    public void onConfirm(int currentTheme) {
        if (ThemeHelper.getTheme(this) != currentTheme){
            ThemeHelper.setTheme(this,currentTheme);
            ThemeUtils.refreshUI(this, new ThemeUtils.ExtraRefreshable() {
                @Override
                public void refreshGlobal(Activity activity) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        ActivityManager.TaskDescription taskDescription = new ActivityManager
                                .TaskDescription(null,null,ThemeUtils.getThemeAttrColor(
                                BaseRxActivity.this,android.R.attr.colorPrimary));
                        setTaskDescription(taskDescription);
                        getWindow().setStatusBarColor(ThemeUtils.getColorById(BaseRxActivity.this,
                               R.color.theme_color_primary_dark ));
                    }
                }

                @Override
                public void refreshSpecificView(View view) {

                }
            });

        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ThemeUtils.getColorById(this,R.color.theme_color_primary_dark));
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(
                    null,null,ThemeUtils.getThemeAttrColor(this,android.R.attr.colorPrimary));
            setTaskDescription(taskDescription);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    //获取界面布局id
    protected abstract int getLayoutId();

    protected abstract void initToolBar();

    protected abstract void initView(Bundle savedInstanceState);
}
