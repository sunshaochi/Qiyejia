package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.QiYeZsBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.IQiyeZsModel;
import com.boyuanitsm.echinfo.module.company.model.QiYeZsModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IQiYeZsView;

import java.util.List;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public class QiYeZsPreImpl extends BasePresenterImpl<IQiYeZsView> implements IQiYeZsPre {
    private IQiyeZsModel model;

    public QiYeZsPreImpl(IQiYeZsView view) {
        super(view);
        mView=view;
        model=new QiYeZsModelImpl();
    }


    @Override
    public void getQiYeList(String companyId) {
        model.getQiYeList(companyId, new ResultCallback<ResultBean<List<QiYeZsBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.getQiYeZsListFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<QiYeZsBean>> response) {
                List<QiYeZsBean> data = response.getData();
                if (data!=null&&data.size()>0){
                    mView.getQiYeZsListSucess(data);
                }else {
                    mView.getQiYeNOdata();
                }
            }
        });
    }
}
