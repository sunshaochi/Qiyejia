package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

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
 * 招聘
 * Created by Yang on 2017/1/5 0005.
 */
public class RecruitmentAct extends BaseAct{
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<String> mAdp;
    private List<String> testList = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("招聘信息");
        initFrg();
    }

    private void initFrg() {
        testList = EchinfoUtils.getTestDatas(3);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), true);
        mAdp = new BaseRecyclerAdapter<String>(getApplicationContext(), testList) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_recruitment_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        rcv.setAdapter(mAdp);
    }
}
