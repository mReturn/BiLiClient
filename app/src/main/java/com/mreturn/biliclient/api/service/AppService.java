package com.mreturn.biliclient.api.service;

import com.mreturn.biliclient.adapter.home.RecommendBannerInfo;
import com.mreturn.biliclient.adapter.home.RecommendInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;

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
}
