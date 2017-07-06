package com.mreturn.biliclient.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mReturn
 * on 2017/7/6.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder{
    private SparseArray<View> mViews;


    public BaseViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();
    }

    public  <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if (view == null){
            view = itemView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }

    public TextView getTextView(int viewId){
        return getView(viewId);
    }

    public ImageView getImageView(int viewId){
        return getView(viewId);
    }

    public void setText(int viewId,String text){
        TextView textView = getView(viewId);
        if (!TextUtils.isEmpty(text))
            textView.setText(text);
    }

    public void setImgResource(int viewId,int resId){
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resId);
    }

    public void setClickListener(int viewId, View.OnClickListener listener){
        View view = getView(viewId);
        view.setOnClickListener(listener);

    }

    public void setSimClickListener(View.OnClickListener listener, int... viewId ){
        for (int id :viewId){
            setClickListener(id,listener);
        }
    }

}
