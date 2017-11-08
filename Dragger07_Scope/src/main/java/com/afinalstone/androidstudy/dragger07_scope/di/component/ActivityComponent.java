package com.afinalstone.androidstudy.dragger07_scope.di.component;


import com.afinalstone.androidstudy.dragger07_scope.di.scope.UserScope;
import com.afinalstone.androidstudy.dragger07_scope.ui.BActivity;
import com.afinalstone.androidstudy.dragger07_scope.ui.MainActivity;
import com.afinalstone.androidstudy.dragger07_scope.di.model.UserModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/8.
 */

@UserScope
@Component(modules = UserModel.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(BActivity activity);
}
