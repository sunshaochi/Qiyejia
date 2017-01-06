package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;

/**
 * 工商信息界面投资人适配器
 * Created by Yang on 2017/1/6 0006.
 */
public class BusinessOneAdp extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;

    public BusinessOneAdp(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 3;
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
            view = inflater.inflate(R.layout.mlv_businessone_item, null);
            holder.tv_companyName = (TextView) view.findViewById(R.id.tv_companyName);
            holder.tv_professional = (TextView) view.findViewById(R.id.tv_professional);
            holder.iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if (i == 1) {
            holder.iv_icon.setBackgroundResource(R.mipmap.business_add_icon);
        } else {
            holder.iv_icon.setBackgroundResource(R.mipmap.business_jian_icon);
        }
        return view;
    }

    private class ViewHolder {
        TextView tv_companyName;
        TextView tv_professional;
        ImageView iv_icon;
    }
}
