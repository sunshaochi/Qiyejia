package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;

/**
 * 查企业适配器
 * Created by wangbin on 16/12/26.
 */
public class HomeComAdapter extends BaseAdapter{
    private Context context;
    private int [] images={R.mipmap.qymc,R.mipmap.gdgg,R.mipmap.jyfw,R.mipmap.ppcp};
    private String [] titles={"企业名称","股东高管","经营范围","品牌产品"};

    public HomeComAdapter(Context context){
        this.context=context;

    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=View.inflate(context, R.layout.gv_home_item,null);
        ImageView iv= (ImageView) convertView.findViewById(R.id.ivHome);
        TextView tv= (TextView) convertView.findViewById(R.id.tv);
        iv.setImageResource(images[position]);
        tv.setText(titles[position]);
        return convertView;
    }
}
