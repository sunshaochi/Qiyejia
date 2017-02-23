package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.BrandBean;

import java.util.List;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/23.
 */
public interface IFindBrandInfoView extends BaseView{

    void getBrandListSucess(List<BrandBean> list);
    void getBrandListFaild(int status,String sucessMsg);
    void getBrandNodata();
}
