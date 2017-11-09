package com.afinalstone.androidstudy.ui.dagger;

import com.afinalstone.androidstudy.bean.User;

public class DaggerPresenter {
    DaggerActivity activity;
    User user;

    public DaggerPresenter(DaggerActivity activity, User user) {
        this.user = user;
        this.activity = activity;
    }

    public void showUserName() {
        activity.showUserName(user.name);
    }

    public void showUserSex() {
        activity.showUserSex(user.sex);
    }
}