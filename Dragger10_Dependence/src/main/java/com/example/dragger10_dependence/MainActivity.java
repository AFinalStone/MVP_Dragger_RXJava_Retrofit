package com.example.dragger10_dependence;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dragger10_dependence.bean.Pot;
import com.example.dragger10_dependence.di.component.DaggerFlowerComponent;
import com.example.dragger10_dependence.di.component.DaggerMainActivityComponent;
import com.example.dragger10_dependence.di.component.DaggerPotComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Pot pot;

    @Inject
    Pot pot01;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
        }
    };

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        DaggerMainActivityComponent.builder()
//                .potComponent(DaggerPotComponent.builder().flowerComponent(DaggerFlowerComponent.create()).build())
//                .build().inject(this);

        DaggerMainActivityComponent.builder()
                .potComponent(DaggerPotComponent.builder().flowerComponent(DaggerFlowerComponent.create()).build())
                .build().inject(this);

        String show = pot.show();
        Toast.makeText(this, show, Toast.LENGTH_SHORT).show();
        Log.e("MainActivity",""+pot);
        Log.e("MainActivity_pot01",""+pot01);
        handler.sendEmptyMessageDelayed(0,2000);
    }

}
