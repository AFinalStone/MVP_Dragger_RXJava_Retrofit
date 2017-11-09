package com.example.dragger10_dependence.di.module;

import com.example.dragger10_dependence.bean.Flower;
import com.example.dragger10_dependence.bean.Pot;
import com.example.dragger10_dependence.di.qualifier.RoseFlower;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PotModule {

    @Provides
//    @Singleton
    Pot providePot(@RoseFlower Flower flower) {
        return new Pot(flower);
    }
}