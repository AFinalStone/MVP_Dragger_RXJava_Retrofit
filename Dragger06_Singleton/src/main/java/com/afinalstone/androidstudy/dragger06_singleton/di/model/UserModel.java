package com.afinalstone.androidstudy.dragger06_singleton.di.model;

import com.afinalstone.androidstudy.dragger06_singleton.bean.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/8.
 */

@Module
public class UserModel {

    @Provides
    @Singleton
    User providesUser() {
        return new User("小红",false);
    }
}
