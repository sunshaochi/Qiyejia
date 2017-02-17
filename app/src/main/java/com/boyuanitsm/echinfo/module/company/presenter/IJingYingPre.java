package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * 查企业、经营，高管
 * Q164454216
 * Created by xiaoke on 2017/2/14.
 */

public interface IJingYingPre extends BasePresenter {
    void  getQiYeinfo(String companyName, String address, String industry, String capital, String establishDate,boolean isRangeQuery,String screeningRange, int page, int rows);
    void  getQiYeinfobyJyFw(String businessScope, String address, String industry, String capital, String establishDate, int page, int rows);
    //获取商标热门搜索记录
    void getHotHistory(String type);
}
