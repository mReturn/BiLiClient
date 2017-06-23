package com.mreturn.bilibili.utils;

import android.view.Window;
import android.view.WindowManager;

/**
 * Created by mReturn
 * on 2017/6/21.
 */

public class SystemUiUtil {

    /**
     * 是否显示状态栏
     * @param window
     * @param show true 显示  false 隐藏
     */
    public static void showStatusBar(Window window,boolean show){
        WindowManager.LayoutParams params = window.getAttributes();
        if (show){
            params.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }else {
            params.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        }
        window.setAttributes(params);
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}
