package com.boyuanitsm.echinfo.module.company.ui;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;

import butterknife.BindView;

/**
 * 工商信息
 * Created by Yang on 2017/1/5 0005.
 */
public class BusinessInfoAct extends BaseAct {
    @BindView(R.id.elv_businessInfo)
    ExpandableListView elv_businessInfo;

    private String [] groupName = {"登记信息","投资人","主要成员","变更记录","分支机构","抽查检查","动产抵押"};

    @Override
    public int getLayout() {
        return R.layout.act_businessinfo;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("工商信息");
        elv_businessInfo.setAdapter(new MyAdp());
    }

    private class MyAdp implements ExpandableListAdapter {

        @Override
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

        }

        @Override
        public int getGroupCount() {
            return groupName.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return 0;
        }

        @Override
        public Object getGroup(int i) {
            return null;
        }

        @Override
        public Object getChild(int i, int i1) {
            return null;
        }

        @Override
        public long getGroupId(int i) {
            return 0;
        }

        @Override
        public long getChildId(int i, int i1) {
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
                holder.iv_groupArrow.setImageResource(R.mipmap.arrow_down);
            } else {
                holder.iv_groupArrow.setImageResource(R.mipmap.arrow_up);
            }
            holder.tv_groupName.setText(groupName[i]);
            return view;
        }

        @Override
        public View getChildView(int parentPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
            return null;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public void onGroupExpanded(int i) {

        }

        @Override
        public void onGroupCollapsed(int i) {

        }

        @Override
        public long getCombinedChildId(long l, long l1) {
            return 0;
        }

        @Override
        public long getCombinedGroupId(long l) {
            return 0;
        }

        public class gViewHolder {
            TextView tv_groupName;
            ImageView iv_groupArrow;
        }
    }
}
