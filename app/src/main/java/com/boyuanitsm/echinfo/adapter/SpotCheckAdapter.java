package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.bean.SpotCheckBean;

import java.util.List;

/**
 * 抽查检查
 * Created by wangbin on 17/2/23.
 */
public class SpotCheckAdapter extends BaseAdapter{
    private Context context;
    private List<SpotCheckBean> datas;
    public SpotCheckAdapter(Context context,List<SpotCheckBean> datas){
        this.context=context;
        this.datas=datas;
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = View.inflate(context, R.layout.view_business_three, null);
        TextView tvAgency= (TextView) view.findViewById(R.id.tvAgency);
        TextView tvType= (TextView) view.findViewById(R.id.tvType);
        TextView tvDate= (TextView) view.findViewById(R.id.tvDate);
        TextView tvResult= (TextView) view.findViewById(R.id.tvResult);

        tvAgency.setText(datas.get(i).getImplementingAgency());
        tvType.setText(datas.get(i).getType());
        tvDate.setText(datas.get(i).getDate());
        tvResult.setText(datas.get(i).getResult());
        return view;
    }
}
