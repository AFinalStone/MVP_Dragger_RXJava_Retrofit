package com.example.dragger10_dependence.di.module;

import com.example.dragger10_dependence.bean.Flower;
import com.example.dragger10_dependence.bean.Lily;
import com.example.dragger10_dependence.bean.Rose;
import com.example.dragger10_dependence.di.qualifier.LilyFlower;
import com.example.dragger10_dependence.di.qualifier.RoseFlower;

import dagger.Module;
import dagger.Provides;

@Module
public class FlowerModule {

    @Provides
    @RoseFlower
    Flower provideRose() {
        return new Rose();
    }

    @Provides
    @LilyFlower
    Flower provideLily() {
        return new Lily();
    }
}
