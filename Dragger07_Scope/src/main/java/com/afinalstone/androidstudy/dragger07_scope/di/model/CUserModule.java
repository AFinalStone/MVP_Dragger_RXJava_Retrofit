package com.afinalstone.androidstudy.dragger07_scope.di.model;

import com.afinalstone.androidstudy.dragger07_scope.bean.User;

import dagger.Module;
import dagger.Provides;

@Module
public class CUserModule {
    @Provides
    User providesUser() {
        return new User("小明", true);
    }
}  