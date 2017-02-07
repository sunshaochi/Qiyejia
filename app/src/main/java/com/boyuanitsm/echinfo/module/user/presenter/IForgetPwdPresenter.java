package com.boyuanitsm.echinfo.module.user.presenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/7.
 */

public interface IForgetPwdPresenter extends BasePresenter {
    void getSms(String phoneNumber,String isRegister);

}
