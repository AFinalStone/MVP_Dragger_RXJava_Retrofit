package com.example.dragger10_dependence.di.component;

import com.example.dragger10_dependence.bean.Flower;
import com.example.dragger10_dependence.di.module.FlowerModule;
import com.example.dragger10_dependence.di.qualifier.LilyFlower;
import com.example.dragger10_dependence.di.qualifier.RoseFlower;

import dagger.Component;

@Component(modules = FlowerModule.class)
public interface FlowerComponent {
    @RoseFlower
    Flower geRoseFlower();

    @LilyFlower
    Flower geLilyFlower();
}