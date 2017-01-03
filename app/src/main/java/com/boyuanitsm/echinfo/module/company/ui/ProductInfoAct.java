package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.MineItemView;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 产品信息
 * Created by Yang on 2017/1/3 0003.
 */
public class ProductInfoAct extends BaseAct {
    @BindView(R.id.miv_name)
    MineItemView miv_name;//名称
    @BindView(R.id.miv_urlAddress)
    MineItemView miv_urlAddress;//网址
    @BindView(R.id.miv_field)
    MineItemView miv_field;//所属领域
    @BindView(R.id.miv_industry)
    MineItemView miv_industry;//行业
    @BindView(R.id.miv_tag)
    MineItemView miv_tag;//标签
    @BindView(R.id.tv_introduce)
    TextView tv_introduce;//介绍
    @BindView(R.id.rcv)
    XRecyclerView rcv;//用户评论列表

    private BaseRecyclerAdapter<String> mAdp;
    private List<String> testList = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.act_productinfo;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("产品信息");
        initFrg();
    }

    private void initFrg() {
        testList = EchinfoUtils.getTestDatas(3);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), false);
        rcv.setPullRefreshEnabled(false);
        mAdp = new BaseRecyclerAdapter<String>(getApplicationContext(), testList) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_comment_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        rcv.setAdapter(mAdp);
    }

    public void openMoreComment(View view){

    }
}
