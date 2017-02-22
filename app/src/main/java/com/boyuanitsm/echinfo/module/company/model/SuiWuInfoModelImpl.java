package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.FindManager;

/**
 * 税务信用
 * Q164454216
 * Created by xiaoke on 2017/2/22.
 */

public class SuiWuInfoModelImpl implements ISuiWuInfoModel {
    @Override
    public void findSuiWuInfoSucess(String id, ResultCallback callback) {
        FindManager.getFindManager().findShuiWuInfo(id,callback);
    }
}
