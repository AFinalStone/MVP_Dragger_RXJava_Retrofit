package com.afinalstone.androidstudy.dragger04.di.model;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.afinalstone.androidstudy.dragger04.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private AppCompatActivity appCompatActivity;

    public AppModule(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    FragmentManager providesFragmentManager() {
        return appCompatActivity.getSupportFragmentManager();
    }

    @Provides
    List<String> providesTitles() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            list.add("张三:" + i);
        }
        return list;
    }

    @Provides
    List<Fragment> providesFragmentsList() {
        List<Fragment> fragments = new ArrayList<>();
        List<String> listImageUrls = new ArrayList<>();
        listImageUrls.add("http://pic26.photophoto.cn/20130323/0005018467298586_b.jpg");
        listImageUrls.add("http://pic2.16pic.com/00/24/38/16pic_2438497_b.jpg");
        for (int i = 0; i < 2; i++) {
            fragments.add(BaseFragment.getInstance(listImageUrls.get(i)));
        }
        return fragments;
    }

    @Provides
    String providesTests() {

        return "测试";
    }

}  