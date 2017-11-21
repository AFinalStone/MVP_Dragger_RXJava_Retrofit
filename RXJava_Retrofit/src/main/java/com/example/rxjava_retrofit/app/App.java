package com.example.rxjava_retrofit.app;

import android.app.Activity;
import android.app.Application;

import java.util.Set;

/**
 * Created by Administrator on 2017/11/21.
 */

public class App extends Application {

    private static App instance;

    public static synchronized App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
