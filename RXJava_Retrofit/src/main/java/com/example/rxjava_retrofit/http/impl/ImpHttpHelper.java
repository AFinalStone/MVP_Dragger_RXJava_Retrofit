package com.example.rxjava_retrofit.http.impl;

import com.example.rxjava_retrofit.http.ServiceFactory;
import com.example.rxjava_retrofit.http.api.GankService;
import com.example.rxjava_retrofit.http.HttpHelper;
import com.example.rxjava_retrofit.http.bean.Item;
import com.example.rxjava_retrofit.http.response.GankHttpResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/11/20.
 */

public class ImpHttpHelper implements HttpHelper {

    GankService gankService;

    public ImpHttpHelper() {
        ServiceFactory serviceFactory = new ImpServiceFactory();
        this.gankService = serviceFactory.createService(GankService.class, GankService.BASE_URL);
    }

    @Override
    public Flowable<GankHttpResponse<List<Item>>> getAndroidData(int page) {
        return gankService.getAndroidData(page);
    }
}
