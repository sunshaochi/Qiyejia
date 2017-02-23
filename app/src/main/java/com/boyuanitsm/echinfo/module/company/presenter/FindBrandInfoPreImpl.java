package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.BrandBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.FindBrandInfoModelImpl;
import com.boyuanitsm.echinfo.module.company.model.IFindBrandInfoModel;
import com.boyuanitsm.echinfo.module.company.view.IFindBrandInfoView;

import java.util.List;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/23.
 */

public class FindBrandInfoPreImpl extends BasePresenterImpl<IFindBrandInfoView> implements IFindBrandInfoPre {
    private IFindBrandInfoModel model;
    public FindBrandInfoPreImpl(IFindBrandInfoView view) {
        super(view);
        mView=view;
        model=new FindBrandInfoModelImpl();
    }

    @Override
    public void findBrandInfoList(String id) {
        model.findBrandListInfo(id, new ResultCallback<ResultBean<List<BrandBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.getBrandListFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<BrandBean>> response) {
                 List<BrandBean> data = response.getData();
                if (data!=null&&data.size()>0){
                    mView.getBrandListSucess(data);
                }else {
                    mView.getBrandNodata();
                }
            }
        });

    }
}
