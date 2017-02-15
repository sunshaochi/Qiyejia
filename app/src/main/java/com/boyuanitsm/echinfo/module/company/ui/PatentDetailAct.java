package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.PatenInfomationBean;
import com.boyuanitsm.echinfo.widget.MineItemView;

import butterknife.BindView;

/**
 * 专利详情信息
 * Created by Yang on 2017/1/5 0005.
 */
public class PatentDetailAct extends BaseAct {
    public static final String PATENT_DETAIL = "patent_detail";
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvSqNo)
    TextView tvSqNo;
    @BindView(R.id.tvSqDate)
    TextView tvSqDate;
    @BindView(R.id.tvPublishNo)
    TextView tvPublishNo;
    @BindView(R.id.tvPublishDate)
    TextView tvPublishDate;
    @BindView(R.id.mivAgency)
    MineItemView mivAgency;
    @BindView(R.id.mivInventor)
    MineItemView mivInventor;
    @BindView(R.id.mivType)
    MineItemView mivType;
    @BindView(R.id.mivState)
    MineItemView mivState;
    @BindView(R.id.tvDetail)
    TextView tvDetail;
    private PatenInfomationBean patenInfomationBean;

    @Override
    public int getLayout() {
        return R.layout.act_patentdetail;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("专利详细信息");
        patenInfomationBean = getIntent().getParcelableExtra(PATENT_DETAIL);
        tvName.setText(patenInfomationBean.getName());
        tvSqNo.setText(patenInfomationBean.getApplicationNo());
        tvSqDate.setText(patenInfomationBean.getCreateDate());
        tvPublishNo.setText(patenInfomationBean.getPublishedApplyNo());
        tvPublishDate.setText(patenInfomationBean.getPublishedApplyDate());
        mivAgency.setRightText(patenInfomationBean.getPatentAgency());
        mivInventor.setRightText(patenInfomationBean.getInventor());
        mivType.setRightText(patenInfomationBean.getPatenType());
        mivState.setRightText(patenInfomationBean.getState());
        tvDetail.setText(patenInfomationBean.getPatentContent());
    }


}
