package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.GvAdapter;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.widget.MyGridView;

import butterknife.BindView;

/**经营范围act
 * Created by bitch-1 on 2017/2/7.
 */

public class JinyinFwAct extends BaseAct {
    @BindView(R.id.gv_zczb)
    MyGridView gv_zczb;//注册资本
    @BindView(R.id.gv_clnx)
    MyGridView gv_clnx;//成立年限
    @BindView(R.id.gv_ssfw)
    MyGridView gv_ssfwb;//输入年限
    private GvAdapter gvAdapter;
    @Override
    public int getLayout() {
        return R.layout.act_jinyinfw;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        gvAdapter=new GvAdapter(JinyinFwAct.this);
        gv_clnx.setAdapter(gvAdapter);
        gv_zczb.setAdapter(gvAdapter);

    }
}
