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
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.widget.MyListView;

import butterknife.BindView;

/**
 * 工商信息
 * Created by Yang on 2017/1/5 0005.
 */
public class BusinessInfoAct extends BaseAct {
    @BindView(R.id.elv_businessInfo)
    ExpandableListView elv_businessInfo;

    private String[] groupName = {"登记信息", "投资人", "主要成员", "变更记录", "分支机构", "抽查检查", "动产抵押"};
    private BusinessOneAdp oneAdp;//投资人适配器
    private BusinessTwoAdp twoAdp;//主要成员适配器
    private BusinessThreeAdp threeAdp;//变更记录适配器
    private BusinessFourAdp fourAdp;//分支机构适配器

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
        elv_businessInfo.setAdapter(new mBaseAdp());
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
            holder.tv_groupName.setText(groupName[i]);
            return view;
        }

        @Override
        public View getChildView(int gPosition, int cPosition, boolean b, View view, ViewGroup viewGroup) {
            cViewHolder1 holder1;
            cViewHolder2 holder2;
            cViewHolder3 holder3;
            cViewHolder4 holder4;
            if (gPosition == 0) {//登记信息
                holder1 = new cViewHolder1();
                view = View.inflate(getApplicationContext(), R.layout.view_business_one, null);
            }

            if (gPosition == 1 || gPosition == 2 || gPosition == 3 || gPosition == 4) {
                holder2 = new cViewHolder2();
                view = View.inflate(getApplicationContext(), R.layout.view_business_two, null);
                holder2.myListView = (MyListView) view.findViewById(R.id.mlv);
                if (gPosition == 1) {//投资人
                    oneAdp = new BusinessOneAdp(getApplicationContext());
                    holder2.myListView.setAdapter(oneAdp);
                }
                if (gPosition == 2) {//主要成员
                    twoAdp = new BusinessTwoAdp(getApplicationContext());
                    holder2.myListView.setAdapter(twoAdp);
                }
                if (gPosition == 3) {//变更记录
                    threeAdp = new BusinessThreeAdp(getApplicationContext());
                    holder2.myListView.setAdapter(threeAdp);
                }
                if (gPosition == 4) {//分支机构列表
                    fourAdp = new BusinessFourAdp(getApplicationContext());
                    holder2.myListView.setAdapter(fourAdp);
                    holder2.myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            openActivity(BranchDetailAct.class);
                        }
                    });
                }
            }

            if (gPosition == 5) {//抽查检查
                holder3 = new cViewHolder3();
                view = View.inflate(getApplicationContext(), R.layout.view_business_three, null);
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
            TextView tv_groupName;
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

}
