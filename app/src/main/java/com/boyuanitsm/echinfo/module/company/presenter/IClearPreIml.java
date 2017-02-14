package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ClearinfoBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.IClearModel;
import com.boyuanitsm.echinfo.module.company.model.IClearModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IClearView;

import java.util.List;

/**
 * Created by bitch-1 on 2017/2/14.
 */
public class IClearPreIml extends BasePresenterImpl<IClearView>implements IClearPre{
    private IClearModel model;
    public IClearPreIml(IClearView view) {
        super(view);
        mView=view;
        model=new IClearModelImpl();
    }

    @Override
    public void getClearinfoDatas(String companyId) {
        model.getClearinfoDatas(companyId, new ResultCallback<ResultBean<List<ClearinfoBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<ClearinfoBean>> response) {
                List<ClearinfoBean>list=response.getData();
                if(list.size()==0){
                    mView.requestNoData();
                }else {
                    mView.setCourtClear(list);
                }


            }
        });

    }
}
