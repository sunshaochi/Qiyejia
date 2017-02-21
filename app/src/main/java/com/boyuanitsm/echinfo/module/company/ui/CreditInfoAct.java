package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.module.company.presenter.CrediteListPreImpl;
import com.boyuanitsm.echinfo.module.company.presenter.ICreditListPre;
import com.boyuanitsm.echinfo.module.company.view.ICrediteListView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 失信信息
 * Created by Yang on 2017/1/5 0005.
 */
public class CreditInfoAct extends BaseAct<ICreditListPre> implements ICrediteListView{
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<String> mAdp;
    private List<String> testList = new ArrayList<>();
    String sid;
    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("失信信息");
        sid=getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter=new CrediteListPreImpl(this);
        mPresenter.getICrediteByid("5550a5f9e138231700b9328e");
        setRightBtn(R.mipmap.share_circle_icon, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        initFrg();
    }

    private void initFrg() {
        testList = EchinfoUtils.getTestDatas(3);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), true);
        mAdp = new BaseRecyclerAdapter<String>(getApplicationContext(), testList) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_creditinfo_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        mAdp.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                openActivity(CreditDetailAct.class);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        rcv.setAdapter(mAdp);
    }

    @Override
    public void getCreditListSucess() {

    }

    @Override
    public void getCreditListFaild(int status, String errorMsg) {

    }
}
