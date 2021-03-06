package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.bean.SpotCheckBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.ICompanyBaseListModel;
import com.boyuanitsm.echinfo.module.company.model.SpotCheckModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;

import java.util.List;

/**
 * Created by wangbin on 17/2/13.
 */
public class SpotCheckPreImpl extends BasePresenterImpl<IBaseListView<SpotCheckBean>> implements ICompanyBasePre{
    private ICompanyBaseListModel model;
    public SpotCheckPreImpl(IBaseListView<SpotCheckBean> view) {
        super(view);
        mView=view;
        model=new SpotCheckModelImpl();

    }

    @Override
    public void getDatas(String companyId) {
        model.getDatas(companyId, new ResultCallback<ResultBean<List<SpotCheckBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<SpotCheckBean>> response) {
                List<SpotCheckBean> datas=response.getData();
                if(datas==null||datas.size()==0){
                    mView.requestNoData();
                }else {
                    mView.setDatas(datas);
                }
            }
        });
    }
}
