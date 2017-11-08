package com.afinalstone.androidstudy.dragger07_scope.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.afinalstone.androidstudy.dragger07_scope.R;
import com.afinalstone.androidstudy.dragger07_scope.app.MyApplication;
import com.afinalstone.androidstudy.dragger07_scope.bean.User;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        ((MyApplication) getApplication()).getActivityComponent().inject(this);
        textViewMsg.setText("User01的hash码：" + line + user01 + line + "User02的hash码" + line + user02);
    }

    @OnClick({R.id.btn_onClickB, R.id.btn_onClickC})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_onClickB:
                startActivity(new Intent(this,BActivity.class));
                break;
            case R.id.btn_onClickC:
                startActivity(new Intent(this,CActivity.class));
                break;
        }
    }
}
