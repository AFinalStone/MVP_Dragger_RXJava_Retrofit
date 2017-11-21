package com.codeest.geeknews.di.component;

import android.app.Activity;

import com.codeest.geeknews.di.FragmentScope;
import com.codeest.geeknews.di.module.FragmentModule;
import com.codeest.geeknews.model.http.HttpHelper;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    HttpHelper getRetrofitHelper();

    Activity getActivity();

}
