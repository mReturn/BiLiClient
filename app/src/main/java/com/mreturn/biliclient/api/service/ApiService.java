package com.mreturn.biliclient.api.service;

import com.mreturn.biliclient.bean.VideoCommentInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mReturn
 * on 2017/7/24.
 */

public interface ApiService {
    /**
     * 视频评论
     */
    @GET("feedback")
    Observable<VideoCommentInfo> getVideoComment(
            @Query("aid") int aid,
            @Query("page") int page, @Query("pagesize") int pageSize, @Query("ver") int ver);
}
