package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.TaxInfoBean;

import java.util.List;

/**
 *
 * Q164454216
 * Created by xiaoke on 2017/2/22.
 */
public interface ISuiWuInfoView extends BaseView {

    void  getISuiWuInfoSucess(List<TaxInfoBean> datas);
    void  getSuiWuInfoFaild(int status,String errorMsg);
    void getNoData();
}
