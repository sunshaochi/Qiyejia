package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.SonEnterpriseBean;
import com.boyuanitsm.echinfo.widget.MineItemView;

import butterknife.BindView;

/**
 * 分支机构详情
 * Created by Yang on 2017/1/4 0004.
 */
public class BranchDetailAct extends BaseAct {

    public static final String BRANCH_DETAIL = "branch_detail";
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.mivPerson)
    MineItemView mivPerson;
    @BindView(R.id.mivRegMoney)
    MineItemView mivRegMoney;
    @BindView(R.id.mivPubTime)
    MineItemView mivPubTime;
    @BindView(R.id.mivState)
    MineItemView mivState;
    @BindView(R.id.mivHy)
    MineItemView mivHy;
    @BindView(R.id.mivRegNo)
    MineItemView mivRegNo;
    @BindView(R.id.mivType)
    MineItemView mivType;
    @BindView(R.id.mivRegCode)
    MineItemView mivRegCode;
    @BindView(R.id.mivManagerDate)
    MineItemView mivManagerDate;
    @BindView(R.id.mivDejg)
    MineItemView mivDejg;
    @BindView(R.id.mivHzTime)
    MineItemView mivHzTime;
    @BindView(R.id.mivXyCode)
    MineItemView mivXyCode;
    private SonEnterpriseBean sonEnterpriseBean;

    @Override
    public int getLayout() {
        return R.layout.act_branchdetail;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("分支机构详情");
        setRightBtn("纠错", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ErrorCorrectionAct.class);
            }
        });
        sonEnterpriseBean = getIntent().getParcelableExtra(BRANCH_DETAIL);
        tvName.setText(sonEnterpriseBean.getCompanyName());
        mivPerson.setRightText(sonEnterpriseBean.getLegalRepPersion());
        mivRegMoney.setRightText(sonEnterpriseBean.getRegisteredCapital());
        mivPubTime.setRightText(sonEnterpriseBean.getFoundingDate());
        mivState.setRightText(sonEnterpriseBean.getStatus());
        mivHy.setRightText(sonEnterpriseBean.getIndustry());
        mivRegNo.setRightText(sonEnterpriseBean.getRegisterId());
        mivType.setRightText(sonEnterpriseBean.getCompanyType());
        mivRegCode.setRightText(sonEnterpriseBean.getOrganizationCode());//组织机构代码
        mivManagerDate.setRightText(sonEnterpriseBean.getBusinessTerm());
        mivDejg.setRightText(sonEnterpriseBean.getRegisterPlace());

        mivHzTime.setRightText(sonEnterpriseBean.getApprovedDate());
        mivXyCode.setRightText(sonEnterpriseBean.getCreditCode());
    }

}
