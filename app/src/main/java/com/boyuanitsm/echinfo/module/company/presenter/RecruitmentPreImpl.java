package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.RecruiBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.IRecruitmentModel;
import com.boyuanitsm.echinfo.module.company.model.RecruitmentModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IRecruiView;

import java.util.List;

/**
 * Created by bitch-1 on 2017/2/13.
 */
public class RecruitmentPreImpl extends BasePresenterImpl<IRecruiView> implements IRecruiPre {
    private IRecruitmentModel model;

    public RecruitmentPreImpl(IRecruiView view) {
        super(view);
        mView=view;
        model=new RecruitmentModelImpl();
    }

    @Override
    public void getRecruitDatas(String companyId) {
        model.getRecruitDatas(companyId, new ResultCallback<ResultBean<List<RecruiBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);

            }

            @Override
            public void onResponse(ResultBean<List<RecruiBean>> response) {
                List<RecruiBean>list=response.getData();
                if(list.size()==0){
                    mView.requestNoData();
                }else {
                    mView.setCourtRecr(list);
                }


            }
        });

    }
}
