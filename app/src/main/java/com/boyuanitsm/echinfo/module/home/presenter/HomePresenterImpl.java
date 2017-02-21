package com.boyuanitsm.echinfo.module.home.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.home.model.HomeModelImpl;
import com.boyuanitsm.echinfo.module.home.model.IHomeModel;
import com.boyuanitsm.echinfo.module.home.view.IHomeView;

import java.util.List;

/**
 *
 * Created by wangbin on 16/12/23.
 */
public class HomePresenterImpl extends BasePresenterImpl<IHomeView> implements IHomePresenter{
    private IHomeModel homeModel;

    public HomePresenterImpl(IHomeView view) {
        super(view);
        mView=view;
        homeModel=new HomeModelImpl();
    }

    @Override
    public void getMyAttention() {


    }

    @Override
    public void getHotHistory(String type) {
        homeModel.getHotCompany(type, new ResultCallback<ResultBean<List<CompanyBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.getHotHistoryFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<CompanyBean>> response) {
                mView.getHotHistorySucess(response.getData());
            }
        });
    }
}
