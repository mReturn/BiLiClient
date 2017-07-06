package com.mreturn.biliclient.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mReturn
 * on 2017/6/21.
 * 主题切换辅助工具类
 */

public class ThemeHelper {
    private static final String CURRENT_THEME = "current_theme";

    public static final int CARD_PINK = 0x1;

    public static final int CARD_PURPLE = 0x2;

    public static final int CARD_BLUE = 0x3;

    public static final int CARD_GREEN = 0x4;

    public static final int CARD_GREEN_LIGHT = 0x5;

    public static final int CARD_YELLOW = 0x6;

    public static final int CARD_ORANGE = 0x7;

    public static final int CARD_RED = 0x8;

    public static SharedPreferences getSharedPreference(Context context){
        return context.getSharedPreferences("app_theme",Context.MODE_PRIVATE);
    }

    public static void setTheme(Context context,int themeId){
        getSharedPreference(context)
                .edit()
                .putInt(CURRENT_THEME,themeId)
                .apply();
    }

    public static int getTheme(Context context){
        return getSharedPreference(context).getInt(CURRENT_THEME, CARD_PINK);
    }

    public static boolean isDefaultTheme(Context context){
        return getTheme(context) == CARD_PINK;
    }

    public static String getName(int currentTheme){
        switch (currentTheme){
            case CARD_PINK:
                return "THE SAKURA";
            case CARD_BLUE:
                return "THE STORM";
            case CARD_GREEN:
                return "THE WOOD";
            case CARD_GREEN_LIGHT:
                return "THE LIGHT";
            case CARD_PURPLE:
                return "THE HOPE";
            case CARD_YELLOW:
                return "THE THUNDER";
            case CARD_ORANGE:
                return "THE SAND";
            case CARD_RED:
                return "THE FIREY";
        }
        return "THE RETURN";
    }
}
