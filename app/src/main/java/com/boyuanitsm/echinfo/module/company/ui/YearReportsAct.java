package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.YearReportBean;
import com.boyuanitsm.echinfo.module.company.presenter.IYearReportPre;
import com.boyuanitsm.echinfo.module.company.presenter.YearReportPreImpl;
import com.boyuanitsm.echinfo.module.company.view.IYearReportView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.utils.ToolsUtils;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 企业年报
 * Created by Yang on 2017/1/4 0004.
 */
public class YearReportsAct extends BaseAct<IYearReportPre> implements IYearReportView{
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<YearReportBean> mAdp;
    private List<YearReportBean> datas = new ArrayList<>();
    private String companyId;
    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("企业年报");
        setRightBtn("纠错", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ErrorCorrectionAct.class);
            }
        });
        mPresenter=new YearReportPreImpl(this);
        initFrg();
        companyId=getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter.getYearReportDatas(companyId);
        rcv.setRefreshing(true);
    }

    private void initFrg() {
        View view = new View(this);
        view.setMinimumHeight(30);
        view.setMinimumWidth(ToolsUtils.getScreenWidth(this));
        view.setBackgroundColor(getResources().getColor(R.color.bg_grey_color));
        rcv.addHeaderView(view);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), false);
        mAdp = new BaseRecyclerAdapter<YearReportBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_yearreports_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, YearReportBean item) {
                holder.getTextView(R.id.tv_year).setText(item.getYear() + "年报");
                holder.getTextView(R.id.tv_companyName).setText(item.getCompanyName());
            }
        };
        mAdp.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                openActivity(ReportInfoAct.class);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        rcv.setAdapter(mAdp);
    }

    @Override
    public void setYearReport(List<YearReportBean> datas) {
        rcv.refreshComplete();
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
