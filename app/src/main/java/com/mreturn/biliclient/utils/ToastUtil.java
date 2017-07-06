package com.mreturn.biliclient.utils;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;

import com.mreturn.biliclient.app.BiLiApplication;

/**
 * Created by mReturn
 * on 2017/7/6.
 */

public class ToastUtil {
    private static Toast toast = null;
    private static Handler mHandler = new Handler(BiLiApplication.getInstance().getMainLooper());

    public static void show(final String txt) {
        if (TextUtils.isEmpty(txt))
            return;
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (toast == null) {
                    toast = Toast.makeText(BiLiApplication.getInstance(), txt, Toast.LENGTH_SHORT);
                } else {
                    toast.setText(txt);
                }
                toast.show();
            }
        });
    }

    public static void show(int resId){
        show(BiLiApplication.getInstance().getString(resId));
    }
}
