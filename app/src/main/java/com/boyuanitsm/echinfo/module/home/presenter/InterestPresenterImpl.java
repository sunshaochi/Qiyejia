package com.boyuanitsm.echinfo.module.home.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.home.model.IInterestModel;
import com.boyuanitsm.echinfo.module.home.model.InterestModelImpl;
import com.boyuanitsm.echinfo.module.home.view.IInterestView;

import java.util.List;

/**
 * Created by wangbin on 17/2/8.
 */
public class InterestPresenterImpl extends BasePresenterImpl<IInterestView> implements IInterestPresenter {
    private IInterestModel model;
    public InterestPresenterImpl(IInterestView view) {
        super(view);
        mView=view;
        model=new InterestModelImpl();
    }

    @Override
    public void getCompanyList() {
       model.toGetCompany(new ResultCallback<ResultBean<List<CompanyBean>>>() {
           @Override
           public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);
           }

           @Override
           public void onResponse(ResultBean<List<CompanyBean>> response) {
               List<CompanyBean> list=response.getData();
               if(list==null||list.size()==0){
                   mView.requestNoData();
               }else {
                   mView.setCompanyData(list);
               }
           }
       });
    }

}
