package com.boyuanitsm.echinfo.module.home.ui;

import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 关注
 * Created by wangbin on 16/12/22.
 */
public class FollowFrg extends BaseFrg {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<String> myAdapter;//我的关注适配器
    private List<String> testList = new ArrayList<>();
    @Override
    public int getLayout() {
        return R.layout.frg_follow;
    }

    @Override
    protected void initView(View fragmentRootView) {
        testList = EchinfoUtils.getTestDatas(4);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getContext(), true);
        myAdapter = new BaseRecyclerAdapter<String>(getContext(),testList) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_item_follow;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        rcv.setAdapter(myAdapter);
    }
}
