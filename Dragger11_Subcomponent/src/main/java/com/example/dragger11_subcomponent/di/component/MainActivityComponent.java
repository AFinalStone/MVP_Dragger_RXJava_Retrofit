package com.example.dragger11_subcomponent.di.component;


import com.example.dragger11_subcomponent.MainActivity;

import dagger.Component;
import dagger.Subcomponent;

@Subcomponent
public interface MainActivityComponent {
    void inject(MainActivity activity);
}