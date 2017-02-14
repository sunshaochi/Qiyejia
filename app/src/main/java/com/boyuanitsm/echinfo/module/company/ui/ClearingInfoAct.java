package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.ClearinfoBean;
import com.boyuanitsm.echinfo.bean.RecruiBean;
import com.boyuanitsm.echinfo.module.company.presenter.IClearPre;
import com.boyuanitsm.echinfo.module.company.presenter.IClearPreIml;
import com.boyuanitsm.echinfo.module.company.view.IClearView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.MyGridView;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 清算信息
 * Created by Yang on 2017/1/5 0005.
 */
public class ClearingInfoAct extends BaseAct<IClearPre> implements IClearView {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<ClearinfoBean> mAdp;
    private List<ClearinfoBean> datas = new ArrayList<>();

    private String companyId;

    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("清算信息");
        mPresenter=new IClearPreIml(this);
        companyId = getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter.getClearinfoDatas(companyId);
        setRightBtn("纠错", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ErrorCorrectionAct.class);
            }
        });
        initFrg();
    }

    private void initFrg() {
//        testList = EchinfoUtils.getTestDatas(3);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), true);
        mAdp = new BaseRecyclerAdapter<ClearinfoBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_clearing_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, ClearinfoBean item) {
                holder.getTextView(R.id.tv_zy).setText(item.getMainPerson());

                MyGridView gridView = (MyGridView) holder.getView(R.id.mgv_clearing);
                gridView.setClickable(false);
                gridView.setPressed(false);
                gridView.setEnabled(false);
                gridView.setAdapter(new MyAdp());
                holder.getView(R.id.ll_clearing_member).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openActivity(ClearingMemberAct.class);
                    }
                });
            }
        };
        rcv.setAdapter(mAdp);
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getClearinfoDatas(companyId);
            }

            @Override
            public void onLoadMore() {

            }
        });
    }



    @Override
    public void setCourtClear(List<ClearinfoBean> mdatas) {
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

    private class MyAdp extends BaseAdapter {

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(getApplicationContext(), R.layout.mgv_clearing_item, null);
            }
            return view;
        }
    }
}
