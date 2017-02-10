package com.boyuanitsm.echinfo.module.home.view.searchView;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.BrandBean;

import java.util.List;

/**
 * 查商标
 * Q164454216
 * Created by xiaoke on 2017/2/10.
 */

public interface ISearchBrandView  extends BaseView{
    //查商标
    void findBrandInfoSucess(List<BrandBean> list);
    void findBrandInfoFaild(int status,String errorMsg);
    void findBrandNoData();
    void findBrandTotal(int totals);
    //获取商标类型
//    void getBrandTypeSucess(List<BrandTypeBean> suceessMsg);
//    void getBrandTypeFaild(int status,String errorMsg);
    //获取商标热门搜索记录
    void getHotHistorySucess(List<BrandBean> suceessMsg);
    void getHotHistoryFaild(int status,String errorMsg);


}
