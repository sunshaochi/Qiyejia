package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.bean.StockMsgBean;

import java.util.List;

/**
 * 工商信息界股东信息适配器
 * Created by Yang on 2017/1/6 0006.
 */
public class BusinessOneAdp extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<StockMsgBean> datas;

    public BusinessOneAdp(Context context,List<StockMsgBean> datas) {
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
        holder.tv_companyName.setText(datas.get(i).getCompanyName());
        holder.tv_professional.setText(datas.get(i).getStockType());
//        if (i == 1) {
//            holder.iv_icon.setBackgroundResource(R.mipmap.business_add_icon);
//        } else {
//            holder.iv_icon.setBackgroundResource(R.mipmap.business_jian_icon);
//        }
        return view;
    }

    private class ViewHolder {
        TextView tv_companyName;
        TextView tv_professional;
        ImageView iv_icon;
    }
}
