package com.boyuanitsm.echinfo.module.company.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.ProductBean;

import java.util.List;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/23.
 */
public interface IProductInfoView  extends BaseView{

    void getProductListSucess(List<ProductBean> list);
    void getProductListFaild(int status,String errorMsg);

    void getProductNodata();
}
