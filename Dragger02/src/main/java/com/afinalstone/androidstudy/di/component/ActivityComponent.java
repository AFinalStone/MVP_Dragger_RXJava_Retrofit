package com.afinalstone.androidstudy.di.component;

import com.afinalstone.androidstudy.di.scope.ActivityScope;
import com.afinalstone.androidstudy.di.module.ActivityModule;
import com.afinalstone.androidstudy.ui.dagger.DaggerActivity;

import dagger.Component;

@ActivityScope
@Component(modules = ActivityModule.class,dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(DaggerActivity daggerActivity);
}