package com.boyuanitsm.echinfo.module.home.ui;

import android.view.View;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.module.mine.ui.MineAct;
import com.boyuanitsm.echinfo.widget.MineItemView;
import com.boyuanitsm.tools.view.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的
 * Created by wangbin on 16/12/22.
 */
public class MineFrg extends BaseFrg {
    @BindView(R.id.civ_head)
    CircleImageView civ_head;//头像
    @BindView(R.id.tv_name)
    TextView tv_name;//姓名
    @BindView(R.id.tv_profession)
    TextView tv_profession;//职业
    @BindView(R.id.tv_company)
    TextView tv_company;//公司
    @BindView(R.id.miv_gz)
    MineItemView miv_gz;//关注
    @BindView(R.id.miv_xx)
    MineItemView miv_xx;//消息
    @BindView(R.id.miv_fk)
    MineItemView miv_fk;//意见反馈
    @BindView(R.id.miv_wt)
    MineItemView miv_wt;//常见问题
    @BindView(R.id.miv_sz)
    MineItemView miv_sz;//设置

    @Override
    public int getLayout() {
        return R.layout.frg_mine;

    }

    @Override
    protected void initView(View fragmentRootView) {

    }

    @OnClick({R.id.ll_mine, R.id.miv_gz, R.id.miv_xx, R.id.miv_fk, R.id.miv_wt, R.id.miv_sz})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.ll_mine:
                openActivity(MineAct.class);
                break;
            case R.id.miv_gz:
                break;
            case R.id.miv_xx:
                break;
            case R.id.miv_fk:
                break;
            case R.id.miv_wt:
                break;
            case R.id.miv_sz:
                break;
        }
    }
}
