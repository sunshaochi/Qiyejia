package com.boyuanitsm.echinfo.module.mine.view;

import com.boyuanitsm.echinfo.base.BaseView;

/**
 * 修改资料
 * Q164454216
 * Created by xiaoke on 2017/2/7.
 */

public interface IModifyUserView  extends BaseView{
   void  modifyUserSucess(String sucessMsg);
    void modifyUserFaild(int status, String errorMsg);
    void  modifyPwdSucess(String sucessMsg);
    void modifyPwdFaild(int status,String errorMsg);
}
