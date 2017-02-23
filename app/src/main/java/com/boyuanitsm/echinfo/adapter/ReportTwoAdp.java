package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.bean.StockMsgBean;

import java.util.List;

/**
 * 年报信息股东信息适配器
 * Created by Yang on 2017/1/6 0006.
 */
public class ReportTwoAdp extends BaseAdapter {
    private LayoutInflater inflater;

    private List<StockMsgBean> datas;

    public ReportTwoAdp(Context context,List<StockMsgBean> datas) {
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
            view = inflater.inflate(R.layout.mlv_reporttwo_item,null);
            holder.tvName= (TextView) view.findViewById(R.id.tvName);
            holder.tvCzTime= (TextView) view.findViewById(R.id.tvCzTime);
            holder.tvCzMoney= (TextView) view.findViewById(R.id.tvCzMoney);
            holder.tvSjTime= (TextView) view.findViewById(R.id.tvSjTime);
            holder.tvSjMoney= (TextView) view.findViewById(R.id.tvSjMoney);
            holder.tvType= (TextView) view.findViewById(R.id.tvType);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tvName.setText(datas.get(i).getName());
        holder.tvCzTime.setText(datas.get(i).getRealSubcribeTime());
        holder.tvCzMoney.setText(datas.get(i).getSubcribe());
        holder.tvSjTime.setText(datas.get(i).getRealSubcribeTime());
        holder.tvSjMoney.setText(datas.get(i).getRealSubcribe());
        holder.tvType.setText(datas.get(i).getRealSubcribeType());
        return view;
    }
    private class ViewHolder{
        TextView tvName,tvCzTime,tvCzMoney,tvSjTime,tvSjMoney,tvType;
    }
}
