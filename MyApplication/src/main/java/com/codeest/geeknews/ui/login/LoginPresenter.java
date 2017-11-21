package com.codeest.geeknews.ui.login;

import com.codeest.geeknews.base.RxPresenter;
import com.codeest.geeknews.bean.GankItemBean;
import com.codeest.geeknews.bean.Item;
import com.codeest.geeknews.model.http.HttpHelper;
import com.codeest.geeknews.model.http.response.GankHttpResponse;
import com.codeest.geeknews.util.LogUtil;
import com.codeest.geeknews.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by codeest on 2016/8/2.
 */
public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter {

    private HttpHelper mHttpHelper;

    @Inject
    public LoginPresenter(HttpHelper mHttpHelper) {
        this.mHttpHelper = mHttpHelper;
    }

    @Override
    public void getUserCardData(int uid, String token, int otherId) {

        mHttpHelper.getAndroidData(10)
                .compose(RxUtil.<GankHttpResponse<List<GankItemBean>>>rxSchedulerHelper())
                .subscribe(new Consumer<GankHttpResponse<List<GankItemBean>>>() {
                    @Override
                    public void accept(@NonNull GankHttpResponse<List<GankItemBean>> itemGankResultBean) throws Exception {
                        LogUtil.d("getAndroidData测试");
                        LogUtil.d(itemGankResultBean.getResults().get(0).toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        LogUtil.d("getAndroidData测试+Throwable："+throwable.getMessage());
                    }
                });

        mHttpHelper.getGirlList(10,10)
                .compose(RxUtil.<GankHttpResponse<List<GankItemBean>>>rxSchedulerHelper())
                .subscribe(new Consumer<GankHttpResponse<List<GankItemBean>>>() {
                    @Override
                    public void accept(@NonNull GankHttpResponse<List<GankItemBean>> listGankHttpResponse) throws Exception {
                         LogUtil.d(listGankHttpResponse.getResults().toString());
                        mView.showResult(listGankHttpResponse.getResults().get(0));
                    }
                });
    }
}
