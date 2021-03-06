package com.boyuanitsm.echinfo.module.user.presenter;

import com.boyuanitsm.echinfo.base.BasePresenter;
import com.boyuanitsm.echinfo.bean.UserBean;

/**
 * 注册
 * Q164454216
 * Created by xiaoke on 2017/2/6.
 */

public interface IRegisterPresenter extends BasePresenter {
    void getSms(String phoneNumber,String isRegister);
    void toRegister(UserBean user,String captcha);
}
