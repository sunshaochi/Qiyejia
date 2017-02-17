package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ErrorBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.ErrorModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IErrorListView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 */

public class ErrorListPreImpl extends BasePresenterImpl<IErrorListView> implements IErrorListPre {
    private ErrorModelImpl model;
    public ErrorListPreImpl(IErrorListView view) {
        super(view);
        mView=view;
        model=new ErrorModelImpl();
    }

    @Override
    public void getErrorList(String dictType) {
        model.getErrorCorrectionList(dictType, new ResultCallback<ResultBean<List<ErrorBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.getErrorListFail(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<ErrorBean>> response) {
                List<ErrorBean> list=response.getData();
                if (list==null || list.size()==0){
                    mView.getErrorNoData();
                }else {
                    mView.getErrorListSuccess(list);
                }
            }

        });
    }

    @Override
    public void subErrorMsg(String companyId, String errorParts, String errorContent, String mobileEmailQqNo, int status) {
        model.submitErrorMsg(companyId, errorParts, errorContent, mobileEmailQqNo, status, new ResultCallback<String>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.subErrorFail(status, errorMsg);
            }

            @Override
            public void onResponse(String response) {
                mView.subErrorSuccess();
            }

        });
    }
}
