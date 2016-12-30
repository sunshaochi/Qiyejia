package com.boyuanitsm.echinfo.module.mine.ui;

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
 * 我的关注
 * Created by Yang on 2016/12/30 0030.
 */
public class FollowAct extends BaseAct {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<String> myAdapter;//我的关注适配器
    private List<String> testList = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.act_follow;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("我的关注");
        testList = EchinfoUtils.getTestDatas(4);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), true);
        myAdapter = new BaseRecyclerAdapter<String>(getApplicationContext(),testList) {
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
