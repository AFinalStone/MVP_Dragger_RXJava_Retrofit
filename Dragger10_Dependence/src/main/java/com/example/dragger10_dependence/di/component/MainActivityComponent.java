package com.example.dragger10_dependence.di.component;

import com.example.dragger10_dependence.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

//@ActivityScope
@Component(dependencies = PotComponent.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}