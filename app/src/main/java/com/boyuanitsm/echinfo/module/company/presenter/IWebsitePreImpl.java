package com.boyuanitsm.echinfo.module.company.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.bean.WebsiteBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.company.model.IWebsiteModle;
import com.boyuanitsm.echinfo.module.company.model.IWebsiteModleImpl;
import com.boyuanitsm.echinfo.module.company.view.IWebsiteView;

import java.util.List;

/**
 * Created by bitch-1 on 2017/2/22.
 */
public class IWebsitePreImpl extends BasePresenterImpl<IWebsiteView> implements IWebsitePre {
    private IWebsiteModle modle;
    public IWebsitePreImpl(IWebsiteView view) {
        super(view);
        mView=view;
        modle=new IWebsiteModleImpl();
    }

    @Override
    public void getData(String companyId) {
        modle.getData(companyId, new ResultCallback<ResultBean<List<WebsiteBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<WebsiteBean>> response) {
                List<WebsiteBean> data=response.getData();
                mView.setData(data);

            }
        });

    }
}
