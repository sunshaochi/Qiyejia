package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.PatenInfomationBean;
import com.boyuanitsm.echinfo.module.company.presenter.ICompanyBasePre;
import com.boyuanitsm.echinfo.module.company.presenter.PatentInfoPreImpl;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 专利信息
 * Created by Yang on 2017/1/5 0005.
 */
public class PatentInfoAct extends BaseAct<ICompanyBasePre> implements IBaseListView<PatenInfomationBean>{
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<PatenInfomationBean> mAdp;
    private List<PatenInfomationBean> datas = new ArrayList<>();

    private String companyId;
    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("专利信息");
        mPresenter=new PatentInfoPreImpl(this);
        companyId=getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter.getDatas(companyId);
        initFrg();
    }

    private void initFrg() {
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, this, false);
        mAdp = new BaseRecyclerAdapter<PatenInfomationBean>(this, datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_patentinfo_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, PatenInfomationBean item) {
                holder.getTextView(R.id.tvName).setText(item.getName());
                holder.getTextView(R.id.tvType).setText(item.getPatenType());
                holder.getTextView(R.id.tvSqTime).setText(item.getCreateDate());
            }
        };
        mAdp.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putParcelable(PatentDetailAct.PATENT_DETAIL,datas.get(position-1));
                openActivity(PatentDetailAct.class,bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
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
    public void setDatas(List<PatenInfomationBean> mDatas) {
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
