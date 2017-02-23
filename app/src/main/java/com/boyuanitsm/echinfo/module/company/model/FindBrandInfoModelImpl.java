package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.FindManager;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/23.
 */

public class FindBrandInfoModelImpl implements IFindBrandInfoModel{

    @Override
    public void findBrandListInfo(String id, ResultCallback callback) {
        FindManager.getFindManager().findBrandInfo(id,callback);
    }
}
