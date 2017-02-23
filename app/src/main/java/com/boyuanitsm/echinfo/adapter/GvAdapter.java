package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;

/**
 * Created by bitch-1 on 2017/2/7.
 */
public class GvAdapter extends BaseAdapter {
    private Context context;
    private int clickTemp = -1;//标识选择的Item
    private String[] strings;

    public GvAdapter(Context context,String[] strings) {
        this.strings=strings;
        this.context = context;
    }

    public void setSeclection(int position) {
        clickTemp = position;
    }

    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public Object getItem(int i) {
        return strings[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TabHolder tabHolder=null;
        if(view==null){
            tabHolder=new TabHolder();
            view=View.inflate(context,R.layout.item_zczb,null);
            tabHolder.tv_bq=(TextView) view.findViewById(R.id.tv_bq);
            view.setTag(tabHolder);
        }else {
            tabHolder= (TabHolder) view.getTag();
        }
        tabHolder.tv_bq.setText(strings[i]);
        if(clickTemp==i){
            tabHolder.tv_bq.setTextColor(Color.parseColor("#2485f2"));
            tabHolder.tv_bq.setBackgroundResource(R.drawable.select_item_bag);
        }else {
            tabHolder.tv_bq.setTextColor(Color.parseColor("#666666"));
            tabHolder.tv_bq.setBackgroundResource(R.drawable.item_bag);
        }

//        if(i==clickTemp){
//            textView.setTextColor();
//            textView.setBackgroundResource(R.drawable.select_item_bag);
//        }else {
//            textView.setTextColor(Color.parseColor("#666666"));
//            textView.setBackgroundResource(R.drawable.item_bag);
//        }
        return view;
    }
    class TabHolder {
        private TextView tv_bq;
    }


}
