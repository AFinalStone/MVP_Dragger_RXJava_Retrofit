package com.example.dragger11_subcomponent.di.module;


import com.example.dragger11_subcomponent.bean.Flower;
import com.example.dragger11_subcomponent.bean.Lily;
import com.example.dragger11_subcomponent.bean.Rose;
import com.example.dragger11_subcomponent.di.qualifier.LilyFlower;
import com.example.dragger11_subcomponent.di.qualifier.RoseFlower;

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
