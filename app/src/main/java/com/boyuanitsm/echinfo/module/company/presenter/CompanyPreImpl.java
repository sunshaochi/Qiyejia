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
    public void getCompanyDetail(String companyId) {//获取公司信息
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

    @Override
    public void addInsertAtt(final String companyId) {//添加关注
        model.addInsertAtt(companyId, new ResultCallback<ResultBean>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean response) {
                int statu=response.getStatus();
                if(statu==200){
                mView.addInsertAtt();}


            }
        });

    }

    @Override
    public void removeAtt(String companyId) {//取消关注
        model.removeAtt(companyId, new ResultCallback<ResultBean>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean response) {
                int status=response.getStatus();
                if(status==200){
                    mView.removeAtt();
                }

            }
        });

    }
}
