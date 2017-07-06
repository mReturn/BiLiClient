package com.mreturn.biliclient.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by admin on 2017/7/5.
 */

public class CommonUtils {

    /**
     * 检查是否又网络
     * @param context
     * @return
     */
    public static boolean isNetWorkAvalable(Context context) {
        NetworkInfo info = getNetWorInfo(context);
        return info != null && info.isAvailable();

    }

    //是否是wifi
    public static boolean isWifi(Context context){
        NetworkInfo info = getNetWorInfo(context);
        if (info != null && info.getType() == ConnectivityManager.TYPE_WIFI){
            return true;
        }
        return false;

    }

    //是否是移动网络
    public static boolean isMobile(Context context){
        NetworkInfo info = getNetWorInfo(context);
        if (info != null && info.getType() == ConnectivityManager.TYPE_MOBILE){
            return true;
        }
        return false;

    }



    private static NetworkInfo getNetWorInfo(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }
}
