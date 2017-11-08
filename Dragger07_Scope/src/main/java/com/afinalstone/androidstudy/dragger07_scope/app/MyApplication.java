package com.afinalstone.androidstudy.dragger07_scope.app;

import android.app.Application;

import com.afinalstone.androidstudy.dragger07_scope.di.component.ActivityComponent;
import com.afinalstone.androidstudy.dragger07_scope.di.component.DaggerActivityComponent;
import com.afinalstone.androidstudy.dragger07_scope.di.model.UserModel;

/**
 * Created by Administrator on 2017/11/8.
 */

public class MyApplication extends Application {

    ActivityComponent activityComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        activityComponent = DaggerActivityComponent.builder().userModel(new UserModel()).build();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
