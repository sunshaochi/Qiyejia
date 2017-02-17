package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.DateBean;
import com.boyuanitsm.echinfo.bean.ProductBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.IPinPaiModel;
import com.boyuanitsm.echinfo.module.company.model.PinPaiModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IPinPaiView;

import java.util.List;

/**
 * 根据品牌产品
 * Q164454216
 * Created by xiaoke on 2017/2/14.
 */

public class PinPaiPreImpl extends BasePresenterImpl<IPinPaiView> implements IPinPaiPre {
    private IPinPaiModel model;
    public PinPaiPreImpl(IPinPaiView view) {
        super(view);
        mView=view;
        model=new PinPaiModelImpl();
    }
    @Override
    public void getQiYeinfobyPinPai(String webAddress, String address, String industry, String capital, String establishDate, int page, int rows) {
        model.findEnterpriseInfoByProductName(webAddress, address, industry, capital, establishDate, page, rows, new ResultCallback<ResultBean<DateBean<ProductBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.findEnterpriseInfoByNameFaild(status, errorMsg);

            }

            @Override
            public void onResponse(ResultBean<DateBean<ProductBean>> response) {
                List<ProductBean> list = response.getData().getRows();
                mView.findEnterpriseTotals(response.getData().getTatal());
                if (list!=null&&list.size()>0){
                    mView.findEnterpriseInfoByNameSuceess(list);
                }else {
                    mView.findfindEnterpriseInfoByNameNodata();
                }
            }
        });
    }

    @Override
    public void getHotHistory(String type) {
        model.getHotHistory(type, new ResultCallback<ResultBean<List<ProductBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
               mView.getHotHistoryFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<ProductBean>> response) {
                mView.getHotHistorySucess(response.getData());
            }
        });
    }

}
