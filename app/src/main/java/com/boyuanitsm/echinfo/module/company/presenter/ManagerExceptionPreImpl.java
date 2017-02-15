package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ManageExceptionBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.ICompanyBaseListModel;
import com.boyuanitsm.echinfo.module.company.model.ManagerExceptionModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;

import java.util.List;

/**
 * Created by wangbin on 17/2/13.
 */
public class ManagerExceptionPreImpl extends BasePresenterImpl<IBaseListView<ManageExceptionBean>> implements ICompanyBasePre{

    private ICompanyBaseListModel model;
    public ManagerExceptionPreImpl(IBaseListView<ManageExceptionBean> view) {
        super(view);
        mView=view;
        model=new ManagerExceptionModelImpl();
    }

    @Override
    public void getDatas(String comanyId) {
        model.getDatas(comanyId, new ResultCallback<ResultBean<List<ManageExceptionBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<ManageExceptionBean>> response) {
                List<ManageExceptionBean> datas=response.getData();
                if(datas==null||datas.size()==0){
                    mView.requestNoData();
                }else {
                    mView.setDatas(datas);
                }
            }
        });
    }


}
