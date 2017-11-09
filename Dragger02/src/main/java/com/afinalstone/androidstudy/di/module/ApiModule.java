package com.afinalstone.androidstudy.di.module;

import com.afinalstone.androidstudy.bean.User;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class ApiModule {
    public static final String END_POINT = "http://www.baidu.com";


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .build();
        return client;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(END_POINT)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    User provideUser(){
        return new User("name form ApiProvide","女");
    }

}