package com.mreturn.biliclient.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;

/**
 * Created by mReturn
 * on 2017/7/21.
 */

public class ClipBoardUtil {
    private ClipboardManager clipboardManager;
    private ClipboardManager newClipboardManager;
    private static ClipBoardUtil instance;
    
    private static boolean isNew(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    public static ClipBoardUtil getInstance(){
        if (instance == null){
            instance = new ClipBoardUtil();
        }
        return instance;
    }
    
    private  void initManager(Context context){
        if (isNew()){
            if (newClipboardManager == null){
                newClipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            }
        }else {
            if (clipboardManager == null){
                clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            }
        }
    }

    /**
     * 保存内容到剪切板
     * @param context
     * @param text
     */
    public  void setText(Context context,CharSequence text){
        if (isNew()){
            initManager(context);
            ClipData clipData = ClipData.newPlainText("simple text",text);
            newClipboardManager.setPrimaryClip(clipData);
        }else {
            initManager(context);
            clipboardManager.setText(text);
        }
    }

    /**
     * 获取剪切板内容
     * @param context
     * @return CharSequence
     */
    public  CharSequence getText(Context context){
        StringBuilder sbd = new StringBuilder();
        if (isNew()){
            initManager(context);
            if ((!newClipboardManager.hasPrimaryClip())){
                return sbd.toString();
            }else {
                ClipData clipData = newClipboardManager.getPrimaryClip();
                int count = clipData.getItemCount();
                for (int i=0;i<count;++i){
                    ClipData.Item item = clipData.getItemAt(i);
                    CharSequence str = item.coerceToText(context);
                    sbd.append(str);
                }
            }
        }else {
            initManager(context);
            sbd.append(clipboardManager.getText());
        }
        return sbd.toString();
    }
    
}
