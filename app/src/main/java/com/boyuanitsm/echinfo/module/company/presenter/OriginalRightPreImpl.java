package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.CopyrightsBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.ICompanyBaseListModel;
import com.boyuanitsm.echinfo.module.company.model.OriginalRightModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;

import java.util.List;

/**
 * Created by wangbin on 17/2/14.
 */
public class OriginalRightPreImpl extends BasePresenterImpl<IBaseListView<CopyrightsBean>> implements ICompanyBasePre {
    private ICompanyBaseListModel model;

    public OriginalRightPreImpl(IBaseListView<CopyrightsBean> view) {
        super(view);
        mView = view;
        model = new OriginalRightModelImpl();
    }

    @Override
    public void getDatas(String companyId) {
        model.getDatas(companyId, new ResultCallback<ResultBean<List<CopyrightsBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status, errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<CopyrightsBean>> response) {
                List<CopyrightsBean> datas=response.getData();
                if(datas==null||datas.size()==0){
                    mView.requestNoData();
                }else {
                    mView.setDatas(datas);
                }

            }
        });
    }
}
