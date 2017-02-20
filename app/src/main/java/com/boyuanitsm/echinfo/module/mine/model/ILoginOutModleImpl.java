package com.boyuanitsm.echinfo.module.mine.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.UserManager;

/**
 * 退出接口实现类
 * Q164454216
 * Created by xiaoke on 2017/2/20.
 */

public class ILoginOutModleImpl implements IloginOutModle {


    @Override
    public void loginOut(ResultCallback callback) {
        UserManager.getUserManager().loginOut(callback);
    }
}
