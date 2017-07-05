package com.mreturn.bilibili.utils;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;

import com.mreturn.bilibili.app.BiLiApplication;

/**
 * Created by mReturn
 * on 2017/6/23.
 * Toast 工具类
 */

public class ToastUtil {

    private static Toast toast;
    private static Handler mHandler = new Handler(BiLiApplication.getInstance().getMainLooper());

    public static void show(final String text){
        if (TextUtils.isEmpty(text)) return;
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (toast == null){
                    toast = Toast.makeText(BiLiApplication.getInstance(),text,Toast.LENGTH_SHORT);
                }else {
                    toast.setText(text);
                }
                toast.show();
            }
        });
    }

    public static void show(int resId){
        show(BiLiApplication.getInstance().getString(resId));
    }
}
