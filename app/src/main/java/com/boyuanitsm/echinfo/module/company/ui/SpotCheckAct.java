package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.SpotCheckBean;
import com.boyuanitsm.echinfo.module.company.presenter.ICompanyBasePre;
import com.boyuanitsm.echinfo.module.company.presenter.SpotCheckPreImpl;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 抽查检查
 * Created by Yang on 2017/1/3 0003.
 */
public class SpotCheckAct extends BaseAct<ICompanyBasePre> implements IBaseListView<SpotCheckBean>{
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<SpotCheckBean> mAdp;
    private List<SpotCheckBean> datas = new ArrayList<>();

    private String companyId;
    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("抽查检查");
        mPresenter=new SpotCheckPreImpl(this);
        companyId=getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter.getDatas(companyId);
        initFrg();
    }

    private void initFrg() {
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), false);
        mAdp = new BaseRecyclerAdapter<SpotCheckBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_spotcheck_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, SpotCheckBean item) {
                holder.getTextView(R.id.tvJg).setText(item.getImplementingAgency());
                holder.getTextView(R.id.tvType).setText(item.getType());
                holder.getTextView(R.id.tvDate).setText(item.getDate());
                holder.getTextView(R.id.tvResult).setText(item.getResult());
            }
        };
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getDatas(companyId);
            }

            @Override
            public void onLoadMore() {

            }
        });
        rcv.setAdapter(mAdp);
    }

    @Override
    public void setDatas(List<SpotCheckBean> mDatas) {
        rcv.refreshComplete();
        datas=mDatas;
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
