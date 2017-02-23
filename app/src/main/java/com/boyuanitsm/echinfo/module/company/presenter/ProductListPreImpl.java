package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ProductBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.IProductModel;
import com.boyuanitsm.echinfo.module.company.model.ProductModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IProductInfoView;

import java.util.List;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/23.
 */

public class ProductListPreImpl extends BasePresenterImpl<IProductInfoView> implements IProductListPre {
    private IProductModel model;
    public ProductListPreImpl(IProductInfoView view) {
        super(view);
        mView=view;
        model=new ProductModelImpl();
    }

    @Override
    public void getProductList(String id) {
        model.getProductList(id, new ResultCallback<ResultBean<List<ProductBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.getProductListFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<ProductBean>> response) {
                List<ProductBean> data = response.getData();
                if (data!=null&&data.size()>0){
                    mView.getProductListSucess(data);
                }else {
                    mView.getProductNodata();
                }
            }
        });
    }
}
