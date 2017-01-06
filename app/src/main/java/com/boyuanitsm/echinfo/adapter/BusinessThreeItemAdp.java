package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;

/**
 * 工商信息界面变更记录item适配器
 * Created by Yang on 2017/1/6 0006.
 */
public class BusinessThreeItemAdp extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int test;

    public BusinessThreeItemAdp(Context context, int test) {
        inflater = LayoutInflater.from(context);
        this.test = test;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.mlv_businessthreeitem_item, null);
            holder.tv_changeTitle = (TextView) view.findViewById(R.id.tv_changeTitle);
            holder.tv_changeBefore = (TextView) view.findViewById(R.id.tv_changeBefore);
            holder.tv_changeAfter = (TextView) view.findViewById(R.id.tv_changeAfter);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if (test == 0) {
            holder.tv_changeTitle.setText("监视变更");
            holder.tv_changeBefore.setText("监视变更");
            holder.tv_changeAfter.setText("监视变更");
        } else {
            holder.tv_changeTitle.setText("法定代表人变更");
            holder.tv_changeBefore.setText("法定代表人变更");
            holder.tv_changeAfter.setText("法定代表人变更");
        }
        return view;
    }

    private class ViewHolder {
        TextView tv_changeTitle, tv_changeBefore, tv_changeAfter;
    }
}
