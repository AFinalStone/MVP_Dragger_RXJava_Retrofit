package com.example.rxjava_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.rxjava_retrofit.app.Constants;
import com.example.rxjava_retrofit.http.HttpHelper;
import com.example.rxjava_retrofit.http.api.GankService;
import com.example.rxjava_retrofit.http.bean.Item;
import com.example.rxjava_retrofit.http.impl.ImpHttpHelper;
import com.example.rxjava_retrofit.http.response.GankHttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view){
        HttpHelper httpHelper = new ImpHttpHelper();

        httpHelper.getAndroidData(10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Consumer<GankHttpResponse<List<Item>>>() {
                      @Override
                      public void accept(@NonNull GankHttpResponse<List<Item>> listGankHttpResponse) throws Exception {
                          Log.e("MainActivity",listGankHttpResponse.getResults().get(0).toString());
                      }
                  });

    }


}
