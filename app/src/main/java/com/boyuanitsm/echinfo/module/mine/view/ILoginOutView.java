package com.boyuanitsm.echinfo.module.mine.view;

import com.boyuanitsm.echinfo.base.BaseView;

/**
 * 退出
 * Q164454216
 * Created by xiaoke on 2017/2/20.
 */

public interface ILoginOutView extends BaseView {
    //退出成功
    void loginOutSucess(String sucessMsg);
    //退出失败
    void loginOutFaild(int status,String errorMsg);


}
