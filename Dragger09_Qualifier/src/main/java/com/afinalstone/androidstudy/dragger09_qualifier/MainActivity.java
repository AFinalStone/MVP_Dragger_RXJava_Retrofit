package com.afinalstone.androidstudy.dragger09_qualifier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.afinalstone.androidstudy.dragger09_qualifier.bean.Pot;
import com.afinalstone.androidstudy.dragger09_qualifier.di.component.DaggerActivityComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Pot mPot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent.create().inject(this);
        Log.e("MainActivity", "onCreate: " + mPot);
    }
}
