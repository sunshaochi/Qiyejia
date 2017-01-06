package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;

/**
 * 工商信息界面分支机构适配器
 * Created by Yang on 2017/1/6 0006.
 */
public class BusinessFourAdp extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;

    public BusinessFourAdp(Context context) {
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
            view = inflater.inflate(R.layout.mlv_businessfour_item, null);
            holder.tv_companyName = (TextView) view.findViewById(R.id.tv_companyName);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        return view;
    }

    private class ViewHolder {
        TextView tv_companyName;
    }
}
