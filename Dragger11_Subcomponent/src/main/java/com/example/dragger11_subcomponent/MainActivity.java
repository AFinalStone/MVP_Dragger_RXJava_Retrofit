package com.example.dragger11_subcomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dragger11_subcomponent.bean.Pot;
import com.example.dragger11_subcomponent.di.component.DaggerFlowerComponent;
import com.example.dragger11_subcomponent.di.module.PotModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Pot pot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerFlowerComponent.create()
                .plus(new PotModule())  // 这个方法返回PotComponent
                .plus()                 // 这个方法返回MainActivityComponent
                .inject(this);

        String show = pot.show();
        Toast.makeText(MainActivity.this, show, Toast.LENGTH_SHORT).show();
    }
}
