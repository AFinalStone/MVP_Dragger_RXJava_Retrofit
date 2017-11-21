package com.codeest.geeknews.di.component;

import com.codeest.geeknews.app.App;
import com.codeest.geeknews.di.ContextLife;
import com.codeest.geeknews.di.module.AppModule;
import com.codeest.geeknews.di.module.HttpModule;
import com.codeest.geeknews.model.http.HttpHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    @ContextLife("Application")
    App getContext();  // 提供App的Context

    HttpHelper getHttpHelper();  //提供http的帮助类

}
