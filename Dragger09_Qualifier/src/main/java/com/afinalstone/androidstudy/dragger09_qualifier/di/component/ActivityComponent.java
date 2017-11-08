package com.afinalstone.androidstudy.dragger09_qualifier.di.component;


import com.afinalstone.androidstudy.dragger09_qualifier.MainActivity;
import com.afinalstone.androidstudy.dragger09_qualifier.di.module.FlowerModule;

import dagger.Component;

@Component(modules = {FlowerModule.class})
public interface ActivityComponent {
    void inject(MainActivity activity);
}