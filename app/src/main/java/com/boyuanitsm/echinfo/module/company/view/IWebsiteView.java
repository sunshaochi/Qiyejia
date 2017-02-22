package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.WebsiteBean;

import java.util.List;

/**
 * Created by bitch-1 on 2017/2/22.
 */
public interface IWebsiteView extends BaseView {

    void setData(List<WebsiteBean> data);//网站信息

    void requestError(int status, String errorMsg);

    void requestNoData();
}
