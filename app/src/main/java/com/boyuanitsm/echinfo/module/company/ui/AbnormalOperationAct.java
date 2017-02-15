package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.ManageExceptionBean;
import com.boyuanitsm.echinfo.module.company.presenter.ICompanyBasePre;
import com.boyuanitsm.echinfo.module.company.presenter.ManagerExceptionPreImpl;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 经营异常
 * Created by Yang on 2017/1/4 0004.
 */
public class AbnormalOperationAct extends BaseAct<ICompanyBasePre> implements IBaseListView<ManageExceptionBean> {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<ManageExceptionBean> mAdp;
    private List<ManageExceptionBean> datas = new ArrayList<>();

    private String companyId;

    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("经营异常");
        companyId=getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter=new ManagerExceptionPreImpl(this);
        mPresenter.getDatas(companyId);
        initFrg();
    }

    private void initFrg() {
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, this, false);
        mAdp = new BaseRecyclerAdapter<ManageExceptionBean>(this, datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_abnormaloperation_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, ManageExceptionBean item) {
                holder.getTextView(R.id.tvJg).setText("决定机关：" + item.getInsertOrg());
                holder.getTextView(R.id.tvReason).setText(item.getInsertCause());
                holder.getTextView(R.id.tvLrDate).setText(item.getInsertTime());
                holder.getTextView(R.id.tvYcReason).setText(item.getOutCause());
                holder.getTextView(R.id.tvYcTime).setText(item.getOutTime());
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
    public void setDatas(List<ManageExceptionBean> mDatas) {
        rcv.refreshComplete();
        datas = mDatas;
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
