package com.boyuanitsm.echinfo.module.home.model;

import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;

/**
 * Created by wangbin on 17/2/7.
 */
public class MineModelImpl implements IMineModel{

    @Override
    public UserBean toGetUserBean() {
       return EchinfoUtils.getCurrentUser();
    }
}
