package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenter;

/**
 * 查企业、经营，高管
 * Q164454216
 * Created by xiaoke on 2017/2/14.
 */

public interface IJingYingPre extends BasePresenter {
    void  getQiYeinfo(String companyName, String address, String industry, String capital, String establishDate, int page, int rows);
    void  getQiYeinfobyJyFw(String businessScope, String address, String industry, String capital, String establishDate, int page, int rows);
    void  getQiYeinfobyPinPai(String webAddress, String address, String industry, String capital, String establishDate, int page, int rows);

}
