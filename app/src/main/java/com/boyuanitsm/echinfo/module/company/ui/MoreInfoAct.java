package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.text.TextUtils;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.tools.view.CommonView;

import butterknife.BindView;

/**
 * Created by bitch-1 on 2017/2/22.
 */

public class MoreInfoAct extends BaseAct {
    @BindView(R.id.cv_name)
    CommonView cv_name;//名称
    @BindView(R.id.cv_phone)
    CommonView cv_phone;//联系电话
    @BindView(R.id.cv_hangye)
    CommonView cv_hangye;//行业
    @BindView(R.id.cv_guangwang)
    CommonView cv_guangwang;//官网
    @BindView(R.id.cv_adress)
    CommonView cv_adress;//公司地址
    private CompanyBean companyBean;

    @Override
    public int getLayout() {
        return R.layout.act_moreinfo;
    }

    @Override
    public void init(Bundle savedInstanceState) {
       companyBean=getIntent().getParcelableExtra("mcompanyBean");
        if(companyBean!=null){
            if(!TextUtils.isEmpty(companyBean.getCompanyName())){
            setTopTitle(companyBean.getCompanyName());
                cv_name.setNotesText(companyBean.getCompanyName()+"");
            }
            if(!TextUtils.isEmpty(companyBean.getAddress())){
                cv_adress.setNotesText(companyBean.getAddress()+"");
            }
            if(!TextUtils.isEmpty(companyBean.getUrl())){
                cv_guangwang.setNotesText(companyBean.getUrl()+"");
            }
            if(!TextUtils.isEmpty(companyBean.getCompanyPhoneNo())){
                cv_phone.setNotesText(companyBean.getCompanyPhoneNo()+"");
            }
            if(!TextUtils.isEmpty(companyBean.getIndustry())){
                cv_hangye.setNotesText(companyBean.getIndustry()+"");
            }


        }


    }
}
