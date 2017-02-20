package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.FindManager;

/**
 * 获取失信信息列表
 * Q164454216
 * Created by xiaoke on 2017/2/20.
 */

public class CrediteListModelImpl implements ICreditInfoModel {
    @Override
    public void getCreditList(String sid, ResultCallback callback) {
        FindManager.getFindManager().findLoseCredit(sid,callback);
    }
}
