package com.boyuanitsm.echinfo.module.home.ui.find;

import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐阅读
 * Q164454216
 * Created by xiaoke on 2016/12/29.
 */

public class Scanfrg extends BaseFrg {
    private XRecyclerView rcv;
    private BaseRecyclerAdapter<String> myAdapter;//推荐阅读适配器
    private List<String> datas = new ArrayList<>();
    @Override
    public int getLayout() {
        return R.layout.scanfrg_layout;
    }

    @Override
    protected void initView(View fragmentRootView) {
        datas = EchinfoUtils.getTestDatas(4);
        rcv= (XRecyclerView) fragmentRootView.findViewById(R.id.rcv);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getContext(), false);
        initData();
    }
    /**
     * 填充数据
     */
    private void initData() {
        myAdapter= new BaseRecyclerAdapter<String>(getContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_scanfrg;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        rcv.setAdapter(myAdapter);
    }
}
