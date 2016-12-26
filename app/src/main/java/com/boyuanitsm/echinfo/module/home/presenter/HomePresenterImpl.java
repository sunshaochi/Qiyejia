package com.boyuanitsm.echinfo.module.home.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.callback.RequestCallback;
import com.boyuanitsm.echinfo.module.home.model.HomeModelImpl;
import com.boyuanitsm.echinfo.module.home.model.IHomeModel;
import com.boyuanitsm.echinfo.module.home.view.IHomeView;

/**
 *
 * Created by wangbin on 16/12/23.
 */
public class HomePresenterImpl extends BasePresenterImpl<IHomeView,String> implements IHomePresenter{
    private IHomeModel homeModel;

    public HomePresenterImpl(IHomeView view) {
        super(view);
        homeModel=new HomeModelImpl();
    }

    @Override
    public void getMyAttention() {
        homeModel.getMyAttention(new RequestCallback<String>() {
            @Override
            public void beforeRequest() {
               
            }

            @Override
            public void requestError(String msg) {

            }

            @Override
            public void requestComplete() {

            }

            @Override
            public void requestSuccess(String data) {

            }
        });
    }
}
