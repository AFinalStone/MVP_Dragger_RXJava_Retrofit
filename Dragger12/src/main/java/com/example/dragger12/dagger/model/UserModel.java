package com.example.dragger12.dagger.model;

import com.example.dragger12.bean.BookBean;
import com.example.dragger12.bean.User;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/8.
 */

@Module
public class UserModel {

    @Provides
    public String providesName() {
        return "小明";
    }

    @Provides
    public boolean providesSex() {
        return true;
    }

    @Provides
    public BookBean providesBook(BookBean bookBean) {
        return bookBean;
    }

    @Provides
    public User providesUser(String name) {
        return new User(name,false);
    }

}
