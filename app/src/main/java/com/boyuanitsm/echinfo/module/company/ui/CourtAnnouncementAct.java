package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.CourtAnnoBean;
import com.boyuanitsm.echinfo.module.company.presenter.CourtAnnoPreImpl;
import com.boyuanitsm.echinfo.module.company.presenter.ICourtAnnoPre;
import com.boyuanitsm.echinfo.module.company.view.ICourtAnnoView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 法院公告
 * Created by Yang on 2017/1/3 0003.
 */
public class CourtAnnouncementAct extends BaseAct<ICourtAnnoPre> implements ICourtAnnoView {
    @BindView(R.id.rcv)
    XRecyclerView rcv;


    private BaseRecyclerAdapter<CourtAnnoBean> mAdp;
    private List<CourtAnnoBean> datas = new ArrayList<>();

    private String companyId;

    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("法院公告");
        mPresenter=new CourtAnnoPreImpl(this);
        companyId = getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter.getCourtAnnoDatas(companyId);
        initFrg();
    }

    private void initFrg() {
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, this, false);
        mAdp = new BaseRecyclerAdapter<CourtAnnoBean>(this, datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_courtannouncement_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, CourtAnnoBean item) {
                holder.getTextView(R.id.tvName).setText(item.getPerson());
                holder.getTextView(R.id.tvType).setText(item.getType());
                holder.getTextView(R.id.tvContent).setText(item.getContent());
                holder.getTextView(R.id.tvCourtName).setText(item.getCourt());
                holder.getTextView(R.id.tvTime).setText(item.getDate());
            }
        };
        rcv.setAdapter(mAdp);
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getCourtAnnoDatas(companyId);
            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    @Override
    public void setCourtAnno(List<CourtAnnoBean> mdatas) {
        rcv.refreshComplete();
        datas = mdatas;
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
