package com.boyuanitsm.echinfo.module.home.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.HomeComAdapter;
import com.boyuanitsm.echinfo.adapter.HomeZxAdapter;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.module.home.presenter.HomePresenterImpl;
import com.boyuanitsm.echinfo.module.home.presenter.IHomePresenter;
import com.boyuanitsm.echinfo.module.home.view.IHomeView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.MyGridView;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import butterknife.BindView;

/**
 * 首页
 * Created by wangbin on 16/12/22.
 */
public class HomeFrg extends BaseFrg<IHomePresenter> implements IHomeView,AdapterView.OnItemClickListener{
    @BindView(R.id.rcv)
    XRecyclerView rcv;
    RelativeLayout rlTop;
    @Override
    public int getLayout() {
        return R.layout.frg_home;
    }

    @Override
    protected void initView(View fragmentRootView) {
        mPresenter=new HomePresenterImpl(this);
        rcv= EchinfoUtils.getLinearRecyclerView(rcv,getContext(),false);
        View headView=View.inflate(getContext(),R.layout.home_head_view,null);
        rlTop= (RelativeLayout) headView.findViewById(R.id.rlTop);
        /*查企业*/
        MyGridView gvHomeCompany= (MyGridView) headView.findViewById(R.id.gvHomeCompany);
        gvHomeCompany.setAdapter(new HomeComAdapter(getContext()));
        gvHomeCompany.setOnItemClickListener(this);
        /*查专项*/
        MyGridView gvZx= (MyGridView) headView.findViewById(R.id.gvZx);
        gvZx.setAdapter(new HomeZxAdapter(getContext()));
        gvZx.setOnItemClickListener(this);
        rcv.addHeaderView(headView);

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (view.getId()){
            case R.id.gvHomeCompany://查企业

                break;
            case R.id.gvZx://查专项

                break;
        }
    }
}
