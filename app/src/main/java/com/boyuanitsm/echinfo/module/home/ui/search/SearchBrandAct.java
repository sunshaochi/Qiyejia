package com.boyuanitsm.echinfo.module.home.ui.search;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.ClearEditText;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 查商标
 * Q164454216
 * Created by xiaoke on 2016/12/30.
 */

public class SearchBrandAct extends BaseAct {
    @BindView(R.id.xr)
    XRecyclerView xr;
    @BindView(R.id.query)
    ClearEditText query;
    private BaseRecyclerAdapter<String> myAdapter;//查商标适配器
    private List<String> datas = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.search_brand;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        datas = EchinfoUtils.getTestDatas(4);
        xr = EchinfoUtils.getLinearRecyclerView(xr, getApplicationContext(), false);
        initData();
    }

    private void initData() {
        query.setHint("请输入注册号，商标名或公司名");
        myAdapter = new BaseRecyclerAdapter<String>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.xr_searchbrand;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        xr.setAdapter(myAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
