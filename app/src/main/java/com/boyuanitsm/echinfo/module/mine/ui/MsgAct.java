package com.boyuanitsm.echinfo.module.mine.ui;

import android.os.Bundle;
import android.view.View;

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
 * 消息界面
 * Created by Yang on 2016/12/29 0029.
 */
public class MsgAct extends BaseAct {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private List<String> testList = new ArrayList<>();
    private BaseRecyclerAdapter<String> mAdp;
    @Override
    public int getLayout() {
        return R.layout.act_msg;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("系统消息");
        setRightBtn("一键清空", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        initRcv();
    }

    private void initRcv() {
        testList = EchinfoUtils.getTestDatas(4);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), false);
        rcv.setPullRefreshEnabled(false);
        mAdp= new BaseRecyclerAdapter<String>(getApplicationContext(), testList) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_item_msg;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        rcv.setAdapter(mAdp);
    }
}
