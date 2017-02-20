package com.boyuanitsm.echinfo.module.home.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.AttenBean;
import com.boyuanitsm.echinfo.bean.CompanyBean;

import java.util.List;

/**
 * 首页
 * Created by wangbin on 16/12/23.
 */
public interface IHomeView extends BaseView {

    //获取企业热门搜索
    void getHotHistorySucess(List<CompanyBean> suceessMsg);
    void getHotHistoryFaild(int status,String errorMsg);

    //获取关注
    void setFollowDatas(List<AttenBean>mdatas);
    void requestError(int status, String errorMsg);
    void requestNoData();

}
