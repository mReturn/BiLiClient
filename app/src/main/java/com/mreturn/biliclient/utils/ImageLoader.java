package com.mreturn.biliclient.utils;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.mreturn.biliclient.app.BiLiApplication;

/**
 * Created by mReturn
 * on 2017/5/19.
 */

public class ImageLoader {

    //加载手机中图片
    public static void displayLocal(ImageView imageView, String path) {
        Glide.with(BiLiApplication.instance)
                .load(path)
                .centerCrop()
                .into(imageView);
    }
    // 加载资源文件
    public static void displayRes(ImageView imageView, int resId) {
        Glide.with(BiLiApplication.instance)
                .load(resId)
                .centerCrop()
                .into(imageView);
    }

    public static void display(ImageView imageView, String imageUrl) {
        display(imageView, imageUrl, -1);
    }

    //加载时显示默认图
    public static void display(ImageView imageView, String imageUrl, int resId) {
        Glide.with(BiLiApplication.instance)
                .load(imageUrl)
                .placeholder(resId)
                .dontAnimate()
                .error(resId)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new GlideDrawableImageViewTarget(imageView,0));

    }
    //加载Gif
    public static void displayGif(ImageView imageView, String imageUrl, int resId) {
        Glide.with(BiLiApplication.instance)
                .load(imageUrl)
                .centerCrop()
                .error(resId)
                .override(600, 800)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

    }
    //不做处理 会循环播放gif
    public static void displayUnDeal(ImageView imageView, String imageUrl, int resId) {
        Glide.with(BiLiApplication.instance)
                .load(imageUrl)
                .placeholder(resId)
                .error(resId)
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new GlideDrawableImageViewTarget(imageView,0));
    }

    public static void displaylittleImg(ImageView imageView, String imageUrl) {
        Glide.with(BiLiApplication.instance)
                .load(imageUrl)
                .centerCrop()
                .override(600, 800)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    public static void displayCircleImg(final ImageView imageView, String imageUrl) {
        displayCircleImg(imageView, imageUrl, -1);
    }

    public static void displayCircleImg(final ImageView imageView, String imageUrl, int resId) {
        Glide.with(BiLiApplication.instance)
                .load(imageUrl)
                .asBitmap()
                .placeholder(resId)
                .error(resId)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(BiLiApplication.instance.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

}
