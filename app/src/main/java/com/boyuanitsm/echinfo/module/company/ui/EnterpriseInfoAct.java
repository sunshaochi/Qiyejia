package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.EnterpriBean;
import com.boyuanitsm.echinfo.module.company.presenter.EnterprisePreIml;
import com.boyuanitsm.echinfo.module.company.presenter.IEnterprisePre;
import com.boyuanitsm.echinfo.module.company.view.IEnterpriseView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.utils.ToolsUtils;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 企业资讯
 * Created by Yang on 2017/1/4 0004.
 */
public class EnterpriseInfoAct extends BaseAct<IEnterprisePre> implements IEnterpriseView {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<EnterpriBean> mAdp;
    private List<EnterpriBean> datas = new ArrayList<>();

    private String companyId;

    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("企业资讯");
        mPresenter=new EnterprisePreIml(this);
        companyId = getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter.getEnterpriDatas(companyId);
        setRightBtn("纠错", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ErrorCorrectionAct.class);
            }
        });
        initFrg();
    }

    private void initFrg() {
        View view = new View(this);
        view.setMinimumHeight(30);
        view.setMinimumWidth(ToolsUtils.getScreenWidth(this));
        view.setBackgroundColor(getResources().getColor(R.color.bg_grey_color));
        rcv.addHeaderView(view);
//        testList = EchinfoUtils.getTestDatas(3);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), true);
        mAdp = new BaseRecyclerAdapter<EnterpriBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_courtdecision_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, EnterpriBean item) {
                holder.getTextView(R.id.tvName).setText(item.getTitle());
                holder.getTextView(R.id.tvNo).setText(item.getNewsFrom());
            }
        };
        rcv.setAdapter(mAdp);
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getEnterpriDatas(companyId);
            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    @Override
    public void setEnterpri(List<EnterpriBean> mdatas) {
        rcv.refreshComplete();
        datas=mdatas;
        mAdp.setData(datas);

    }

    @Override
    public void requestError(int status, String errorMsg) {
        rcv.refreshComplete();
        toast(errorMsg);

    }

    @Override
    public void requestNoData() {
        rcv.refreshComplete();

    }
}
