package com.afinalstone.androidstudy.dragger05_singleton.bean;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Administrator on 2017/11/8.
 */

@Singleton
public class User {

    private String name;
    private boolean sex;

    @Inject
    public User(String name, boolean sex) {
        this.name = name;
        this.sex = sex;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", sex=" + sex +
//                '}';
//    }
}
