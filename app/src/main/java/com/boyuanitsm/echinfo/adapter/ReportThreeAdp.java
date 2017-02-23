package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.bean.CompanyBean;

import java.util.List;

/**
 * 年报信息对外投资信息适配器
 * Created by Yang on 2017/1/6 0006.
 */
public class ReportThreeAdp extends BaseAdapter {
    private LayoutInflater inflater;
    private List<CompanyBean> datas;

    public ReportThreeAdp(Context context,List<CompanyBean> datas) {
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
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.mlv_reportthree_item,null);
            holder.tvCompanyName= (TextView) view.findViewById(R.id.tvCompanyName);
            holder.tvName= (TextView) view.findViewById(R.id.tvName);
            holder.tvState= (TextView) view.findViewById(R.id.tvState);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tvCompanyName.setText(datas.get(i).getCompanyName());
        holder.tvName.setText(datas.get(i).getLegalPerson());
        holder.tvState.setText(datas.get(i).getManagementStatus());
        return view;
    }
    private class ViewHolder{
      TextView tvCompanyName,tvName,tvState;
    }
}
