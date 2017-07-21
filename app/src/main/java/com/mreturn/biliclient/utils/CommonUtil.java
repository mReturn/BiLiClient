package com.mreturn.biliclient.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by mReturn
 * on 2017/7/13.
 */

public class CommonUtil {

    /**
     * 读取assets下的json数据
     * @param context
     * @param assetsName assets文件名
     * @return
     */
    public static String readAssetsJson(Context context,String assetsName){
        AssetManager assetManager = context.getAssets();
        try {
            InputStream inputStream = assetManager.open(assetsName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String str;
            while ((str = bufferedReader.readLine()) != null){
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void initWebView(Context context, WebView webView) {
        WebSettings webSettings = webView.getSettings();
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
//        //缩放操作
//        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
//        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
//        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        //JavaScript
        webSettings.setJavaScriptEnabled(true);  //设置支持Javascript
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        //缓存
        webSettings.setAppCacheEnabled(true);
        webSettings.setAppCachePath(context.getDir("cache", 0).getPath());
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setDomStorageEnabled(true);
        //其他
        webSettings.setGeolocationEnabled(true); //定位
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        //settings.setBlockNetworkImage(true);    //设置网页在加载的时候暂时不加载图片(Android4.4中可能无法显示图片)

    }
}
