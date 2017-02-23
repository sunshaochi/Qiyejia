package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;

import java.util.List;

/**
 * Created by bitch-1 on 2017/2/10.
 */
public class ProAdapter extends BaseAdapter {
    private Context context;

    private List<String> datas;
    private int selectPosition;

    public ProAdapter(Context context, List<String> datas, int selectPosition) {
        this.context = context;
        this.datas=datas;
        this.selectPosition=selectPosition;
    }

    public void setSlectionChange(int selectPosition){
        this.selectPosition=selectPosition;
        notifyDataSetChanged();
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
        ViewHolder viewHolder;
        if (view == null) {
            view = View.inflate(context, R.layout.item_pro, null);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) view.findViewById(R.id.tvName);
            viewHolder.llBg= (LinearLayout) view.findViewById(R.id.llBg);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvName.setText(datas.get(i));
        if(i==selectPosition){
            viewHolder.llBg.setBackgroundColor(Color.parseColor("#ffffff"));
        }else {
            viewHolder.llBg.setBackgroundColor(Color.parseColor("#f6f8f9"));

        }
        return view;
    }

    class ViewHolder {
        TextView tvName;
        LinearLayout llBg;
    }
}
