package com.boyuanitsm.echinfo.module.home.view.searchView;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.BrandBean;

import java.util.List;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public interface IFindBrandView extends BaseView {
    //获取商标热门搜索记录
    void getHotHistorySucess(List<BrandBean> suceessMsg);
    void getHotHistoryFaild(int status,String errorMsg);
}
