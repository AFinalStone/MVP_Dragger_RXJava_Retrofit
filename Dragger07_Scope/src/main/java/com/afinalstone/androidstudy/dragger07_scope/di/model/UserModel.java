package com.afinalstone.androidstudy.dragger07_scope.di.model;


import com.afinalstone.androidstudy.dragger07_scope.bean.User;
import com.afinalstone.androidstudy.dragger07_scope.di.scope.UserScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/8.
 */

@Module
public class UserModel {

    public UserModel(){
    }

    @Provides
    @UserScope
    User providesUser() {
        return new User("小红",false);
    }
}
