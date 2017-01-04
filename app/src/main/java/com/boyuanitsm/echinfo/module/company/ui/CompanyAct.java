package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.CompanyAdapter;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.module.mine.ui.ShareDialogAct;
import com.boyuanitsm.echinfo.widget.MyGridView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 公司信息
 * Created by wangbin on 17/1/4.
 */
public class CompanyAct extends BaseAct {
    @BindView(R.id.gvBasic)
    MyGridView gvBasic;//基础信息
    @BindView(R.id.gvRisk)
    MyGridView gvRisk;//风险信息
    @BindView(R.id.gvKnowledge)
    MyGridView gvKnowledge;//知识产权
    @BindView(R.id.gvProperty)
    MyGridView gvProperty;//财物信息
    @BindView(R.id.gvCompany)
    MyGridView gvCompany;//企业多维

    /*基础信息*/
    private String[] basic_titles = {"工商信息", "对外投资", "企业年报", "企业图谱", "行业分析", "资产信息"};
    private int[] basic_images = {R.mipmap.gsxxico, R.mipmap.dwtzico, R.mipmap.qynbico, R.mipmap.qytpico,
            R.mipmap.hyfxico, R.mipmap.zcxxico};
    private String[] basic_des = {"2", "3", "4", "5", "2", "1"};

    /*风险信息*/
    private String[] risk_titles = {"法院公告", "被执行人", "失信信息", "法院裁决", "诉讼信息", "行政处罚", "经营异常", "抽查检查"};
    private int[] risk_images = {R.mipmap.fyggico, R.mipmap.bzxrico, R.mipmap.sxxxico, R.mipmap.fypjico,
            R.mipmap.ssxxico, R.mipmap.xzcfico, R.mipmap.jyycico, R.mipmap.ccjcico};
    private String[] risk_des = {"2", "3", "4", "5", "2", "1", "4", "5"};
    /*知识产权*/
    private String[] knowledge_titles = {"专利", "商标", "著作权", "企业证书"};
    private int[] knowledge_images = {R.mipmap.zlcpico, R.mipmap.sbico, R.mipmap.zzqic, R.mipmap.qyzsico};
    private String[] knowledge_des = {"2", "3", "4", "5",};

    /*财物信息*/
    private String [] property_titles={"财物数据","股权出质","税务信用","融资纪录"};
    private int property_images[]={R.mipmap.cwsjico,R.mipmap.gqczico,R.mipmap.swxyico,R.mipmap.rzjlico};
    private String[] property_des = {"2", "3", "4", "5",};

    /*企业多维*/
    private String [] company_titles={"招聘","企业资讯","注册网站","产品信息","舆情口碑","清算信息"};
    private int [] company_images={R.mipmap.zpico,R.mipmap.qynewsico,R.mipmap.websiteico,R.mipmap.cpxxico,
    R.mipmap.yqkbico,R.mipmap.qsxxico};
    private String[] company_des = {"2", "3", "4", "5","2","3"};

    @Override
    public int getLayout() {
        return R.layout.act_company;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("华东控股集团有限公司");
        gvBasic.setAdapter(new CompanyAdapter(this, basic_images, basic_titles, basic_des));
        gvRisk.setAdapter(new CompanyAdapter(this, risk_images, risk_titles, risk_des));
        gvKnowledge.setAdapter(new CompanyAdapter(this,knowledge_images,knowledge_titles,knowledge_des));
        gvProperty.setAdapter(new CompanyAdapter(this,property_images,property_titles,property_des));
        gvCompany.setAdapter(new CompanyAdapter(this,company_images,company_titles,company_des));

    }


    @OnClick({R.id.rlShare})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlShare:
                openActivity(ShareDialogAct.class);
                break;
        }
    }
}
