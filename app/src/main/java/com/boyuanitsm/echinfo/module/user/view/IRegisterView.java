package com.boyuanitsm.echinfo.module.user.view;

import com.boyuanitsm.echinfo.base.BaseView;

/**
 * 注册
 * Q164454216
 * Created by xiaoke on 2017/2/6.
 */

public interface IRegisterView extends BaseView {
    void getSmsSucess(String sucessMsg);
    void getSmsFaild(int status, String errorMsg);
    void toRegisterSucess(String sucessMsg);
    void toRegisterFaild(int status,String errorMsg);
}
