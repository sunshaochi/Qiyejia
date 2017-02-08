package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.GvAdapter;
import com.boyuanitsm.echinfo.adapter.TagAdapter;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.widget.MyGridView;
import com.boyuanitsm.tools.view.FlowTag.FlowTagLayout;
import com.boyuanitsm.tools.view.FlowTag.OnTagSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**经营范围act
 * Created by bitch-1 on 2017/2/7.
 */

public class JinyinFwAct extends BaseAct {
    @BindView(R.id.gv_zczb)
    MyGridView gv_zczb;//注册资本
    @BindView(R.id.gv_clnx)
    MyGridView gv_clnx;//成立年限
    @BindView(R.id.size_flow_layout)
    FlowTagLayout mSizeFlowTagLayout;//

    private TagAdapter<String> mSizeTagAdapter;

    private GvAdapter gvAdapter;

    @Override
    public int getLayout() {
        return R.layout.act_jinyinfw;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        gvAdapter=new GvAdapter(JinyinFwAct.this);
        gv_clnx.setAdapter(gvAdapter);//成立年限
        gv_zczb.setAdapter(gvAdapter);//注册资本

        mSizeTagAdapter = new TagAdapter<>(this);
        mSizeFlowTagLayout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_SINGLE);//设置是单选
        mSizeFlowTagLayout.setAdapter(mSizeTagAdapter);
        mSizeFlowTagLayout.setOnTagSelectListener(new OnTagSelectListener() {
            @Override
            public void onItemSelect(FlowTagLayout parent, List<Integer> selectedList) {

            }
        });

        initSdata();//填充收索数据

    }


    /**
     * 填充数据
     */
    private void initSdata() {
        List<String> sdatasource=new ArrayList<>();
        sdatasource.add("按名称查");
        sdatasource.add("按地址查");
        sdatasource.add("按经营范围查");
        sdatasource.add("按品牌/产品查");
        sdatasource.add("按法定代表人查");
        mSizeTagAdapter.onlyAddAll(sdatasource);
    }


}

