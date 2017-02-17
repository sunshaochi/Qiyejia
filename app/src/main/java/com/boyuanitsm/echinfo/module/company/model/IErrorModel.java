package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;

/**
 * Created by Administrator on 2017/2/15.
 */

public interface IErrorModel {
    /**
     * 获取纠错列表
     * @param dictType
     * @param resultCallback
     */
    void getErrorCorrectionList(String dictType, ResultCallback resultCallback);

    /**
     * 提交纠错信息
     * @param companyId
     * @param errorParts
     * @param errorContent
     * @param mobileEmailQqNo
     * @param status
     * @param resultCallback
     */
    void submitErrorMsg(String companyId, String errorParts, String errorContent, String mobileEmailQqNo, int status, ResultCallback resultCallback);
}
