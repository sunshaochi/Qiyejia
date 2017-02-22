package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.bean.TaxInfoBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.ISuiWuInfoModel;
import com.boyuanitsm.echinfo.module.company.model.SuiWuInfoModelImpl;
import com.boyuanitsm.echinfo.module.company.view.ISuiWuInfoView;

import java.util.List;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/22.
 */

public class SuiWuInfoPreImpl extends BasePresenterImpl<ISuiWuInfoView> implements ISuiWuInfoPre{
    private ISuiWuInfoModel model;
    public SuiWuInfoPreImpl(ISuiWuInfoView view) {
        super(view);
        mView=view;
        model=new SuiWuInfoModelImpl();
    }

    @Override
    public void getSuiWuInfo(String id) {
        model.findSuiWuInfoSucess(id, new ResultCallback<ResultBean<List<TaxInfoBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.getSuiWuInfoFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<TaxInfoBean>> response) {
                 List<TaxInfoBean> data = response.getData();
                if (data!=null&&data.size()>0){
                    mView.getISuiWuInfoSucess(data);
                }else {
                    mView.getNoData();
                }
            }
        });
    }
}
