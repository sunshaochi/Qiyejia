package com.boyuanitsm.echinfo.module.mine.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.UserManager;

/**
 * Created by bitch-1 on 2017/2/17.
 */
public class FollowModelImpl implements FollowModel {
    @Override
    public void getFollowDatas(ResultCallback resultCallback) {
        UserManager.getUserManager().FindMyAtt(resultCallback);
    }
}
