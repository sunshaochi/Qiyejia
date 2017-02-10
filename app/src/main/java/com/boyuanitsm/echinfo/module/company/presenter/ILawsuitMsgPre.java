package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * 诉讼信息
 * Created by wangbin on 17/2/10.
 */
public interface ILawsuitMsgPre extends BasePresenter{

    void getLawsuitMsgDatas(String companyId);
}
