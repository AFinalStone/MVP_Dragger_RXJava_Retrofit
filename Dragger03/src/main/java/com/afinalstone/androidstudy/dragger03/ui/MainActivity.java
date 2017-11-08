package com.afinalstone.androidstudy.dragger03.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.afinalstone.androidstudy.dragger03.R;
import com.afinalstone.androidstudy.dragger03.di.component.DaggerActivityComponent;
import com.afinalstone.androidstudy.dragger03.di.model.VpAdapterModule;
import com.afinalstone.androidstudy.dragger03.ui.adapter.VpAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    ViewPager viewPager;
    @Inject
    VpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent.builder().vpAdapterModule(new VpAdapterModule(this)).build().inject(this);
        viewPager  = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
    }

    public void onQuery(View view){

    }

    public void showMsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
