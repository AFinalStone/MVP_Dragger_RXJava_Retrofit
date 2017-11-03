package com.afinalstone.androidstudy;

import android.app.Application;

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