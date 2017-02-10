package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.ForengnInvesImpl;
import com.boyuanitsm.echinfo.module.company.model.IForengnInvesModel;
import com.boyuanitsm.echinfo.module.company.view.IForeignInvesView;

import java.util.List;

/**
 * 对外投资
 * Created by wangbin on 17/2/9.
 */
public class ForengnInvesPreImpl extends BasePresenterImpl<IForeignInvesView> implements IForengnInvesPre{

    private IForengnInvesModel model;
    public ForengnInvesPreImpl(IForeignInvesView view) {
        super(view);
        mView=view;
        model=new ForengnInvesImpl();
    }

    @Override
    public void getInvesDatas(String companyId) {
        model.getForengnInvesData(companyId, new ResultCallback<ResultBean<List<CompanyBean>>>() {
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
                    mView.getInvesData(list);
                }
            }
        });
    }
}
