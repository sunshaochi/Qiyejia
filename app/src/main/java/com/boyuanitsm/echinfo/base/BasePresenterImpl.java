package com.boyuanitsm.echinfo.base;


/**
 * 代理基础实现
 * Created by wangbin on 16/12/23.
 */
public class BasePresenterImpl<T extends BaseView> implements BasePresenter {

    protected T mView;

    public BasePresenterImpl(T view) {
        mView = view;
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onDestroy() {
        mView = null;
    }


//    @Override
//    public void beforeRequest() {
////        mView.showProgress();
//    }
//
//    @Override
//    public void requestError(String msg) {
//        MyLogUtils.info(msg);
//        mView.toast(msg);
//        mView.hideProgress();
//    }
//
//    @Override
//    public void requestComplete() {
//        mView.hideProgress();
//    }
//
//    @Override
//    public void requestSuccess(V data) {
//
//    }
}
