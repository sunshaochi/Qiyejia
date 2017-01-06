package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.widget.MyListView;

/**
 * 工商信息界面变更记录适配器
 * Created by Yang on 2017/1/6 0006.
 */
public class BusinessThreeAdp extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private BusinessThreeItemAdp itemAdp;

    public BusinessThreeAdp(Context context) {
        inflater = LayoutInflater.from(context);
        this.context = context;
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
            view = inflater.inflate(R.layout.mlv_businessthree_item, null);
            holder.view_line = view.findViewById(R.id.view_line);
            holder.mlv = (MyListView) view.findViewById(R.id.mlv);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if (i == 0) {
            holder.view_line.setVisibility(View.GONE);
        } else {
            holder.view_line.setVisibility(View.VISIBLE);
        }
        itemAdp = new BusinessThreeItemAdp(context, i);
        holder.mlv.setSelector(new ColorDrawable(Color.TRANSPARENT));
        holder.mlv.setAdapter(itemAdp);
        return view;
    }

    private class ViewHolder {
        View view_line;
        MyListView mlv;
    }
}
