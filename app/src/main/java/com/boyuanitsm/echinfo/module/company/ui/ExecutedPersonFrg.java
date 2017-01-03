package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.utils.ToolsUtils;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 被执行人frg
 * Created by Yang on 2017/1/3 0003.
 */
public class ExecutedPersonFrg extends BaseFrg {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<String> mAdp;
    private List<String> testList = new ArrayList<>();
    private static final String EXECUTED_PARAM = "ExecutedPerson";
    private int mParam;

    public static ExecutedPersonFrg newInstance(int param) {
        ExecutedPersonFrg fragment = new ExecutedPersonFrg();
        Bundle args = new Bundle();
        args.putInt(EXECUTED_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayout() {
        return R.layout.frg_executedperson;
    }

    @Override
    protected void initView(View fragmentRootView) {
        if (getArguments() != null) {
            mParam = getArguments().getInt(EXECUTED_PARAM);
        }
        initFrg();
    }

    private void initFrg() {
        if (mParam == 1) {
            testList = EchinfoUtils.getTestDatas(5);
        } else if (mParam == 2) {
            testList = EchinfoUtils.getTestDatas(3);
        }
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getContext(), true);
        View view = View.inflate(getContext(), R.layout.view_frg_executed_head, null);
        view.setMinimumWidth(ToolsUtils.getScreenWidth(getActivity()));
        rcv.addHeaderView(view);
        mAdp = new BaseRecyclerAdapter<String>(getContext(), testList) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_executed_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        rcv.setAdapter(mAdp);
    }
}
