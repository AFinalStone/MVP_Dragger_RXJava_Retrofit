package com.example.rxjava_retrofit.http;

/**
 * Created by Administrator on 2017/11/20.
 */

public interface ServiceFactory {
    public <T> T createService(Class<T> serviceClass, String baseUrl);
}
