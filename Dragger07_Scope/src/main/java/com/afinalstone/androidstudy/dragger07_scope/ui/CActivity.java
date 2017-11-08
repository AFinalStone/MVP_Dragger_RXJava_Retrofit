package com.afinalstone.androidstudy.dragger07_scope.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.afinalstone.androidstudy.dragger07_scope.R;
import com.afinalstone.androidstudy.dragger07_scope.app.MyApplication;
import com.afinalstone.androidstudy.dragger07_scope.bean.User;
import com.afinalstone.androidstudy.dragger07_scope.di.component.DaggerActivityComponent;
import com.afinalstone.androidstudy.dragger07_scope.di.component.DaggerCActivityComponent;
import com.afinalstone.androidstudy.dragger07_scope.di.model.CUserModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CActivity extends AppCompatActivity {

    @Inject
    User user01;

    @Inject
    User user02;

    @BindView(R.id.textViewMsg)
    TextView textViewMsg;

    String line = System.getProperty("line.separator");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        ButterKnife.bind(this);
        DaggerCActivityComponent.builder().cUserModule(new CUserModule()).build().inject(this);
        textViewMsg.setText("User01的hash码："+line+user01+line+"User02的hash码"+line+user02);
    }
}
