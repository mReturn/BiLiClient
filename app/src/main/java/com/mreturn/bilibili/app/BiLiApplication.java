package com.mreturn.bilibili.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatDelegate;
import android.text.TextUtils;

import com.bilibili.magicasakura.utils.ThemeUtils;
import com.mreturn.bilibili.R;
import com.mreturn.bilibili.utils.SpUtils;
import com.mreturn.bilibili.utils.ThemeHelper;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by mReturn
 * on 2017/6/21.
 */

public class BiLiApplication extends Application implements ThemeUtils.switchColor {
    public static BiLiApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    private void init() {
        ThemeUtils.setSwitchColor(this);
        //初始化LeakCanary
        if (!LeakCanary.isInAnalyzerProcess(this))
            LeakCanary.install(this);

        //夜间模式
        boolean isNight = (boolean) SpUtils.get(this,Constant.IS_NIGHT_MODE,false);
        if (isNight){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
    }

    public static BiLiApplication getInstance() {
        return instance;
    }


    @Override
    public int replaceColorById(Context context, @ColorRes int colorId) {
        if (ThemeHelper.isDefaultTheme(context)){
            return context.getResources().getColor(colorId);
        }
        String theme = getTheme(context);
        if (!TextUtils.isEmpty(theme)){
            colorId = getThemeColorId(context,colorId,theme);
        }
        return context.getResources().getColor(colorId);
    }

    @Override
    public int replaceColor(Context context, @ColorInt int color) {
        if (ThemeHelper.isDefaultTheme(context)){
            return color;
        }
        String theme = getTheme(context);
        int colorId = -1;
        if (theme != null){
            colorId = getThemeColor(context,color,theme);
        }
        return colorId != -1 ? getResources().getColor(colorId) : color;
    }

    private String getTheme(Context context) {

        if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_BLUE) {
            return "blue";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_PURPLE) {
            return "purple";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_GREEN) {
            return "green";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_GREEN_LIGHT) {
            return "green_light";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_YELLOW) {
            return "yellow";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_ORANGE) {
            return "orange";
        } else if (ThemeHelper.getTheme(context) == ThemeHelper.CARD_RED) {
            return "red";
        }
        return null;
    }

    private
    @ColorRes
    int getThemeColor(Context context, int color, String theme) {

        switch (color) {
            case 0xfffb7299:
                return context.getResources().getIdentifier(theme, "color", getPackageName());
            case 0xffb85671:
                return context.getResources().getIdentifier(theme + "_dark", "color", getPackageName());
            case 0x99f0486c:
                return context.getResources().getIdentifier(theme + "_trans", "color", getPackageName());
        }
        return -1;
    }

    @ColorRes
    private int getThemeColorId(Context context,int colorId,String theme){
        switch (colorId){
            case R.color.theme_color_primary:
                return context.getResources().getIdentifier(theme,"color",getPackageName());
            case R.color.theme_color_primary_dark:
                return context.getResources().getIdentifier(theme+"_dark","color",getPackageName());
            case R.color.theme_color_primary_trans:
                return context.getResources().getIdentifier(theme + "_trans", "color", getPackageName());
        }
        return colorId;
    }
}
