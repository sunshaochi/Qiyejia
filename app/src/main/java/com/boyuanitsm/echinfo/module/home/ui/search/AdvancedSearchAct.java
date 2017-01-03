package com.boyuanitsm.echinfo.module.home.ui.search;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 高级搜索
 * Q164454216
 * Created by xiaoke on 2016/12/30.
 */

public class AdvancedSearchAct extends BaseAct {

    @BindView(R.id.et_gsmz)
    EditText etGsmz;//公司名字
    @BindView(R.id.et_cpfw)
    EditText etCpfw;//产品服务
    @BindView(R.id.et_fr)
    EditText etFr;//法人代表
    @BindView(R.id.rl_qy)
    RelativeLayout rlQy;//区域选择
    @BindView(R.id.et_szjd)
    EditText etSzjd;//所在街道
    @BindView(R.id.et_xzl)
    EditText etXzl;//写字楼
    @BindView(R.id.rl_zczj)
    RelativeLayout rlZczj;//注册资金
    @BindView(R.id.iv_right3)
    ImageView ivRight3;
    @BindView(R.id.rl_zcsj)
    RelativeLayout rlZcsj;//注册时间

    @Override
    public int getLayout() {
        return R.layout.advanced_search;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("高级搜索");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rl_qy, R.id.rl_zczj, R.id.rl_zcsj})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_qy:
                break;
            case R.id.rl_zczj:
                openActivity(RegisterMoneyAct.class);
                break;
            case R.id.rl_zcsj:
                openActivity(RegisterTimeAct.class);
                break;
        }
    }
}
