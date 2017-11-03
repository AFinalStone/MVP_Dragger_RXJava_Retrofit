package com.afinalstone.androidstudy;

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