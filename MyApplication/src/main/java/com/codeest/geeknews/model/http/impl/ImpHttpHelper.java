package com.codeest.geeknews.model.http.impl;

import com.codeest.geeknews.bean.GankItemBean;
import com.codeest.geeknews.bean.Item;
import com.codeest.geeknews.model.http.HttpHelper;
import com.codeest.geeknews.model.http.api.GankService;
import com.codeest.geeknews.model.http.response.GankHttpResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Administrator on 2017/11/20.
 */

public class ImpHttpHelper implements HttpHelper {

    GankService gankService;

    @Inject
    public ImpHttpHelper(GankService gankService) {
        this.gankService = gankService;
    }


    @Override
    public Flowable<GankHttpResponse<List<GankItemBean>>> getAndroidData(int page) {
        return gankService.getAndroidData(page);
    }

    @Override
    public Flowable<GankHttpResponse<List<GankItemBean>>> getGirlList(int num, int page) {
        return gankService.getGirlList(num,page);
    }
}
