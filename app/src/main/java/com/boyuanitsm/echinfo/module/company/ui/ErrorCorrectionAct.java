package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 纠错
 * Created by Yang on 2017/1/4 0004.
 */
public class ErrorCorrectionAct extends BaseAct {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<String> mAdp;
    private List<String> testList = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.act_errorcorrection;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("纠错");
        initFrg();
    }

    private void initFrg() {
        testList = EchinfoUtils.getTestDatas(16);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),4);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.setLoadingMoreEnabled(false);
        rcv.setPullRefreshEnabled(false);
        rcv.setLayoutManager(gridLayoutManager);
        mAdp = new BaseRecyclerAdapter<String>(getApplicationContext(), testList) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_errorcorrection_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        rcv.setAdapter(mAdp);
    }
}
