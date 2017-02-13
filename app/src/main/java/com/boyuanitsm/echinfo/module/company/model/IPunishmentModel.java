package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * 行政处罚
 * Created by wangbin on 17/2/10.
 */
public interface IPunishmentModel {

    void getPunishDatas(String companyId, ResultCallback resultCallback);
}
