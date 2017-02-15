package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.bean.SoftwareCopyright;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.ICompanyBaseListModel;
import com.boyuanitsm.echinfo.module.company.model.SoftwareRightModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;

import java.util.List;

/**
 * 软件著作权
 * Created by wangbin on 17/2/14.
 */
public class SoftwareRightPreImpl extends BasePresenterImpl<IBaseListView<SoftwareCopyright>> implements ICompanyBasePre{
    private ICompanyBaseListModel model;

    public SoftwareRightPreImpl(IBaseListView<SoftwareCopyright> view) {
        super(view);
        mView=view;
        model=new SoftwareRightModelImpl();
    }

    @Override
    public void getDatas(String companyId) {
        model.getDatas(companyId, new ResultCallback<ResultBean<List<SoftwareCopyright>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status, errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<SoftwareCopyright>> response) {
                List<SoftwareCopyright> datas=response.getData();
                if(datas==null||datas.size()==0){
                    mView.requestNoData();
                }else {
                    mView.setDatas(datas);
                }

            }
        });
    }
}
