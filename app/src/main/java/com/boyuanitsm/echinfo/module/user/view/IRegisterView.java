package com.boyuanitsm.echinfo.module.user.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.UserBean;

/**
 * 注册
 * Q164454216
 * Created by xiaoke on 2017/2/6.
 */

public interface IRegisterView extends BaseView {
    void getSmsSucess(String sucessMsg);
    void getSmsFaild(int status, String errorMsg);
    void toRegisterSucess(UserBean userBean,String sucessMsg);
    void toRegisterFaild(int status,String errorMsg);
}
