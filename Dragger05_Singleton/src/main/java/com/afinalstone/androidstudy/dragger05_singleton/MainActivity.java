package com.afinalstone.androidstudy.dragger05_singleton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.afinalstone.androidstudy.dragger05_singleton.bean.User;
import com.afinalstone.androidstudy.dragger05_singleton.di.component.DaggerMainActivityComponent;
import com.afinalstone.androidstudy.dragger05_singleton.di.model.UserModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerMainActivityComponent.builder().userModel(new UserModel()).build().inject(this);
        textViewMsg.setText("User01的hash码："+line+user01+line+"User02的hash码"+line+user02);
    }

    private void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
