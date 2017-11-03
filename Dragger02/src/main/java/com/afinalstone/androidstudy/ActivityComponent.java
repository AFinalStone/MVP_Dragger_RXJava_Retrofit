package com.afinalstone.androidstudy;

import dagger.Component;

@ActivityScope
@Component(modules = ActivityModule.class,dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(DaggerActivity daggerActivity);
}