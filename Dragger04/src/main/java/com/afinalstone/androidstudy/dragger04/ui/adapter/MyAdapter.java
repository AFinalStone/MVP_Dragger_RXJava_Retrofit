package com.afinalstone.androidstudy.dragger04.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import javax.inject.Inject;

public class MyAdapter extends FragmentPagerAdapter {
    private List<String> titles;
    private List<Fragment> fragments;
  
    @Inject
    public MyAdapter(FragmentManager fm, List<String> titles, List<Fragment> fragments,String test) {
        super(fm);  
        this.titles = titles;  
        this.fragments = fragments;  
    }  
  
    @Override  
    public Fragment getItem(int position) {  
        return fragments.get(position);  
    }  
  
    @Override  
    public int getCount() {  
        return fragments.size();  
    }  
  
    @Override  
    public CharSequence getPageTitle(int position) {  
        return titles.get(position);  
    }  
}  
