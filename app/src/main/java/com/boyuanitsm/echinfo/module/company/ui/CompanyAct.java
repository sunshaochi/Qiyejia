package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ScrollView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.CompanyAdapter;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.module.company.presenter.CompanyPreImpl;
import com.boyuanitsm.echinfo.module.company.presenter.ICompanyPre;
import com.boyuanitsm.echinfo.module.company.view.ICompanyView;
import com.boyuanitsm.echinfo.module.mine.ui.ShareDialogAct;
import com.boyuanitsm.echinfo.widget.MyGridView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 公司信息
 * Created by wangbin on 17/1/4.
 */
public class CompanyAct extends BaseAct<ICompanyPre> implements ICompanyView{
    //公司id
    public static final String COMAPYT_ID="company_id";
    private String companyId;
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
    @BindView(R.id.sv)
    ScrollView sv;

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
    private String[] property_titles = {"财物数据", "股权出资", "税务信用", "融资纪录"};
    private int property_images[] = {R.mipmap.cwsjico, R.mipmap.gqczico, R.mipmap.swxyico, R.mipmap.rzjlico};
    private String[] property_des = {"2", "3", "4", "5",};

    /*企业多维*/
    private String[] company_titles = {"招聘", "企业资讯", "注册网站", "产品信息", "舆情口碑", "清算信息"};
    private int[] company_images = {R.mipmap.zpico, R.mipmap.qynewsico, R.mipmap.websiteico, R.mipmap.cpxxico,
            R.mipmap.yqkbico, R.mipmap.qsxxico};
    private String[] company_des = {"2", "3", "4", "5", "2", "3"};

    private CompanyAdapter basicAdp, riskAdp, knowledgeAdp, propertyAdp, companyAdp;


    @Override
    public int getLayout() {
        return R.layout.act_company;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("华东控股集团有限公司");
        companyId=getIntent().getStringExtra(COMAPYT_ID);
        mPresenter=new CompanyPreImpl(this);
        mPresenter.getCompanyDetail(companyId);
        initGv();
        initOnItemClick();
        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }).start();
    }

    private void initGv() {
        basicAdp = new CompanyAdapter(this, basic_images, basic_titles, basic_des);
        riskAdp = new CompanyAdapter(this, risk_images, risk_titles, risk_des);
        knowledgeAdp = new CompanyAdapter(this, knowledge_images, knowledge_titles, knowledge_des);
        propertyAdp = new CompanyAdapter(this, property_images, property_titles, property_des);
        companyAdp = new CompanyAdapter(this, company_images, company_titles, company_des);
        gvBasic.setAdapter(basicAdp);
        gvRisk.setAdapter(riskAdp);
        gvKnowledge.setAdapter(knowledgeAdp);
        gvProperty.setAdapter(propertyAdp);
        gvCompany.setAdapter(companyAdp);
    }

    private void initOnItemClick() {
        gvBasic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0://工商信息
                        openActivity(BusinessInfoAct.class);
                        break;
                    case 1://对外投资
                        openActivity(ForeignInvestmentAct.class);
                        break;
                    case 2://企业年报
                        openActivity(YearReportsAct.class);
                        break;
                    case 3://企业图谱
                        break;
                    case 4://行业分析
                        break;
                    case 5://资产信息
                        openActivity(AssetInfoAct.class);
                        break;
                }
            }
        });

        gvRisk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0://法院公告
                        openActivity(CourtAnnouncementAct.class);
                        break;
                    case 1://被执行人
                        openActivity(ExecutedPersonAct.class);
                        break;
                    case 2://失信信息
                        openActivity(CreditInfoAct.class);
                        break;
                    case 3://法院判决
                        openActivity(CourtDecisionAct.class);
                        break;
                    case 4://诉讼信息
                        openActivity(LitigationInfoAct.class);
                        break;
                    case 5://行政处罚
                        openActivity(PunishmentAct.class);
                        break;
                    case 6://经营异常
                        openActivity(AbnormalOperationAct.class);
                        break;
                    case 7://抽查检查
                        openActivity(SpotCheckAct.class);
                        break;
                }
            }
        });

        gvKnowledge.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0://专利
                        openActivity(PatentInfoAct.class);
                        break;
                    case 1://商标
                        break;
                    case 2://著作权
                        openActivity(CopyrightAct.class);
                        break;
                    case 3://企业证书
                        break;
                }
            }
        });

        gvProperty.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0://财务数据
                        break;
                    case 1://股权出资
                        openActivity(EquityAct.class);
                        break;
                    case 2://税务信用
                        break;
                    case 3://融资记录
                        openActivity(FinancingInfoAct.class);
                        break;
                }
            }
        });

        gvCompany.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0://招聘
                        openActivity(RecruitmentAct.class);
                        break;
                    case 1://企业资讯
                        openActivity(EnterpriseInfoAct.class);
                        break;
                    case 2://注册网站
                        openActivity(WebsiteAct.class);
                        break;
                    case 3://产品信息
                        openActivity(ProductInfoAct.class);
                        break;
                    case 4://舆情口碑
                        openActivity(OpinionAct.class);
                        break;
                    case 5://清算信息
                        openActivity(ClearingInfoAct.class);
                        break;
                }
            }
        });
    }

    @OnClick({R.id.rlShare,R.id.cvEmail,R.id.cvWz,R.id.cvAddress,R.id.llHome,R.id.llFollow,R.id.llBg,R.id.llComment,R.id.llJk})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlShare:
                openActivity(ShareDialogAct.class);
                break;
            case R.id.cvEmail://邮箱

                break;
            case R.id.cvWz://网站

                break;
            case R.id.cvAddress://地址

                break;
            case R.id.llHome://首页

                break;
            case R.id.llFollow: //关注

                break;
            case R.id.llBg: // 报告

                break;
            case R.id.llComment: //点评

                break;
            case R.id.llJk://监控

                break;
        }
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            sv.scrollTo(0,10);
        }
    };


    @Override
    public void setCompanyMes(CompanyBean companyBean) {

    }

    @Override
    public void requestError(int status, String errorMsg) {
         toast(errorMsg);
    }
}
