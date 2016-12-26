package com.boyuanitsm.echinfo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

import com.boyuanitsm.tools.utils.MyToastUtils;

import butterknife.ButterKnife;

/**
 * 基础类
 * Created by wangbin on 16/12/22.
 */
public abstract class BaseAct<T extends BasePresenter> extends FragmentActivity implements BaseView {

    /**
     * 将代理类通用行为抽出来
     */
    protected T mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 手机窗口设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(View.inflate(this,getLayout(),null));
        //注入控件
        ButterKnife.bind(this);
        init(savedInstanceState);
    }

    /**
     * 设置布局
     */
    public abstract int  getLayout();

    /**
     * 填充数据
     */
    public abstract void init(Bundle savedInstanceState);


    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


        if (mPresenter != null) {
            mPresenter.onDestroy();
        }

    }

    @Override
    public void toast(String msg) {
        MyToastUtils.showShortToast(getApplicationContext(),msg);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void openActivity(Class<?> pClass) {
        openActivity(pClass, null);
    }

    @Override
    public void openActivity(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }
}
