package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.PatenInfomationBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.ICompanyBaseListModel;
import com.boyuanitsm.echinfo.module.company.model.PatentInfoModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;

import java.util.List;

/**
 * Created by wangbin on 17/2/13.
 */
public class PatentInfoPreImpl extends BasePresenterImpl<IBaseListView<PatenInfomationBean>> implements ICompanyBasePre{
   private ICompanyBaseListModel model;

    public PatentInfoPreImpl(IBaseListView<PatenInfomationBean> view) {
        super(view);
        mView=view;
        model=new PatentInfoModelImpl();
    }

    @Override
    public void getDatas(String companyId) {
        model.getDatas(companyId, new ResultCallback<ResultBean<List<PatenInfomationBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                 mView.requestError(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<PatenInfomationBean>> response) {
                List<PatenInfomationBean> datas=response.getData();
                if(datas==null||datas.size()==0){
                    mView.requestNoData();
                }else {
                    mView.setDatas(datas);
                }
            }
        });
    }
}
