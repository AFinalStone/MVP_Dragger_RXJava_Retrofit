package com.example.rxjava_retrofit.http.impl;

import com.example.rxjava_retrofit.app.Constants;
import com.example.rxjava_retrofit.http.ServiceFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpServiceFactory implements ServiceFactory {

    private final Gson mGsonDateFormat;
//    public  ImpServiceFactory impServiceFactory;

    public ImpServiceFactory() {
        mGsonDateFormat = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
    }

    /**
     * create a service
     *
     * @param serviceClass
     * @param <T>
     * @return
     */
    @Override
    public <T> T createService(Class<T> serviceClass, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(mGsonDateFormat))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

//    @Override
//    public ServiceFactory getInstance() {
//        if(impServiceFactory == null){
//            impServiceFactory = new ImpServiceFactory();
//        }
//        return impServiceFactory;
//    }

    private final static long DEFAULT_TIMEOUT = 10;

    private OkHttpClient getOkHttpClient() {
        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        //设置超时时间
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        //设置缓存
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        httpClientBuilder.cache(cache);
        return httpClientBuilder.build();
    }
}
