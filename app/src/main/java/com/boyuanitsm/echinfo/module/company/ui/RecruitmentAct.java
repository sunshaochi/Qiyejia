package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.RecruiBean;
import com.boyuanitsm.echinfo.module.company.presenter.IRecruiPre;
import com.boyuanitsm.echinfo.module.company.presenter.RecruitmentPreImpl;
import com.boyuanitsm.echinfo.module.company.view.IRecruiView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 招聘
 * Created by Yang on 2017/1/5 0005.
 */
public class RecruitmentAct extends BaseAct<IRecruiPre> implements IRecruiView {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<RecruiBean> mAdp;
    private List<RecruiBean> datas = new ArrayList<>();

    private String companyId;

    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("招聘信息");
        mPresenter=new RecruitmentPreImpl(this);
        companyId = getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter.getRecruitDatas(companyId);
        initFrg();
    }

    private void initFrg() {
//        testList = EchinfoUtils.getTestDatas(3);做布局时候显示看的
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), false);
        mAdp = new BaseRecyclerAdapter<RecruiBean>(this,datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_recruitment_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, RecruiBean item) {
                holder.getTextView(R.id.tv_xs).setText(item.getMonthlyPay());//薪水
                holder.getTextView(R.id.tv_dd).setText(item.getAddress());//地点
                holder.getTextView(R.id.tv_jy).setText(item.getWorkSuffer());//经验
                holder.getTextView(R.id.tv_xl).setText(item.getEducation());//学历
                holder.getTextView(R.id.tv_ly).setText(item.getComeFrom());//来源
                holder.getTextView(R.id.tv_sj).setText(item.getReleaseDate());//发布时间


            }
        };
        rcv.setAdapter(mAdp);
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getRecruitDatas(companyId);
            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    @Override
    public void setCourtRecr(List<RecruiBean> mdatas) {
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
