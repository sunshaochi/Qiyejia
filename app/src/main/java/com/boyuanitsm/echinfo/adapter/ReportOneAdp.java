package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.bean.WebsiteBean;

import java.util.List;

/**
 * 年报信息"企业基本信息", "网站或网店信息"适配器  上黑文字，下灰文字
 * Created by Yang on 2017/1/6 0006.
 */
public class ReportOneAdp extends BaseAdapter {
    private LayoutInflater inflater;
    private List<WebsiteBean> webs;

    public ReportOneAdp(Context context,List<WebsiteBean> webs) {
        inflater = LayoutInflater.from(context);
        this.webs=webs;
    }

    @Override
    public int getCount() {
        return webs.size();
    }

    @Override
    public Object getItem(int i) {
        return webs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.mlv_reportone_item,null);
            holder.tv_title = (TextView) view.findViewById(R.id.tv_title);
            holder.tv_name = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_title.setText(webs.get(i).getWebAddress());
        holder.tv_name.setText(webs.get(i).getWebName());
        return view;
    }
    private class ViewHolder{
        TextView tv_title,tv_name;
    }
}
