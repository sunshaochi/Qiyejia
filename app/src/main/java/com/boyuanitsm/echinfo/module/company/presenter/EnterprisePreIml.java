package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;

import com.boyuanitsm.echinfo.bean.EnterpriBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.EnterpriseModel;
import com.boyuanitsm.echinfo.module.company.model.EnterpriseModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IEnterpriseView;

import java.util.List;


/**
 * Created by bitch-1 on 2017/2/13.
 */
public class EnterprisePreIml extends BasePresenterImpl<IEnterpriseView> implements IEnterprisePre {
    private EnterpriseModel model;
    public EnterprisePreIml(IEnterpriseView view) {
        super(view);
        mView=view;
        model=new EnterpriseModelImpl();
    }

    @Override
    public void getEnterpriDatas(String companyId) {
        model.getEnterpriDatas(companyId, new ResultCallback<ResultBean<List<EnterpriBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<EnterpriBean>> response) {
                List<EnterpriBean>list=response.getData();
                if(list.size()==0){
                    mView.requestNoData();
                }else {
                    mView.setEnterpri(list);
                }

            }
        });

    }
}
