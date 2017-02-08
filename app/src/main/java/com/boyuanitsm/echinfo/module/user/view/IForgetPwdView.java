package com.boyuanitsm.echinfo.module.user.view;

import com.boyuanitsm.echinfo.base.BaseView;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/7.
 */

public interface IForgetPwdView extends BaseView {
    void getSmsSucess(String sucessMsg);
    void getSmsFaild(int status, String errorMsg);
    void toResetPwdSucess(String sucessMsg);
    void toResetPwdFaild(int status,String errorMsg);

}
