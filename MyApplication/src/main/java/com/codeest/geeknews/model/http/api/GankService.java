package com.codeest.geeknews.model.http.api;


import com.codeest.geeknews.bean.GankItemBean;
import com.codeest.geeknews.bean.Item;
import com.codeest.geeknews.model.http.response.GankHttpResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by codeest on 16/8/19.
 */

public interface GankService {

    String HOST = "http://www.gank.io/api/";
//http://www.gank.io/api/data/all/20/10
    @GET("data/all/20/{page}")
    Flowable<GankHttpResponse<List<GankItemBean>>> getAndroidData(@Path("page") int page);

    /**
     * 妹纸列表
     */
    //http://www.gank.io/api/data/福利/10/10
    @GET("data/福利/{num}/{page}")
    Flowable<GankHttpResponse<List<GankItemBean>>> getGirlList(@Path("num") int num, @Path("page") int page);
}