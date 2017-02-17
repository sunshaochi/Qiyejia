package com.boyuanitsm.echinfo.module.mine.view;

import com.boyuanitsm.echinfo.base.BaseView;
import com.boyuanitsm.echinfo.bean.AttenBean;

import java.util.List;

/**
 * Created by bitch-1 on 2017/2/17.
 */
public interface IFollowView extends BaseView {
     void setFollowDatas(List<AttenBean>mdatas);

    void requestError(int status, String errorMsg);

    void requestNoData();
}
