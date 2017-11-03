package com.afinalstone.androidstudy;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private DaggerActivity activity;

    public ActivityModule(DaggerActivity activity) {
        this.activity = activity;
    }

    @Provides
    public DaggerActivity provideActivity() {
        return activity;
    }

    @Provides
    public DaggerPresenter provideDaggerPresenter(DaggerActivity activity, User user) {
        return new DaggerPresenter(activity, user);
    }
}