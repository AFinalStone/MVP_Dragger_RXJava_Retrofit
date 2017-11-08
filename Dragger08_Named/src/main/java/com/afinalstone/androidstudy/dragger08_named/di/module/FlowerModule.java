package com.afinalstone.androidstudy.dragger08_named.di.module;


import com.afinalstone.androidstudy.dragger08_named.bean.Flower;
import com.afinalstone.androidstudy.dragger08_named.bean.Lily;
import com.afinalstone.androidstudy.dragger08_named.bean.Pot;
import com.afinalstone.androidstudy.dragger08_named.bean.Rose;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/8.
 */

@Module
public class FlowerModule {


    @Provides
    Pot providePot(@Named("Lily") Flower rose) {
        return new Pot(rose);
    }

    @Provides
    @Named("Rose")
    Flower provideFlower() {
        return new Rose("红玫瑰");
    }

    @Provides
    @Named("Lily")
    Flower provideLily() {
        return new Lily("白百合");
    }
}
