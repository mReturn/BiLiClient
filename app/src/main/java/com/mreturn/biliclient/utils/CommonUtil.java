package com.mreturn.biliclient.utils;

import android.content.Context;
import android.content.res.AssetManager;

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
}
