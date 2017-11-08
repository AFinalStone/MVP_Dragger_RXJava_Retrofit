package com.afinalstone.androidstudy.dragger04.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.afinalstone.androidstudy.dragger04.R;
import com.afinalstone.androidstudy.dragger04.di.component.DaggerActivityComponent;
import com.afinalstone.androidstudy.dragger04.di.model.AppModule;
import com.afinalstone.androidstudy.dragger04.ui.adapter.MyAdapter;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Inject
    public MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.bind(this);
        DaggerActivityComponent.builder().appModule(new AppModule(this)).build().inject(this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
