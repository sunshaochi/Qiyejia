package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.bean.SonEnterpriseBean;

import java.util.List;

/**
 * 工商信息界面分支机构适配器
 * Created by Yang on 2017/1/6 0006.
 */
public class BusinessFourAdp extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<SonEnterpriseBean> datas;

    public BusinessFourAdp(Context context,List<SonEnterpriseBean> datas) {
        inflater = LayoutInflater.from(context);
        this.datas=datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
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
        holder.tv_companyName.setText(datas.get(i).getCompanyName());
        return view;
    }

    private class ViewHolder {
        TextView tv_companyName;
    }
}
