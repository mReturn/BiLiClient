package com.mreturn.biliclient.api.service;

import com.mreturn.biliclient.bean.HotSearchTag;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by mReturn
 * on 2017/7/17.
 */
public interface SearchService {
    /**
     * 首页发现热搜词
     */
    @GET(
            "main/hotword?access_key=ec0f54fc369d8c104ee1068672975d6a&actionKey=appkey&appkey=27eb53fc9058f8c3")
    Observable<HotSearchTag> getHotSearchTags();
}
