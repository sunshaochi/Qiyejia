package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.CompanyAdapter;
import com.boyuanitsm.echinfo.adapter.TagAdapter;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.module.company.presenter.CompanyPreImpl;
import com.boyuanitsm.echinfo.module.company.presenter.ICompanyPre;
import com.boyuanitsm.echinfo.module.company.view.ICompanyView;
import com.boyuanitsm.echinfo.module.mine.ui.ShareDialogAct;
import com.boyuanitsm.echinfo.widget.MyGridView;
import com.boyuanitsm.tools.view.CommonView;
import com.boyuanitsm.tools.view.FlowTag.FlowTagLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 公司信息
 * Created by wangbin on 17/1/4.
 */
public class CompanyAct extends BaseAct<ICompanyPre> implements ICompanyView {
    //公司id
    public static final String COMAPYT_ID = "company_id";
    private String companyId;
    private String companyname;//公司名称带到股权出资里面去

    @BindView(R.id.tvPerson)
    TextView tvPerson;//法人代表
    @BindView(R.id.tvRegMoney)
    TextView tvRegMoney;//注册资金
    @BindView(R.id.tvPublishTime)
    TextView tvPublishTime;//成立日期
    @BindView(R.id.tvUpdateTime)
    TextView tvUpdateTime;//更新日期
    @BindView(R.id.tvLl)
    TextView tvLl;//浏览量
    @BindView(R.id.tvFollow)
    TextView tvFollow;//关注量
    @BindView(R.id.tvCommentNum)
    TextView tvCommentNum;//评论量
    @BindView(R.id.tvPhone)
    TextView tvPhone;//联系方式
    @BindView(R.id.cvEmail)
    CommonView cvEmail;//邮箱

    @BindView(R.id.cvWz)
    CommonView cvWz;//网址
    @BindView(R.id.cvAddress)
    CommonView cvAddress;//地址

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
    @BindView(R.id.ivAtten)
    ImageView ivAtten;//关注图片
    @BindView(R.id.size_flow_layout)
    FlowTagLayout size_flow_layout;
    private TagAdapter<String> mSizeTagAdapter;

    private CompanyBean mcompanyBean;

    private boolean isatt;

    /*基础信息*/
    private String[] basic_titles = {"工商信息", "对外投资", "企业年报", "企业图谱", "行业分析", "资产信息"};
    private int[] basic_images = {R.mipmap.gsxxico, R.mipmap.dwtzico, R.mipmap.qynbico, R.mipmap.qytpico,
            R.mipmap.hyfxico, R.mipmap.zcxxico};


    /*风险信息*/
    private String[] risk_titles = {"法院公告", "被执行人", "失信信息", "法院裁决", "诉讼信息", "行政处罚", "经营异常"};//, "抽查检查"
    private int[] risk_images = {R.mipmap.fyggico, R.mipmap.bzxrico, R.mipmap.sxxxico, R.mipmap.fypjico,
            R.mipmap.ssxxico, R.mipmap.xzcfico, R.mipmap.jyycico};//, R.mipmap.ccjcico

    /*知识产权*/
    private String[] knowledge_titles = {"专利", "商标", "著作权", "企业证书"};
    private int[] knowledge_images = {R.mipmap.zlcpico, R.mipmap.sbico, R.mipmap.zzqic, R.mipmap.qyzsico};


    /*财物信息*/
    private String[] property_titles = { "股权出资", "税务信用", "融资纪录"};//"财物数据",
    private int property_images[] = { R.mipmap.gqczico, R.mipmap.swxyico, R.mipmap.rzjlico};//R.mipmap.cwsjico,


    /*企业多维*/
    private String[] company_titles = {"招聘", "企业资讯", "注册网站", "产品信息", "清算信息"};//"舆情口碑",
    private int[] company_images = {R.mipmap.zpico, R.mipmap.qynewsico, R.mipmap.websiteico, R.mipmap.cpxxico,
            R.mipmap.qsxxico};// R.mipmap.yqkbico,


    private CompanyAdapter basicAdp, riskAdp, knowledgeAdp, propertyAdp, companyAdp;

    private Bundle bundle=new Bundle();
    @Override
    public int getLayout() {
        return R.layout.act_company;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        companyId = getIntent().getStringExtra(COMAPYT_ID);
        mPresenter = new CompanyPreImpl(this);
        mPresenter.getCompanyDetail(companyId);
        initOnItemClick();
//        bundle.putString(COMAPYT_ID,companyId);
        bundle.putString(COMAPYT_ID,"123456789");

    }


    private void initOnItemClick() {
        gvBasic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0://工商信息
                        openActivity(BusinessInfoAct.class,bundle);
                        break;
                    case 1://对外投资
                        openActivity(ForeignInvestmentAct.class,bundle);
                        break;
                    case 2://企业年报
                        openActivity(YearReportsAct.class,bundle);
                        break;
                    case 3://企业图谱
                        break;
                    case 4://行业分析
                        break;
                    case 5://资产信息
                        openActivity(AssetInfoAct.class,bundle);
                        break;
                }
            }
        });

        gvRisk.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0://法院公告
                        openActivity(CourtAnnouncementAct.class,bundle);
                        break;
                    case 1://被执行人
                        openActivity(ExecutedPersonAct.class,bundle);
                        break;
                    case 2://失信信息
                        openActivity(CreditInfoAct.class,bundle);
                        break;
                    case 3://法院判决
                        openActivity(CourtDecisionAct.class,bundle);
                        break;
                    case 4://诉讼信息
                        openActivity(LitigationInfoAct.class,bundle);
                        break;
                    case 5://行政处罚
                        openActivity(PunishmentAct.class,bundle);
                        break;
                    case 6://经营异常
                        openActivity(AbnormalOperationAct.class,bundle);
                        break;
//                    case 7://抽查检查
//                        openActivity(SpotCheckAct.class,bundle);
//                        break;
                }
            }
        });

        gvKnowledge.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0://专利
                        openActivity(PatentInfoAct.class,bundle);
                        break;
                    case 1://商标
                        openActivity(FindBrandInfoAct.class,bundle);
                        break;
                    case 2://著作权
                        openActivity(CopyrightAct.class,bundle);
                        break;
                    case 3://企业证书
                        openActivity(QiYeZsAct.class,bundle);
                        break;
                }
            }
        });

        gvProperty.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
//                    case 0://财务数据
//                        break;
                    case 0://股权出资
                        bundle.putString("companyname",companyname);
                        openActivity(EquityAct.class,bundle);
                        break;
                    case 1://税务信用
                        openActivity(SuiWuInfo.class,bundle);
                        break;
                    case 2://融资记录
                        openActivity(FinancingInfoAct.class,bundle);
                        break;
                }
            }
        });

        gvCompany.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0://招聘
                        openActivity(RecruitmentAct.class,bundle);
                        break;
                    case 1://企业资讯
                        openActivity(EnterpriseInfoAct.class,bundle);
                        break;
                    case 2://注册网站
                        openActivity(WebsiteAct.class,bundle);
                        break;
                    case 3://产品信息
                        openActivity(ProductInfoAct.class,bundle);
                        break;
//                    case 4://舆情口碑
//                        openActivity(OpinionAct.class,bundle);
//                        break;
                    case 4://清算信息
                        openActivity(ClearingInfoAct.class,bundle);
                        break;
                }
            }
        });
    }

    @OnClick({R.id.rlShare, R.id.cvEmail, R.id.cvWz, R.id.cvAddress, R.id.llHome, R.id.llFollow, R.id.llBg, R.id.llComment, R.id.llJk,R.id.ll_gd})
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
                if(!isatt){
                    mPresenter.addInsertAtt(companyId);
                }else {
                    mPresenter.removeAtt(companyId);
                }

                break;
            case R.id.llBg: // 报告

                break;
            case R.id.llComment: //点评

                break;
            case R.id.llJk://监控

                break;
            case R.id.ll_gd://更多企业信息
                Bundle bundle=new Bundle();
//
                bundle.putParcelable("mcompanyBean",mcompanyBean);
                openActivity(MoreInfoAct.class,bundle);
                break;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            sv.scrollTo(0, 10);
        }
    };


    @Override
    public void setCompanyMes(CompanyBean companyBean) {
        if(mcompanyBean!=null){
            mcompanyBean=null;
        }
        if(!TextUtils.isEmpty(companyname)){
            companyname="";
        }
        mcompanyBean=companyBean;
        companyname=companyBean.getCompanyName();//公司姓名
        setTopTitle(companyBean.getCompanyName());
        tvPerson.setText(companyBean.getLegalPerson());
        tvRegMoney.setText(companyBean.getRegCapital());
        tvPublishTime.setText(companyBean.getCompanyCreatetime());
        if (!TextUtils.isEmpty(companyBean.getLastUpdateTime())){
            tvUpdateTime.setText("更新：" + companyBean.getLastUpdateTime());
        }
        tvFollow.setText("关注" + companyBean.getFocus());
        if(!TextUtils.isEmpty(companyBean.getBrowseCount())){
            tvLl.setText("浏览："+companyBean.getBrowseCount());
        }
        tvPhone.setText(companyBean.getCompanyPhoneNo());
        cvEmail.setDesText(companyBean.getEmail());
        cvWz.setDesText(companyBean.getUrl());
        cvAddress.setDesText(companyBean.getAddress());
        if(!TextUtils.isEmpty(companyBean.getSts())){
            if(companyBean.getSts().equals("1")){//已经关注
                isatt=true;
                ivAtten.setImageResource(R.mipmap.guanzhu);

            }else {
                isatt=false;
                ivAtten.setImageResource(R.mipmap.gsxxguanzhu);
            }

        }

        String[] basic_des = {"", "共"+companyBean.getAbroadInvestmentNum() + "条", companyBean.getAnnualPortsMsgNum() + "", "", "", ""};
        basicAdp = new CompanyAdapter(this, basic_images, basic_titles, basic_des);
        gvBasic.setAdapter(basicAdp);

         String[] risk_des = {companyBean.getCourtAnnouncementNum()+"", companyBean.getBreakExecutiveNum()+"", "", companyBean.getCourtDecisionNum()+"",
                 companyBean.getLawsuitMsgNum()+"", companyBean.getAdministrativePenaltyNum()+"", companyBean.getManageExceptionNum()+"", ""};
        riskAdp = new CompanyAdapter(this, risk_images, risk_titles, risk_des);
        gvRisk.setAdapter(riskAdp);

        /*知识产权*/
        String[] knowledge_des = {companyBean.getPatenInfomationNum()+"", companyBean.getTrademarkNum()+"",companyBean.getCopyrightsNum()+"",companyBean.getCertificateNum()+""};
        knowledgeAdp = new CompanyAdapter(this, knowledge_images, knowledge_titles, knowledge_des);
        gvKnowledge.setAdapter(knowledgeAdp);
        /*购物信息*/
        String[] property_des = {"",companyBean.getEquityPledgedNum()+"",companyBean.getTaxInfoNum()+"",companyBean.getFinancingInfoNum()+""};
        propertyAdp = new CompanyAdapter(this, property_images, property_titles, property_des);
        gvProperty.setAdapter(propertyAdp);

        /*企业多纬*/
         String[] company_des = {companyBean.getRecruitingNum()+"",companyBean.getEnterpriseNewsNum()+"",companyBean.getEnterpriseWebMsgNum()+"",
                 companyBean.getProductInfoNum()+"", "",companyBean.getClearInfoNum()+""};
        companyAdp = new CompanyAdapter(this, company_images, company_titles, company_des);
        gvCompany.setAdapter(companyAdp);

        mSizeTagAdapter = new TagAdapter<>(CompanyAct.this);//流逝布局
        size_flow_layout.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_NONE);//设置是不选
        size_flow_layout.setAdapter(mSizeTagAdapter);

        List<String> sdatasource = new ArrayList<>();
        sdatasource.add("续存");
        sdatasource.add("股份有限公司");
        mSizeTagAdapter.onlyAddAll(sdatasource);

        new Thread(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }).start();
    }

    @Override
    public void requestError(int status, String errorMsg) {
        toast(errorMsg);
    }

    @Override
    public void addInsertAtt() {
        isatt=true;
        ivAtten.setImageResource(R.mipmap.guanzhu);
        mPresenter.getCompanyDetail(companyId);

    }

    @Override
    public void removeAtt() {
        isatt=false;
        ivAtten.setImageResource(R.mipmap.gsxxguanzhu);
        mPresenter.getCompanyDetail(companyId);
    }




}
