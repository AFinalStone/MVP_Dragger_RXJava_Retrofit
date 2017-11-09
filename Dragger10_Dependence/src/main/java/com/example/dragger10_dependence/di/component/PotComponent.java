package com.example.dragger10_dependence.di.component;

import com.example.dragger10_dependence.MainActivity;
import com.example.dragger10_dependence.bean.Pot;
import com.example.dragger10_dependence.di.module.PotModule;


import javax.inject.Singleton;

import dagger.Component;

//@Singleton
@Component(modules = PotModule.class,dependencies = FlowerComponent.class)
public interface PotComponent {
    Pot getPot();
}