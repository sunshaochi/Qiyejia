package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;

/**
 * Created by Administrator on 2017/2/15.
 */

public class ErrorModelImpl implements IErrorModel {
    @Override
    public void getErrorCorrectionList(String dictType, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().getErrorCorrectionList(dictType,resultCallback);
    }

    @Override
    public void submitErrorMsg(String companyId, String errorParts, String errorContent, String mobileEmailQqNo, int status, ResultCallback resultCallback) {
        CompanyManager.getCompanyManager().submitErrorMsg(companyId,errorParts,errorContent,mobileEmailQqNo,status,resultCallback);
    }
}
