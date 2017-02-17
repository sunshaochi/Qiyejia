package com.boyuanitsm.echinfo.module.mine.view;

import com.boyuanitsm.echinfo.base.BaseView;

/**
 * Created by bitch-1 on 2017/2/17.
 */
public interface IFeedView extends BaseView{
    void CommitSuc();//提交成功
    void requstErroy(int statu,String errormesage);//失败
}
