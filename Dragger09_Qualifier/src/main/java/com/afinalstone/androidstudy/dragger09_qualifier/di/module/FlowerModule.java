package com.afinalstone.androidstudy.dragger09_qualifier.di.module;

import com.afinalstone.androidstudy.dragger09_qualifier.bean.Flower;
import com.afinalstone.androidstudy.dragger09_qualifier.bean.Lily;
import com.afinalstone.androidstudy.dragger09_qualifier.bean.Pot;
import com.afinalstone.androidstudy.dragger09_qualifier.bean.Rose;
import com.afinalstone.androidstudy.dragger09_qualifier.di.qualifier.LilyFlower;
import com.afinalstone.androidstudy.dragger09_qualifier.di.qualifier.RoseFlower;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class FlowerModule{

    @Provides
    @RoseFlower
    Flower provideRose() {
        return new Rose("红玫瑰");
    }

    @Provides
    @LilyFlower
    Flower provideLily() {
        return new Lily("白百合");
    }

    @Provides
    Pot providePot(@RoseFlower Flower rose) {
        return new Pot(rose);
    }
}
