package com.mreturn.biliclient.utils;

import android.util.Log;

public class MyLog {
    private static final boolean DEBUG = true;
    private static final String BiLiLog = "biliClient-->";

    public static void d(String tag, String msg) {
        if (DEBUG)
            Log.d(BiLiLog + tag, BiLiLog + msg);
    }

    public static void e(String tag, String msg) {
        if (DEBUG)
            Log.e(BiLiLog + tag, BiLiLog + msg);
    }

    public static void e(String msg) {
        if (DEBUG)
            Log.e(BiLiLog, BiLiLog + msg);
    }

    public static void e(String tag, int msg) {
        if (DEBUG)
            Log.e(BiLiLog + tag, BiLiLog + msg);
    }

    public static void e(String tag, float msg) {
        if (DEBUG)
            Log.e(BiLiLog + tag, BiLiLog + msg);
    }

    public static void e(String tag, String msg, Throwable e) {
        if (DEBUG)
            Log.e(BiLiLog + tag, BiLiLog + msg, e);
    }

    public static void i(String tag, String msg) {
        if (DEBUG)
            Log.i(BiLiLog + tag, BiLiLog + msg);
    }

    public static void w(String tag, String msg) {
        if (DEBUG)
            Log.i(BiLiLog + tag, BiLiLog + msg);
    }
}
