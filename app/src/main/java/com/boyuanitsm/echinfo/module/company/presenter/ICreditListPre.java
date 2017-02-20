package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * 获取失信信息列表
 * Q164454216
 * Created by xiaoke on 2017/2/20.
 */

public interface ICreditListPre extends BasePresenter {
    void getICrediteByid(String sid);
}
