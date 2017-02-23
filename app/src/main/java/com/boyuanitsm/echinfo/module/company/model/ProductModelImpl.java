package com.boyuanitsm.echinfo.module.company.model;

import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.FindManager;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/23.
 */

public class ProductModelImpl implements IProductModel {
    @Override
    public void getProductList(String id, ResultCallback callback) {
        FindManager.getFindManager().findProductListbyId(id,callback);
    }
}
