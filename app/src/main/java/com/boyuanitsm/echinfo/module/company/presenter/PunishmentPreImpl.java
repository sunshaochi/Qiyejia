package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.AdministrativePenaltyBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.IPunishmentModel;
import com.boyuanitsm.echinfo.module.company.model.PunishmentModelImpl;
import com.boyuanitsm.echinfo.module.company.view.IPunishmentView;

import java.util.List;

/**
 * Created by wangbin on 17/2/10.
 */
public class PunishmentPreImpl extends BasePresenterImpl<IPunishmentView> implements IPunishmentPre {

    private IPunishmentModel model;

    public PunishmentPreImpl(IPunishmentView view) {
        super(view);
        mView = view;
        model = new PunishmentModelImpl();
    }

    @Override
    public void getPunishmentDatas(String companyId) {
        model.getPunishDatas(companyId, new ResultCallback<ResultBean<List<AdministrativePenaltyBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status, errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<AdministrativePenaltyBean>> response) {
                List<AdministrativePenaltyBean> list=response.getData();
                if(list==null||list.size()==0){
                    mView.requestNoData();
                }else {
                    mView.setPunishmentDatas(list);
                }
            }
        });
    }
}
