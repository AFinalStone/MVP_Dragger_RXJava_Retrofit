package com.codeest.geeknews.ui.login;

import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.afinalstone.application.R;
import com.codeest.geeknews.base.BaseActivity;
import com.codeest.geeknews.bean.GankItemBean;

import butterknife.BindView;

/**
 * Created by codeest on 2016/8/2.
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.test)
    TextView mTest;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData() {
        setToolBar(mToolBar, "福利标题");
        mPresenter.getUserCardData(21001035, "3036318864", 21001043);
    }

    @Override
    public void showResult(GankItemBean info) {
        mTest.setText(info.toString());
    }
}