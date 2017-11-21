package com.codeest.geeknews.model.http;

import com.codeest.geeknews.bean.GankItemBean;
import com.codeest.geeknews.bean.Item;
import com.codeest.geeknews.model.http.response.GankHttpResponse;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by codeest on 2016/8/3.
 */
public interface HttpHelper {

    public Flowable<GankHttpResponse<List<GankItemBean>>> getAndroidData( int page);
    public Flowable<GankHttpResponse<List<GankItemBean>>> getGirlList(int num, int page);
}
