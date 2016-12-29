package com.boyuanitsm.echinfo.module.mine.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.widget.MineItemView;
import com.boyuanitsm.tools.view.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的界面
 * Created by Yang on 2016/12/27 0027.
 */
public class MineAct extends BaseAct {
    @BindView(R.id.civ_head)
    CircleImageView civ_head;//头像
    @BindView(R.id.miv_phone)
    MineItemView miv_phone;//电话
    @BindView(R.id.miv_changePwd)
    MineItemView miv_changePwd;//改密码
    @BindView(R.id.miv_name)
    MineItemView miv_name;//姓名
    @BindView(R.id.miv_company)
    MineItemView miv_company;//公司
    @BindView(R.id.miv_profession)
    MineItemView miv_profession;//职业

    @Override
    public int getLayout() {
        return R.layout.act_mine;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("修改资料");
    }

    @OnClick({R.id.ll_head, R.id.miv_phone, R.id.miv_changePwd, R.id.miv_name, R.id.miv_company
            , R.id.miv_profession})
    public void OnClick(View v) {
        Bundle bundle;
        switch (v.getId()) {
            case R.id.ll_head://头像
                break;
            case R.id.miv_phone:
                break;
            case R.id.miv_changePwd:
                bundle = new Bundle();
                bundle.putInt(EditAct.USER_TYPE,1);
                openActivity(EditAct.class,bundle);
                break;
            case R.id.miv_name:
                bundle = new Bundle();
                bundle.putInt(EditAct.USER_TYPE,2);
                openActivity(EditAct.class,bundle);
                break;
            case R.id.miv_company:
                bundle = new Bundle();
                bundle.putInt(EditAct.USER_TYPE,3);
                openActivity(EditAct.class,bundle);
                break;
            case R.id.miv_profession:
                break;
        }
    }
}
