package com.example.dragger10_dependence;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dragger10_dependence.bean.Pot;
import com.example.dragger10_dependence.di.component.DaggerFlowerComponent;
import com.example.dragger10_dependence.di.component.DaggerPotComponent;
import com.example.dragger10_dependence.di.component.DaggerSecondActivityComponent;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {

    @Inject
    Pot pot;

    @Inject
    Pot pot01;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        DaggerMainActivityComponent.builder()
//                .potComponent(DaggerPotComponent.builder().flowerComponent(DaggerFlowerComponent.create()).build())
//                .build().inject(this);

        DaggerSecondActivityComponent.builder()
                .potComponent(DaggerPotComponent.builder().flowerComponent(DaggerFlowerComponent.create()).build())
                .build().inject(this);

        String show = pot.show();
        Toast.makeText(this, show, Toast.LENGTH_SHORT).show();
        Log.e("SecondActivity",""+pot);
        Log.e("SecondActivity_pot01",""+pot01);
    }
}
