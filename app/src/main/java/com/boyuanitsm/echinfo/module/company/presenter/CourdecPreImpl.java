package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.CourtDecisionBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.CourdecModelImpl;
import com.boyuanitsm.echinfo.module.company.model.ICompanyBaseListModel;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;

import java.util.List;

/**
 * Created by wangbin on 17/2/10.
 */
public class CourdecPreImpl extends BasePresenterImpl<IBaseListView<CourtDecisionBean>> implements ICompanyBasePre{
    private ICompanyBaseListModel model;
    public CourdecPreImpl(IBaseListView<CourtDecisionBean> view) {
        super(view);
        mView=view;
        model=new CourdecModelImpl();
    }

    @Override
    public void getDatas(String companyId) {
        model.getDatas(companyId, new ResultCallback<ResultBean<List<CourtDecisionBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<CourtDecisionBean>> response) {
                List<CourtDecisionBean> list=response.getData();
                if(list==null||list.size()==0){
                   mView.requestNoData();
                }else{
                    mView.setDatas(list);
                }
            }
     });
    }
}
