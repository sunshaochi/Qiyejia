package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.FinancInfoBean;
import com.boyuanitsm.echinfo.module.company.presenter.IFinancingInfoPre;
import com.boyuanitsm.echinfo.module.company.presenter.IFinancingInfoPreImpl;
import com.boyuanitsm.echinfo.module.company.view.IFinancIfView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 融资信息
 * Created by Yang on 2017/1/4 0004.
 */
public class FinancingInfoAct extends BaseAct<IFinancingInfoPre> implements IFinancIfView {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<FinancInfoBean> mAdp;
    private List<FinancInfoBean> datas = new ArrayList<>();
    private String companyId;
    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("融资信息");
        mPresenter=new IFinancingInfoPreImpl(this);
        companyId = getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter.getFinancIf(companyId);
        initFrg();
    }

    private void initFrg() {
//        testList = EchinfoUtils.getTestDatas(3);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), true);
        mAdp = new BaseRecyclerAdapter<FinancInfoBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_financinginfo_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, FinancInfoBean item) {
                holder.getTextView(R.id.tv_je).setText(item.getAccount());
                holder.getTextView(R.id.tv_ms).setText(item.getReason());
                holder.getTextView(R.id.tv_time).setText(item.getDate());
                holder.getTextView(R.id.tv_tzr).setText(item.getInvests());

            }
        };
        rcv.setAdapter(mAdp);
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getFinancIf(companyId);
            }

            @Override
            public void onLoadMore() {

            }
        });
    }


    @Override
    public void setFinancIf(List<FinancInfoBean> mdatas) {
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
