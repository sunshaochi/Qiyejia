package com.boyuanitsm.echinfo.module.home.ui.search;

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
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 查询结果
 * Q164454216
 * Created by xiaoke on 2017/1/3.
 */

public class SearchResultAct extends BaseAct {

    @BindView(R.id.xr)
    XRecyclerView xr;
    private BaseRecyclerAdapter<String> myAdapter;//搜索结果适配器
    private List<String> datas = new ArrayList<>();
    @Override
    public int getLayout() {
        return R.layout.search_result;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("搜索结果");
        xr = EchinfoUtils.getLinearRecyclerView(xr, getApplicationContext(), false);
        datas = EchinfoUtils.getTestDatas(4);
        initData();
    }

    /**
     * 填充数据
     */

    private void initData() {
        if (myAdapter == null) {
            myAdapter = new BaseRecyclerAdapter<String>(getApplicationContext(), datas) {
                @Override
                public int getItemLayoutId(int viewType) {
                    return R.layout.xr_item_result;
                }

                @Override
                public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

                }
            };
        }
        xr.setAdapter(myAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.xr)
    public void onClick() {

    }
}
