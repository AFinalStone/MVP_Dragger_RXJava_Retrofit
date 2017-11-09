package com.example.dragger11_subcomponent.di.module;


import com.example.dragger11_subcomponent.bean.Flower;
import com.example.dragger11_subcomponent.bean.Pot;
import com.example.dragger11_subcomponent.di.qualifier.RoseFlower;

import dagger.Module;
import dagger.Provides;

@Module
public class PotModule {

    @Provides
    Pot providePot(@RoseFlower Flower flower) {
        return new Pot(flower);
    }
}