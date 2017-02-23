package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.EquityBean;
import com.boyuanitsm.echinfo.module.company.presenter.EquityPreImpl;
import com.boyuanitsm.echinfo.module.company.presenter.IEquityPre;
import com.boyuanitsm.echinfo.module.company.view.IEquityView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.MineItemView;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * 股权出资
 * Created by Yang on 2017/1/4 0004.
 */
public class EquityAct extends BaseAct<IEquityPre> implements IEquityView {
    @BindView(R.id.rcv)
    XRecyclerView rcv;
    private BaseRecyclerAdapter<EquityBean> mAdp;
    private List<EquityBean> datas = new ArrayList<>();

//    @BindView(R.id.miv_dj)
//    MineItemView miv_dj;
//    @BindView(R.id.miv_zt)
//    MineItemView miv_zt;
//    @BindView(R.id.miv_cz)
//    MineItemView miv_cz;
//    @BindView(R.id.miv_czj)
//    MineItemView miv_czj;
//    @BindView(R.id.miv_zq)
//    MineItemView miv_zq;
//    @BindView(R.id.miv_zzj)
//    MineItemView miv_zzj;
//    @BindView(R.id.miv_se)
//    MineItemView miv_se;
//    @BindView(R.id.miv_time)
//    MineItemView miv_time;

    private String companyId;
    private String companyname;//公司姓名
    @Override
    public int getLayout() {

        return R.layout.act_equityact;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("股权出资");
        mPresenter=new EquityPreImpl(this);
        companyId = getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        companyname=getIntent().getStringExtra("companyname");
        mPresenter.getEquityDatas(companyId);
        initFrg();
    }

    /**
     * 初始化下拉刷新
     //
     * @param */
    private void initFrg() {
//        datas=EchinfoUtils.getTestDatas(3);
        rcv= EchinfoUtils.getLinearRecyclerView(rcv,getApplicationContext(),true);

        mAdp=new BaseRecyclerAdapter<EquityBean>(getApplicationContext(),datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.act_equity;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, EquityBean item) {
                MineItemView miv_dj= (MineItemView) holder.getView(R.id.miv_name);//公司
                miv_dj.setLeftText(companyname+"");
                miv_dj.setLeftTextSize(32);
//                MineItemView miv_dj= (MineItemView) holder.getView(R.id.miv_dj);
//                miv_dj.setRightText(item.getRegistrationNumber());
//                MineItemView miv_zt= (MineItemView) holder.getView(R.id.miv_zt);
//                miv_zt.setRightText(item.getStatus());
                MineItemView miv_cz= (MineItemView) holder.getView(R.id.miv_perpson);//出资人
                miv_cz.setRightText(item.getPledgor());
//                MineItemView miv_czj= (MineItemView) holder.getView(R.id.miv_czj);
//                miv_czj.setRightText(item.getPledgorId());
//                MineItemView miv_zq= (MineItemView) holder.getView(R.id.miv_zq);
//                miv_zq.setRightText(item.getPawnee());
//                MineItemView miv_zzj= (MineItemView) holder.getView(R.id.miv_zzj);
//                miv_zzj.setRightText(item.getPawneeId());
                MineItemView miv_se= (MineItemView) holder.getView(R.id.miv_money);//数额
                miv_se.setRightText(item.getAccount());
//                MineItemView miv_time= (MineItemView) holder.getView(R.id.miv_time);
//                miv_time.setRightText(item.getDate());


            }
        };
        rcv.setAdapter(mAdp);
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getEquityDatas(companyId);
            }

            @Override
            public void onLoadMore() {

            }
        });
    }


    @Override
    public void setEquityDatas(List<EquityBean> list) {
        rcv.refreshComplete();
        if(datas.size()!=0){
            datas.clear();
        }
        datas=list;
        mAdp.setData(datas);


//         EquityBean mdatas = list.get(0);
//        if(mdatas!=null) {
//            miv_dj.setRightText(mdatas.getRegistrationNumber());
//            miv_zt.setRightText(mdatas.getStatus());
//
//            miv_cz.setRightText(mdatas.getPledgor());
//
//            miv_czj.setRightText(mdatas.getPledgorId());
//
//            miv_zq.setRightText(mdatas.getPawnee());
//
//            miv_zzj.setRightText(mdatas.getPawneeId());
//
//            miv_se.setRightText(mdatas.getAccount());
//
//            miv_time.setRightText(mdatas.getDate());
//        }else if (mdatas==null){
//            toast("暂无数据");
//        }


    }

    @Override
    public void requestError(int status, String errorMsg) {
    rcv.refreshComplete();
        toast(errorMsg);
    }

    @Override
    public void getNoData() {
        rcv.refreshComplete();

    }


}
