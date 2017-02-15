package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.LawsuitMsgBean;

import butterknife.BindView;

/**
 * 诉讼详情
 * Created by Yang on 2017/1/5 0005.
 */
public class LitigationDetailAct extends BaseAct {
    public static final String LITIGATION_DETAIL = "litigation_detail";
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvNo)
    TextView tvNo;
    @BindView(R.id.tvFy)
    TextView tvFy;
    @BindView(R.id.tvLaTime)
    TextView tvLaTime;
    @BindView(R.id.tvAh)
    TextView tvAh;
    @BindView(R.id.tvZx)
    TextView tvZx;
    private LawsuitMsgBean lawsuitMsgBean;


    @Override
    public int getLayout() {
        return R.layout.act_lgdetail;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("诉讼详细信息");
        lawsuitMsgBean = getIntent().getParcelableExtra(LITIGATION_DETAIL);
        tvName.setText(lawsuitMsgBean.getName());
        tvNo.setText(lawsuitMsgBean.getCardNo());
        tvFy.setText(lawsuitMsgBean.getCourt());
        tvLaTime.setText(lawsuitMsgBean.getRegistrineTime());
        tvAh.setText(lawsuitMsgBean.getCaseNo());
        tvZx.setText(lawsuitMsgBean.getZxbd());
    }


}
