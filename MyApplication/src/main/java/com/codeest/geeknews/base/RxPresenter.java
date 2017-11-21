package com.codeest.geeknews.base;


/**
 * Created by codeest on 2016/8/2.
 */
public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}
