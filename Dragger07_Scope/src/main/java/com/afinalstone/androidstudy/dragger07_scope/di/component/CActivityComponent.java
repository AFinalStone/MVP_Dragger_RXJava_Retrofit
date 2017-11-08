package com.afinalstone.androidstudy.dragger07_scope.di.component;

import com.afinalstone.androidstudy.dragger07_scope.di.model.CUserModule;
import com.afinalstone.androidstudy.dragger07_scope.ui.CActivity;

import dagger.Component;

@Component(modules = CUserModule.class)
public interface CActivityComponent {  
    void inject(CActivity activity);
}  