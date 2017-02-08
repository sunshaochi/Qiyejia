package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.CompanyModelImpl;
import com.boyuanitsm.echinfo.module.company.model.ICompanyModel;
import com.boyuanitsm.echinfo.module.company.view.ICompanyView;

/**
 * Created by wangbin on 17/2/8.
 */
public class CompanyPreImpl extends BasePresenterImpl<ICompanyView> implements ICompanyPre {

    private ICompanyModel model;

    public CompanyPreImpl(ICompanyView view) {
        super(view);
        mView=view;
        model=new CompanyModelImpl();
    }

    @Override
    public void getCompanyDetail(String companyId) {
        model.getCompanyMes(companyId, new ResultCallback<ResultBean<CompanyBean>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<CompanyBean> response) {
              CompanyBean companyBean=response.getData();
                mView.setCompanyMes(companyBean);
            }
        });
    }
}
