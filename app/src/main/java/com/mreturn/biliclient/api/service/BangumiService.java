package com.mreturn.biliclient.api.service;

import com.mreturn.biliclient.bean.BangumiAppIndexInfo;
import com.mreturn.biliclient.bean.BangumiRecommendInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by mReturn
 * on 2017/7/11.
 */
public interface BangumiService {

    /**
     * 首页番剧
     */
    @GET("api/app_index_page_v4?build=3940&device=phone&mobi_app=iphone&platform=android")
    Observable<BangumiAppIndexInfo> getBangumiAppIndex();

    /**
     * 首页番剧推荐
     */
    @GET("api/bangumi_recommend?access_key=f5bd4e793b82fba5aaf5b91fb549910a&actionKey=appkey&appkey=27eb53fc9058f8c3&build=3470&cursor=0&device=phone&mobi_app=iphone&pagesize=10&platform=ios&sign=56329a5709c401d4d7c0237f64f7943f&ts=1469613558")
    Observable<BangumiRecommendInfo> getBangumiRecommended();

}
