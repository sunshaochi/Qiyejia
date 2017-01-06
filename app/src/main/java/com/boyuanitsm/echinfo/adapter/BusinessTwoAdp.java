package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.tools.view.CircleImageView;

/**
 * 工商信息界面主要成员适配器
 * Created by Yang on 2017/1/6 0006.
 */
public class BusinessTwoAdp extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;

    public BusinessTwoAdp(Context context) {
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
            view = inflater.inflate(R.layout.mlv_businesstwo_item, null);
            holder.tv_name = (TextView) view.findViewById(R.id.tv_companyName);
            holder.tv_professional = (TextView) view.findViewById(R.id.tv_professional);
            holder.iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
            holder.civ_head = (CircleImageView) view.findViewById(R.id.civ_head);
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
        TextView tv_name;
        TextView tv_professional;
        ImageView iv_icon;
        CircleImageView civ_head;
    }
}
