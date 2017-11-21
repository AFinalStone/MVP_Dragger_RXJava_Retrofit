package com.example.dragger12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dragger12.bean.BookBean;
import com.example.dragger12.bean.User;
import com.example.dragger12.dagger.component.DaggerActivityComponent;
import com.example.dragger12.dagger.model.UserModel;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Inject
    User user01;

    @Inject
    User user02;

//    @Inject
//    BookBean book;

    @BindView(R.id.textViewMsg)
    TextView textViewMsg;

    String line = System.getProperty("line.separator");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DaggerActivityComponent.builder().userModel(new UserModel()).build().inject(this);
        textViewMsg.setText("User01的hash码：" + line + user01 + line + "User02的hash码" + line + user02);
//        textViewMsg.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        textViewMsg.setText("bookBean:"+book);
//                    }
//                });
//            }
//        },3000);
    }

    private void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
