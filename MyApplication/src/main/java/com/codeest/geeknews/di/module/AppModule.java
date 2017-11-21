package com.codeest.geeknews.di.module;

import com.codeest.geeknews.app.App;
import com.codeest.geeknews.di.ContextLife;
import com.codeest.geeknews.model.http.HttpHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    App provideApplicationContext() {
        return application;
    }

}
