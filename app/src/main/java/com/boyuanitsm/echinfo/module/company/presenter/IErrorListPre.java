package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * Created by Administrator on 2017/2/15.
 */

public interface IErrorListPre extends BasePresenter{
    void getErrorList(String dictType);
    void subErrorMsg(String companyId, String errorParts, String errorContent, String mobileEmailQqNo, int status);
}
