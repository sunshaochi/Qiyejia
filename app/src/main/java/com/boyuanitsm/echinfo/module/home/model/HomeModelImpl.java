package com.boyuanitsm.echinfo.module.home.model;

import com.boyuanitsm.echinfo.callback.RequestCallback;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.FindManager;

/**
 * 数据接口代理类
 * Created by wangbin on 16/12/23.
 */
public class HomeModelImpl implements IHomeModel{

    @Override
    public void getMyAttention(RequestCallback<String> callback) {

    }

    @Override
    public void getHotCompany(String type,ResultCallback callback) {
        FindManager.getFindManager().getHotSearchHistory(type,callback);
    }

    @Override
    public void getDishonesty(RequestCallback<String> callback) {

    }
}
