package com.afinalstone.androidstudy.dragger07_scope.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.afinalstone.androidstudy.dragger07_scope.R;
import com.afinalstone.androidstudy.dragger07_scope.app.MyApplication;
import com.afinalstone.androidstudy.dragger07_scope.bean.User;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_b);
        ButterKnife.bind(this);
        ((MyApplication)getApplication()).getActivityComponent().inject(this);
        textViewMsg.setText("User01的hash码："+line+user01+line+"User02的hash码"+line+user02);
    }
}
