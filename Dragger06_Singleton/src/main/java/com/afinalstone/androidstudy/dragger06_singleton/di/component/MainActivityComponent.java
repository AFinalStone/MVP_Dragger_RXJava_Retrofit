package com.afinalstone.androidstudy.dragger06_singleton.di.component;

import com.afinalstone.androidstudy.dragger06_singleton.MainActivity;
import com.afinalstone.androidstudy.dragger06_singleton.di.model.UserModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/8.
 */

@Singleton
@Component(modules = UserModel.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
