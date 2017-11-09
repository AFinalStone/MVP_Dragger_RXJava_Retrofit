package com.example.dragger10_dependence.di.component;

import com.example.dragger10_dependence.SecondActivity;

import javax.inject.Singleton;

import dagger.Component;

//@ActivityScope
@Component(dependencies = PotComponent.class)
public interface SecondActivityComponent {
    void inject(SecondActivity activity);
}
