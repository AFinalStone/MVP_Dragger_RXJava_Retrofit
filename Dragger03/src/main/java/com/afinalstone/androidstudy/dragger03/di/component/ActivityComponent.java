package com.afinalstone.androidstudy.dragger03.di.component;

import android.content.Context;

import com.afinalstone.androidstudy.dragger03.di.model.VpAdapterModule;
import com.afinalstone.androidstudy.dragger03.ui.MainActivity;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;

/**
 * Created by Administrator on 2017/11/6.
 */

@Component(modules = VpAdapterModule.class)
public interface  ActivityComponent {
    void inject(MainActivity context);
}
