package com.boyuanitsm.echinfo.module.home.view;

/**
 * 首页接口管理
 * Created by wangbin on 16/12/22.
 */
public interface IMainView {
    /*选择到第几个Tab*/
    void selectTabPosition(int position);
    /*选中的颜色改变*/
    void setCurrentTab(int position);
}
