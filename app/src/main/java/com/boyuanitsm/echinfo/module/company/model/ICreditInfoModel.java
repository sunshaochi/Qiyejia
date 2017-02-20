package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 获取失信信息
 * Q164454216
 * Created by xiaoke on 2017/2/20.
 */

public interface ICreditInfoModel {
    void getCreditList(String sid, ResultCallback callback);
}
