package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.BusinessThreeAdp;
import com.boyuanitsm.echinfo.adapter.ReportFourAdp;
import com.boyuanitsm.echinfo.adapter.ReportOneAdp;
import com.boyuanitsm.echinfo.adapter.ReportThreeAdp;
import com.boyuanitsm.echinfo.adapter.ReportTwoAdp;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.bean.EditRecordBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.bean.YearReportBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;
import com.boyuanitsm.echinfo.widget.MyListView;

import java.util.List;

import butterknife.BindView;

/**
 * 年报信息界面
 * Created by Yang on 2017/1/6 0006.
 */
public class ReportInfoAct extends BaseAct {
    @BindView(R.id.elv_businessInfo)
    ExpandableListView elv_businessInfo;

    private String[] groupName = {"企业基本信息", "网站或网店信息", "股东信息", "对外投资信息",
            "企业资产状况信息", "对外提供保证担保信息", "股权变更信息", "变更记录"};

    private ReportOneAdp oneAdp;
    private ReportTwoAdp twoAdp;
    private ReportThreeAdp threeAdp;
    private ReportFourAdp fourAdp;
    private BusinessThreeAdp sevenAdp;

    public static final String YEAR_REPORTINFO="reportInfo";
    private YearReportBean yearReportBean;

    private CompanyBean companyBean;//公司信息
    private  List<EditRecordBean> records;

    @Override
    public int getLayout() {
        return R.layout.act_reportinfo;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("年报信息");
        setRightBtn("纠错", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ErrorCorrectionAct.class);
            }
        });
        yearReportBean=getIntent().getParcelableExtra(YEAR_REPORTINFO);
        getCompanyInfo(yearReportBean.getId());


    }

    private class MBaseAdp extends BaseExpandableListAdapter {


        @Override
        public int getGroupCount() {
            return groupName.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return 1;
        }

        @Override
        public Object getGroup(int i) {
            return null;
        }

        @Override
        public Object getChild(int gPosition, int cPosition) {
            return null;
        }

        @Override
        public long getGroupId(int i) {
            return 0;
        }

        @Override
        public long getChildId(int gPosition, int cPosition) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            gViewHolder holder;
            if (view == null) {
                holder = new gViewHolder();
                view = View.inflate(getApplicationContext(), R.layout.rlv_reportinfo_group_item, null);
                holder.tv_groupName = (TextView) view.findViewById(R.id.tv_groupName);
                holder.tv_groupRight = (TextView) view.findViewById(R.id.tv_groupRight);
                holder.iv_groupArrow = (ImageView) view.findViewById(R.id.iv_groupArrow);
                view.setTag(holder);
            } else {
                holder = (gViewHolder) view.getTag();
            }
            if (b) {
                holder.iv_groupArrow.setImageResource(R.mipmap.arrow_up);
            } else {
                holder.iv_groupArrow.setImageResource(R.mipmap.arrow_down);
            }
            if (i == 5 || i == 6) {
                holder.iv_groupArrow.setVisibility(View.GONE);
                holder.tv_groupRight.setVisibility(View.VISIBLE);
            } else {
                holder.iv_groupArrow.setVisibility(View.VISIBLE);
                holder.tv_groupRight.setVisibility(View.GONE);
            }
            holder.tv_groupName.setText(groupName[i]);
            return view;
        }

        @Override
        public View getChildView(int gPosition, int cPosition, boolean b, View view, ViewGroup viewGroup) {
            cViewHolder holder;

            if(gPosition==0){
                if (companyBean == null) {
                    view = View.inflate(getApplicationContext(), R.layout.view_business_four, null);
                }else {
                    view = View.inflate(getApplicationContext(), R.layout.view_business_four, null);
                    TextView tvComName = (TextView) view.findViewById(R.id.tvComName);
                    TextView tvRegNo = (TextView) view.findViewById(R.id.tvRegNo);
                    TextView tvCompanyNo = (TextView) view.findViewById(R.id.tvCompanyNo);
                    TextView tvYzNo = (TextView) view.findViewById(R.id.tvYzNo);
                    TextView tvAddress = (TextView) view.findViewById(R.id.tvAddress);
                    TextView tvEmail = (TextView) view.findViewById(R.id.tvEmail);
                    TextView tvIsZr = (TextView) view.findViewById(R.id.tvIsZr);
                    TextView tvIsHasWz = (TextView) view.findViewById(R.id.tvIsHasWz);
                    TextView tvIsHasGq= (TextView) view.findViewById(R.id.tvIsHasGq);
                    TextView tvCyrs= (TextView) view.findViewById(R.id.tvCyrs);

                    tvComName.setText(companyBean.getCompanyName());
                    tvRegNo.setText(companyBean.getRegistNo());
                    tvCompanyNo.setText(companyBean.getCompanyPhoneNo());
                    tvYzNo.setText(companyBean.getPostcode());
                    tvAddress.setText(companyBean.getAddress());
                    tvEmail.setText(companyBean.getEmail());
                    if("0".equals(companyBean.getStockTransfer())){
                        tvIsZr.setText("否");
                    }else if("1".equals(companyBean.getStockTransfer())){
                        tvIsZr.setText("是");
                    }

                    if("0".equals(companyBean.getIsHaveWeb())){
                        tvIsHasWz.setText("否");
                    }else if("1".equals(companyBean.getIsHaveWeb())){
                        tvIsHasWz.setText("是");
                    }

                    if("0".equals(companyBean.getCompanyInverstment())){
                        tvIsHasGq.setText("否");
                    }else if("1".equals(companyBean.getCompanyInverstment())){
                        tvIsHasGq.setText("是");
                    }
                    if(TextUtils.isEmpty(companyBean.getEmployeeCount())){
                        tvCyrs.setText("无");
                    }else {
                        tvCyrs.setText(companyBean.getEmployeeCount()+"");
                    }
                }
            }

            if ( gPosition == 1 || gPosition == 2 || gPosition == 3
                    || gPosition == 4 || gPosition == 7) {
                holder = new cViewHolder();
                view = View.inflate(getApplicationContext(), R.layout.view_business_two, null);
                holder.myListView = (MyListView) view.findViewById(R.id.mlv);
                //企业基本信息
//                    oneAdp = new ReportOneAdp(getApplicationContext());
//                    holder.myListView.setAdapter(oneAdp);

                if (gPosition == 1) {//网站或网店信息
                    oneAdp = new ReportOneAdp(getApplicationContext());
                    holder.myListView.setAdapter(oneAdp);
                }
                if (gPosition == 2) {//股东信息
                    twoAdp = new ReportTwoAdp(getApplicationContext());
                    holder.myListView.setAdapter(twoAdp);
                }
                if (gPosition == 3) {//对外投资信息
                    threeAdp = new ReportThreeAdp(getApplicationContext());
                    holder.myListView.setAdapter(threeAdp);
                }
                if (gPosition == 4) {//企业资产状况信息
                    fourAdp = new ReportFourAdp(getApplicationContext());
                    holder.myListView.setAdapter(fourAdp);
                }
                if (gPosition == 7) {//变更记录
                    if(records!=null&&records.size()>0){
                        sevenAdp = new BusinessThreeAdp(getApplicationContext(),records);
                        holder.myListView.setAdapter(sevenAdp);
                    }else {
                        view = View.inflate(getApplicationContext(), R.layout.view_business_four, null);

                    }

                }
            }

            if (gPosition == 5) {//对外提供保证担保信息
                view = View.inflate(getApplicationContext(), R.layout.view_business_four, null);
            }

            if (gPosition == 6) {//股权变更信息
                view = View.inflate(getApplicationContext(), R.layout.view_business_four, null);
            }
            return view;
        }

        @Override
        public boolean isChildSelectable(int gPosition, int cPosition) {
            return false;
        }

        public class gViewHolder {
            TextView tv_groupName, tv_groupRight;
            ImageView iv_groupArrow;
        }

        public class cViewHolder {
            MyListView myListView;
        }

    }

    /**
     * 获取企业信息
     * @param companyId
     */
    private void getCompanyInfo(String companyId){
        CompanyManager.getCompanyManager().toGetCompanyDetail(companyId, new ResultCallback<ResultBean<CompanyBean>>() {
            @Override
            public void onError(int status, String errorMsg) {

            }

            @Override
            public void onResponse(ResultBean<CompanyBean> response) {
                companyBean=response.getData();
                elv_businessInfo.setAdapter(new MBaseAdp());
                getEditRecord(yearReportBean.getId(),yearReportBean.getYear());

            }
        });

    }

    /**
     * 查询企业变更记录
     * @param companyId
     * @param year
     */
    private void getEditRecord(String companyId,String year){
        CompanyManager.getCompanyManager().getCompanyEditRecord(companyId, year, new ResultCallback<ResultBean<List<EditRecordBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {

            }

            @Override
            public void onResponse(ResultBean<List<EditRecordBean>> response) {
                records=response.getData();

            }
        });
    }

}
