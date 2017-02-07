package com.boyuanitsm.echinfo.module.home.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.UserBean;

/**
 * 我的
 * Created by wangbin on 17/2/7.
 */
public interface IMineView extends BaseView{
     /*展示用户信息*/
     void showUser(UserBean userBean);
}
