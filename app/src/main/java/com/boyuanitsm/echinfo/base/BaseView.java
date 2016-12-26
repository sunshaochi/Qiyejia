package com.boyuanitsm.echinfo.base;

import android.os.Bundle;

/**
 * 视图基类
 * Created by wangbin on 16/12/22.
 */
public interface BaseView {

    void toast(String msg);

    void showProgress();

    void hideProgress();
    //打开activity不带数据
    void openActivity(Class<?> pClass);
    //打开activity带数据
    void openActivity(Class<?> pClass, Bundle pBundle);
}
