package com.afinalstone.androidstudy.di.component;

import com.afinalstone.androidstudy.bean.User;
import com.afinalstone.androidstudy.di.module.ApiModule;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {ApiModule.class})
public interface AppComponent {

    OkHttpClient getClient();

    Retrofit getRetrofit();

    User getUser();
}