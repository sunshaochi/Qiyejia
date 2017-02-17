package com.boyuanitsm.echinfo.module.mine.presenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.AttenBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.mine.model.FollowModel;
import com.boyuanitsm.echinfo.module.mine.model.FollowModelImpl;
import com.boyuanitsm.echinfo.module.mine.view.IFollowView;

import java.util.List;

/**
 * Created by bitch-1 on 2017/2/17.
 */
public class IFollowPreImpl extends BasePresenterImpl<IFollowView> implements IFollowPre {
    private FollowModel model;
    public IFollowPreImpl(IFollowView view) {
        super(view);
        mView=view;
        model=new FollowModelImpl();
    }

    @Override
    public void getFollowDatas() {
        model.getFollowDatas(new ResultCallback<ResultBean<List<AttenBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.requestError(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<List<AttenBean>> response) {
                List<AttenBean>list=response.getData();
                if(list.size()==0||list==null){
                    mView.requestNoData();
                }else {
                    mView.setFollowDatas(list);
                }


            }
        });

    }
}
