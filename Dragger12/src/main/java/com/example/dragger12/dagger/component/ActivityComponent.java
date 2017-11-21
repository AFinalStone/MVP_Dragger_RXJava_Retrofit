package com.example.dragger12.dagger.component;


import com.example.dragger12.MainActivity;
import com.example.dragger12.dagger.model.UserModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/8.
 */

@Singleton
@Component(modules = UserModel.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
