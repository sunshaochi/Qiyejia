package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;

import java.util.List;

/**
 * Created by bitch-1 on 2017/2/10.
 */
public class CityAdapter extends BaseAdapter {
    private Context context;
    private List<String> datas;

    public CityAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas=datas;
    }

    public void setDatas( List<String> datas) {
        this.datas=datas;
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
            view = View.inflate(context, R.layout.item_city, null);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) view.findViewById(R.id.tvName);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tvName.setText(datas.get(i));
        return view;
    }

    class ViewHolder {
        TextView tvName;
    }
}
