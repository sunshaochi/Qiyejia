package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.QiYeZsBean;
import com.boyuanitsm.echinfo.module.company.presenter.IQiYeZsPre;
import com.boyuanitsm.echinfo.module.company.presenter.QiYeZsPreImpl;
import com.boyuanitsm.echinfo.module.company.view.IQiYeZsView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 企业证书列表
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public class QiYeZsAct extends BaseAct<IQiYeZsPre> implements IQiYeZsView {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<QiYeZsBean> mAdp;
    private List<QiYeZsBean> datas = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.act_qiye;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("企业证书");
        mPresenter = new QiYeZsPreImpl(this);
        mPresenter.getQiYeList("123456789");
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), false);
        mAdp = new BaseRecyclerAdapter<QiYeZsBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_qiye_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, QiYeZsBean item) {
                holder.getTextView(R.id.tv_name).setText(item.getRemark());
            }
        };
        mAdp.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(QiYeZsInfo.QIYE_INFO, datas.get(position - 1));
                openActivity(CreditDetailAct.class, bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        rcv.setAdapter(mAdp);
    }

    @Override
    public void getQiYeZsListSucess(List<QiYeZsBean> list) {
        datas = list;
        mAdp.setData(datas);
    }

    @Override
    public void getQiYeZsListFaild(int status, String errorMsg) {

    }

    @Override
    public void getQiYeNOdata() {

    }
}
