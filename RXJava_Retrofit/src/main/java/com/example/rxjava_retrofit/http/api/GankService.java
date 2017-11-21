package com.example.rxjava_retrofit.http.api;

import com.example.rxjava_retrofit.http.bean.Item;
import com.example.rxjava_retrofit.http.response.GankHttpResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by codeest on 16/8/19.
 */

public interface GankService {
    String BASE_URL = "http://www.gank.io/api/";

    @GET("data/all/20/{page}")
    Flowable<GankHttpResponse<List<Item>>> getAndroidData(@Path("page") int page);
}