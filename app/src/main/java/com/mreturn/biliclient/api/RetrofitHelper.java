package com.mreturn.biliclient.api;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.mreturn.biliclient.api.service.AppService;
import com.mreturn.biliclient.api.service.BangumiService;
import com.mreturn.biliclient.api.service.LiveService;
import com.mreturn.biliclient.app.BiLiApplication;
import com.mreturn.biliclient.app.Constant;
import com.mreturn.biliclient.utils.CommonUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2017/7/5.
 */

public class RetrofitHelper {

    private static OkHttpClient mokHttpClient;

    static {
        intiHttpClient();
    }

    public static LiveService getLiveApi() {
        return creatApi(LiveService.class, Constant.LIVE_BASE_URL);
    }

    public static AppService getAppApi(){
        return creatApi(AppService.class,Constant.APP_BASE_URL);
    }

    public static BangumiService getBangumiApi(){
        return creatApi(BangumiService.class,Constant.BANGUMI_BASE_URL);
    }


    /**
     * 初始化OKHttpClient
     */
    private static void intiHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mokHttpClient == null) {
            synchronized (RetrofitHelper.class) {
                if (mokHttpClient == null) {
                    //缓存
                    Cache cache = new Cache(new File(BiLiApplication.getInstance().getCacheDir(),
                            "HttpCache"), 1024 * 1024 * 10);
                    mokHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            .addInterceptor(interceptor)
//                            .addNetworkInterceptor(new CacheInterceptor())
                            .addNetworkInterceptor(new StethoInterceptor())
                            .retryOnConnectionFailure(true)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
                            .addInterceptor(new UserAgentInterceptor())
                            .build();
                }
            }
        }
    }

    /**
     * 添加缓存
     */
    private static class CacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            //缓存超时时间 有网时1小时 无网时1天
            int connectMaxAge = 60 * 60;
            int offMaxStale = 60 * 60 * 24;
            Request request = chain.request();
            if (CommonUtils.isNetWorkAvalable(BiLiApplication.getInstance())){
                // 有网时从网络获取
                request = request.newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build();
            }else {
                //没网时取缓存数据
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            Response response = chain.proceed(request);
            if (CommonUtils.isNetWorkAvalable(BiLiApplication.getInstance())){
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control","public, max-age="+connectMaxAge)
                        .build();
            }else {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control","public, only-if-cached, max-stale="+offMaxStale)
                        .build();
            }
            return response;
        }
    }

    /**
     * UA拦截器 B站请求API加上UA才能使用
     */
    private static class UserAgentInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request userAgentRequest = originalRequest.newBuilder()
                    .removeHeader("User-Agent")
                    .addHeader("User-Agent",Constant.COMMON_UA_STR)
                    .build();
            return chain.proceed(userAgentRequest);
        }
    }

    /**
     * 根据baseUrl和api 创建retrofit
     * @param clazz
     * @param baseUrl
     * @param <T>
     * @return
     */
    private static <T> T creatApi(Class<T> clazz, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(mokHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }

}
