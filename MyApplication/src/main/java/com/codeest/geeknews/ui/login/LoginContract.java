package com.codeest.geeknews.ui.login;

import com.codeest.geeknews.base.BasePresenter;
import com.codeest.geeknews.base.BaseView;
import com.codeest.geeknews.bean.GankItemBean;

/**
 * Created by codeest on 2016/8/2.
 */
public interface LoginContract {

    interface View extends BaseView {

        void showResult(GankItemBean info);
    }

    interface Presenter extends BasePresenter<View> {

        void getUserCardData(int uid,String token,int otherId);
    }
}
