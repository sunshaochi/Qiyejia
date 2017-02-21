package com.boyuanitsm.echinfo.module.mine.view;

import com.boyuanitsm.echinfo.base.BaseView;

/**
 * 我的资料修改头像
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public interface IMineMsgView extends BaseView {
    void upLoadHeadSucess(String sucessMsg);
    void upLoadHeadFaild(int status,String errorMsg);
}
