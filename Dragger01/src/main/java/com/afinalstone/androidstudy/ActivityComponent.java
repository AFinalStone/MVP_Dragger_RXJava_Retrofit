package com.afinalstone.androidstudy;

import dagger.Component;

@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(DaggerActivity daggerActivity);
}