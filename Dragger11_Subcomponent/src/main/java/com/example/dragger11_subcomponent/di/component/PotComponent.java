package com.example.dragger11_subcomponent.di.component;

import com.example.dragger11_subcomponent.di.module.PotModule;

import dagger.Component;
import dagger.Subcomponent;

@Subcomponent(modules = PotModule.class)
public interface PotComponent {
    MainActivityComponent plus();
}