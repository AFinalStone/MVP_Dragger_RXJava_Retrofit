package com.example.rxjava_retrofit.http;

import com.example.rxjava_retrofit.http.bean.Item;
import com.example.rxjava_retrofit.http.response.GankHttpResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by codeest on 2016/8/3.
 */
public interface HttpHelper {
    public  Flowable<GankHttpResponse<List<Item>>> getAndroidData(int page);

}
