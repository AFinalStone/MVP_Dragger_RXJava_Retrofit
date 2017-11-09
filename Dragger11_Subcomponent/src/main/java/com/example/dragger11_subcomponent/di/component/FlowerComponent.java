package com.example.dragger11_subcomponent.di.component;


import com.example.dragger11_subcomponent.di.module.FlowerModule;
import com.example.dragger11_subcomponent.di.module.PotModule;

import dagger.Component;

@Component(modules = FlowerModule.class)
public interface FlowerComponent {

    PotComponent plus(PotModule potModule);
}