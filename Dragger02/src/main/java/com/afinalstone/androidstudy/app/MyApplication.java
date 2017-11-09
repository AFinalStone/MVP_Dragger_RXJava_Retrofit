package com.afinalstone.androidstudy.app;

import android.app.Application;

import com.afinalstone.androidstudy.di.component.AppComponent;
import com.afinalstone.androidstudy.DaggerAppComponent;
import com.afinalstone.androidstudy.di.module.ApiModule;

public class MyApplication extends Application {


    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}