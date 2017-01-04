package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.utils.ToolsUtils;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 企业年报
 * Created by Yang on 2017/1/4 0004.
 */
public class YearReportsAct extends BaseAct{
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
        setTopTitle("企业年报");
        setRightBtn("纠错", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ErrorCorrectionAct.class);
            }
        });
        initFrg();
    }

    private void initFrg() {
        testList = EchinfoUtils.getTestDatas(3);
        View view = new View(this);
        view.setMinimumHeight(30);
        view.setMinimumWidth(ToolsUtils.getScreenWidth(this));
        view.setBackgroundColor(getResources().getColor(R.color.bg_grey_color));
        rcv.addHeaderView(view);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), true);
        mAdp = new BaseRecyclerAdapter<String>(getApplicationContext(), testList) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_yearreports_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        mAdp.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        rcv.setAdapter(mAdp);
    }
}
