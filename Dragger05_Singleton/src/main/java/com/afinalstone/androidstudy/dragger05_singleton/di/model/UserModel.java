package com.afinalstone.androidstudy.dragger05_singleton.di.model;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/8.
 */

@Module
public class UserModel {

    @Provides
    public String providesGetName() {
        return "小明";
    }

    @Provides
    public boolean providesGetSex() {
        return true;
    }
}
