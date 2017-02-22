package com.boyuanitsm.echinfo.module.home.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.CompanyBean;

import java.util.List;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/22.
 */
public interface ISearchHotView extends BaseView {

    //获取企业热门搜索
    void getHotHistorySucess(List<CompanyBean> suceessMsg);
    void getHotHistoryFaild(int status,String errorMsg);

    void getNodata();
}
