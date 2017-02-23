package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.BusinessFourAdp;
import com.boyuanitsm.echinfo.adapter.BusinessOneAdp;
import com.boyuanitsm.echinfo.adapter.BusinessThreeAdp;
import com.boyuanitsm.echinfo.adapter.BusinessTwoAdp;
import com.boyuanitsm.echinfo.adapter.SpotCheckAdapter;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.bean.EditRecordBean;
import com.boyuanitsm.echinfo.bean.MainMemberBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.bean.SonEnterpriseBean;
import com.boyuanitsm.echinfo.bean.SpotCheckBean;
import com.boyuanitsm.echinfo.bean.StockMsgBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.http.manager.CompanyManager;
import com.boyuanitsm.echinfo.widget.MyListView;

import java.util.List;

import butterknife.BindView;

/**
 * 工商信息
 * Created by Yang on 2017/1/5 0005.
 */
public class BusinessInfoAct extends BaseAct {
    @BindView(R.id.elv_businessInfo)
    ExpandableListView elv_businessInfo;

    private String[] groupName = {"登记信息", "股东信息", "主要成员", "变更记录", "分支机构", "抽查检查", "动产抵押"};
    private BusinessOneAdp oneAdp;//股东信息
    private BusinessTwoAdp twoAdp;//主要成员适配器
    private BusinessThreeAdp threeAdp;//变更记录适配器
    private BusinessFourAdp fourAdp;//分支机构适配器

    private CompanyBean companyBean;//登记信息
    private List<StockMsgBean> stockMsgBeans;//股东信息
    private List<MainMemberBean> mainMembers;//主要成员
    private List<EditRecordBean> records;//变更纪录
    private List<SonEnterpriseBean> sonEnterprises;//分支机构
    private List<SpotCheckBean> spotCheckS;//抽查检查


    private String companyId;

    @Override
    public int getLayout() {
        return R.layout.act_businessinfo;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("工商信息");
        setRightBtn("纠错", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ErrorCorrectionAct.class);
            }
        });

        companyId = getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        getCompanyInfo(companyId);


    }

    private class mBaseAdp extends BaseExpandableListAdapter {

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
                view = View.inflate(getApplicationContext(), R.layout.rlv_business_group_item, null);
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

            switch (i) {
                case 0://登记信息
                    if (companyBean != null) {
                        holder.iv_groupArrow.setVisibility(View.VISIBLE);
                        holder.tv_groupRight.setVisibility(View.GONE);
                    } else {
                        holder.iv_groupArrow.setVisibility(View.GONE);
                        holder.tv_groupRight.setVisibility(View.VISIBLE);
                    }
                    break;
                case 1://股东信息
                    if (stockMsgBeans != null & stockMsgBeans.size() > 0) {
                        holder.iv_groupArrow.setVisibility(View.VISIBLE);
                        holder.tv_groupRight.setVisibility(View.GONE);
                    }else {
                        holder.iv_groupArrow.setVisibility(View.GONE);
                        holder.tv_groupRight.setVisibility(View.VISIBLE);
                    }
                    break;
                case 2://主要成员
                    if (mainMembers != null & mainMembers.size() > 0){
                        holder.iv_groupArrow.setVisibility(View.VISIBLE);
                        holder.tv_groupRight.setVisibility(View.GONE);
                    }else {
                        holder.iv_groupArrow.setVisibility(View.GONE);
                        holder.tv_groupRight.setVisibility(View.VISIBLE);
                    }
                        break;
                case 3://变更纪录
                    if (records != null && records.size() > 0){
                        holder.iv_groupArrow.setVisibility(View.VISIBLE);
                        holder.tv_groupRight.setVisibility(View.GONE);
                    }else {
                        holder.iv_groupArrow.setVisibility(View.GONE);
                        holder.tv_groupRight.setVisibility(View.VISIBLE);
                    }
                        break;
                case 4:

                    break;
            }

            holder.tv_groupName.setText(groupName[i]);
            return view;
        }

        @Override
        public View getChildView(int gPosition, int cPosition, boolean b, View view, ViewGroup viewGroup) {
            cViewHolder1 holder1;
            cViewHolder2 holder2;
            cViewHolder3 holder3;
            cViewHolder4 holder4;
            //登记信息
            if (gPosition == 0) if (companyBean == null) {
                view = View.inflate(getApplicationContext(), R.layout.view_business_four, null);
            } else {
//                    holder1 = new cViewHolder1();
                view = View.inflate(getApplicationContext(), R.layout.view_business_one, null);
                TextView tvPerson = (TextView) view.findViewById(R.id.tvPerson);
                TextView tvMoney = (TextView) view.findViewById(R.id.tvMoney);
                TextView tvCreateDate = (TextView) view.findViewById(R.id.tvCreateDate);
                TextView tvFzDate = (TextView) view.findViewById(R.id.tvFzDate);
                TextView tvType = (TextView) view.findViewById(R.id.tvType);
                TextView tvRegNo = (TextView) view.findViewById(R.id.tvRegNo);
                TextView tvZzNo = (TextView) view.findViewById(R.id.tvZzNo);
                TextView tvXyNo = (TextView) view.findViewById(R.id.tvXyNo);
                TextView tvManagerState = (TextView) view.findViewById(R.id.tvManagerState);
                TextView tvEnglishName = (TextView) view.findViewById(R.id.tvEnglishName);
                TextView tvOtherName = (TextView) view.findViewById(R.id.tvOtherName);
                TextView tvHy = (TextView) view.findViewById(R.id.tvHy);

                TextView tvManagerFw = (TextView) view.findViewById(R.id.tvManagerFw);
                TextView tvAddress = (TextView) view.findViewById(R.id.tvAddress);
                TextView tvYyDate = (TextView) view.findViewById(R.id.tvYyDate);
                TextView tvFzDate2 = (TextView) view.findViewById(R.id.tvFzDate2);
                TextView tvDjDate = (TextView) view.findViewById(R.id.tvDjDate);


                tvPerson.setText(companyBean.getLegalPerson());
                tvMoney.setText(companyBean.getCapital());
                tvCreateDate.setText(companyBean.getEstablishDate());
                tvFzDate.setText(companyBean.getPublishDate());
                tvType.setText(companyBean.getCompanyType());
                tvRegNo.setText(companyBean.getRegistNo());
                tvZzNo.setText(companyBean.getOrganizationCode());
                tvXyNo.setText(companyBean.getCreditCode());
                tvManagerState.setText(companyBean.getManagementStatus());
                tvEnglishName.setText(companyBean.getEnglishName());
                tvOtherName.setText(companyBean.getEverName());
                tvHy.setText(companyBean.getIndustry());
                tvManagerFw.setText(companyBean.getBusinessScope());
                tvAddress.setText(companyBean.getAddress());
                tvYyDate.setText(companyBean.getOpenTime());
                tvFzDate2.setText(companyBean.getPublishDate());
                tvDjDate.setText(companyBean.getRegisterPlace());


            }

            if (gPosition == 1) {//股东信息
                if (stockMsgBeans != null & stockMsgBeans.size() > 0) {
                    holder2 = new cViewHolder2();
                    view = View.inflate(getApplicationContext(), R.layout.view_business_two, null);
                    holder2.myListView = (MyListView) view.findViewById(R.id.mlv);
                    oneAdp = new BusinessOneAdp(BusinessInfoAct.this, stockMsgBeans);
                    holder2.myListView.setAdapter(oneAdp);
                } else {
                    view = View.inflate(getApplicationContext(), R.layout.view_business_four, null);
                }

            }
            if (gPosition == 2) {
                //主要成员
                if (mainMembers != null & mainMembers.size() > 0) {
                    holder2 = new cViewHolder2();
                    view = View.inflate(getApplicationContext(), R.layout.view_business_two, null);
                    holder2.myListView = (MyListView) view.findViewById(R.id.mlv);
                    twoAdp = new BusinessTwoAdp(BusinessInfoAct.this, mainMembers);
                    holder2.myListView.setAdapter(twoAdp);
                } else {
                    view = View.inflate(getApplicationContext(), R.layout.view_business_four, null);
                }

            }

            if (gPosition == 3) {
                //变更纪录
                if (records != null && records.size() > 0) {
                    holder2 = new cViewHolder2();
                    view = View.inflate(getApplicationContext(), R.layout.view_business_two, null);
                    holder2.myListView = (MyListView) view.findViewById(R.id.mlv);
                    BusinessThreeAdp sevenAdp = new BusinessThreeAdp(getApplicationContext(), records);
                    holder2.myListView.setAdapter(sevenAdp);
                } else {
                    view = View.inflate(getApplicationContext(), R.layout.view_business_four, null);

                }
            }

            if (gPosition == 4) {
                //分支机构
                if (sonEnterprises != null && sonEnterprises.size() > 0) {
                    holder2 = new cViewHolder2();
                    view = View.inflate(BusinessInfoAct.this, R.layout.view_business_two, null);
                    holder2.myListView = (MyListView) view.findViewById(R.id.mlv);
                    fourAdp = new BusinessFourAdp(BusinessInfoAct.this,sonEnterprises);
                    holder2.myListView.setAdapter(fourAdp);
                    holder2.myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Bundle bundle=new Bundle();
                            bundle.putParcelable(BranchDetailAct.BRANCH_DETAIL,sonEnterprises.get(i));
                            openActivity(BranchDetailAct.class,bundle);
                        }
                    });
                } else {
                    view = View.inflate(getApplicationContext(), R.layout.view_business_four, null);

                }

            }


            if (gPosition == 5) {//抽查检查
                if(spotCheckS!=null&&spotCheckS.size()>0){
                    holder2 = new cViewHolder2();
                    view = View.inflate(BusinessInfoAct.this, R.layout.view_business_two, null);
                    holder2.myListView = (MyListView) view.findViewById(R.id.mlv);
                    holder2.myListView.setAdapter(new SpotCheckAdapter(BusinessInfoAct.this,spotCheckS));
                }else {
                    view = View.inflate(getApplicationContext(), R.layout.view_business_four, null);
                }

            }

            if (gPosition == 6) {//动产抵押
                holder4 = new cViewHolder4();
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

        public class cViewHolder1 {

        }

        public class cViewHolder2 {
            MyListView myListView;
        }

        public class cViewHolder3 {

        }

        public class cViewHolder4 {

        }
    }


    /**
     * 获取企业信息
     *
     * @param companyId
     */
    private void getCompanyInfo(final String companyId) {
        CompanyManager.getCompanyManager().toFindCompanyNo(companyId, new ResultCallback<ResultBean<CompanyBean>>() {
            @Override
            public void onError(int status, String errorMsg) {
            }

            @Override
            public void onResponse(ResultBean<CompanyBean> response) {
                companyBean = response.getData();
               toGetStockMsg(companyId);
            }
        });
    }

    /**
     * 股东信息
     *
     * @param companyId
     */
    private void toGetStockMsg(final String companyId) {
        CompanyManager.getCompanyManager().toFindStockMsg(companyId, new ResultCallback<ResultBean<List<StockMsgBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {

            }

            @Override
            public void onResponse(ResultBean<List<StockMsgBean>> response) {
                stockMsgBeans = response.getData();
                toFindMainMember(companyId);
            }
        });
    }

    /**
     * 主要成员
     *
     * @param companyId
     */
    private void toFindMainMember(final String companyId) {
        CompanyManager.getCompanyManager().toFindMainMember(companyId, new ResultCallback<ResultBean<List<MainMemberBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {

            }

            @Override
            public void onResponse(ResultBean<List<MainMemberBean>> response) {
                mainMembers = response.getData();
                getEditRecord(companyId);
            }
        });
    }


    /**
     * 查询企业变更记录
     *
     * @param companyId
     */
    private void getEditRecord(final String companyId) {
        CompanyManager.getCompanyManager().getCompanyEditRecord(companyId, "", new ResultCallback<ResultBean<List<EditRecordBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {

            }

            @Override
            public void onResponse(ResultBean<List<EditRecordBean>> response) {
                records = response.getData();
                toFindSonEnterprise(companyId);
            }
        });

    }

    /**
     * 查询分支机构
     *
     * @param companyId
     */
    private void toFindSonEnterprise(final String companyId) {
        CompanyManager.getCompanyManager().toFindSonEnterprise(companyId, new ResultCallback<ResultBean<List<SonEnterpriseBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {

            }

            @Override
            public void onResponse(ResultBean<List<SonEnterpriseBean>> response) {
                sonEnterprises = response.getData();
                toFindSpotCheckList(companyId);
            }
        });
    }

    /**
     * 抽查检查
     * @param companyId
     */
    private void toFindSpotCheckList(String companyId) {
        CompanyManager.getCompanyManager().toFindSonEnterprise(companyId, new ResultCallback<ResultBean<List<SpotCheckBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {

            }

            @Override
            public void onResponse(ResultBean<List<SpotCheckBean>> response) {
                spotCheckS=response.getData();
                elv_businessInfo.setAdapter(new mBaseAdp());
            }
        });
    }


}
