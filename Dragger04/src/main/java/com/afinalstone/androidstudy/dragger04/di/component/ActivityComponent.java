package com.afinalstone.androidstudy.dragger04.di.component;


import com.afinalstone.androidstudy.dragger04.ui.MainActivity;
import com.afinalstone.androidstudy.dragger04.di.model.AppModule;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/6.
 */

@Component(modules = AppModule.class)
public interface  ActivityComponent {
    void inject(MainActivity context);
}
