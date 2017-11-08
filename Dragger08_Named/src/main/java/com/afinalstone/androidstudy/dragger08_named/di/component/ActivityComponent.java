package com.afinalstone.androidstudy.dragger08_named.di.component;


import com.afinalstone.androidstudy.dragger08_named.MainActivity;
import com.afinalstone.androidstudy.dragger08_named.di.module.FlowerModule;

import dagger.Component;

@Component(modules = {FlowerModule.class})
public interface ActivityComponent {
    void inject(MainActivity activity);
}