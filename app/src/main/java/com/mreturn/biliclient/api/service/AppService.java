package com.mreturn.biliclient.api.service;

import com.mreturn.biliclient.adapter.home.RecommendBannerInfo;
import com.mreturn.biliclient.adapter.home.RecommendInfo;
import com.mreturn.biliclient.bean.UserArchiveInfo;
import com.mreturn.biliclient.bean.UserInfo;
import com.mreturn.biliclient.bean.UserSeasonInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mReturn
 * on 2017/7/10.
 */

public interface AppService {
    /**
     * 首页推荐banner
     */
    @GET("x/banner?plat=4&build=411007&channel=bilih5")
    Observable<RecommendBannerInfo> getRecommendedBannerInfo();

    /**
     * 首页推荐数据
     */
    @GET("x/show/old?platform=android&device=&build=412001")
    Observable<RecommendInfo> getRecommendedInfo();

    /**
     * 用户信息
     */
    @GET("x/v2/space?access_key=&appkey=1d8b6e7d45233436&build=506000&from=0" +
            "&mobi_app=android&platform=android&ps=10")
    Observable<UserInfo> getUserInfo(@Query("vmid") int vmid);

    /**
     * 用户信息
     */
    @GET("/x/v2/space/archive?access_key=&appkey=1d8b6e7d45233436&build=506000" +
            "&mobi_app=android&platform=android&ps=10")
    Observable<UserArchiveInfo> getArchive(@Query("pn") int pageNum, @Query("vmid") int vmid);

    /**
     * 用户信息
     */
    @GET("/x/v2/space/bangumi?access_key=&appkey=1d8b6e7d45233436&build=506000" +
            "&mobi_app=android&platform=android&ps=10")
    Observable<UserSeasonInfo> getSeason(@Query("pn") int pageNum, @Query("vmid") int vmid);
}
