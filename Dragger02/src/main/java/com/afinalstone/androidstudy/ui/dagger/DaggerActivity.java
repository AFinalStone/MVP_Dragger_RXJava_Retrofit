package com.afinalstone.androidstudy.ui.dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


import com.afinalstone.androidstudy.di.component.AppComponent;
import com.afinalstone.androidstudy.DaggerActivityComponent;
import com.afinalstone.androidstudy.app.MyApplication;
import com.afinalstone.androidstudy.R;
import com.afinalstone.androidstudy.di.module.ActivityModule;

import javax.annotation.Nullable;
import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class DaggerActivity extends AppCompatActivity {

    private static final String TAG = "DaggerActivity";
    TextView text_name;
    TextView text_sex;

    @Inject
    DaggerPresenter presenter;

    @Inject
    OkHttpClient client;

    @Inject
    Retrofit retrofit;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragger);
        text_name = (TextView) findViewById(R.id.text_name);
        text_sex = (TextView) findViewById(R.id.text_sex);
        inject();
        presenter.showUserName();
        presenter.showUserSex();
        Log.i(TAG, "client = " + (client == null ? "null" : client));
        Log.i(TAG, "retrofit = " + (retrofit == null ? "null" : retrofit));
    }

    private void inject() {
        AppComponent appComponent = ((MyApplication) getApplication()).getAppComponent();
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule(this))
                .build().inject(this);
    }

    public void showUserName(String name) {
        text_name.setText(name);
    }

    public void showUserSex(String sex) {
        text_sex.setText(sex);
    }
}
