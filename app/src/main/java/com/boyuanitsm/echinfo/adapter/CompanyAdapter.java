package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;

/**
 * 公司信息适配器
 * Created by wangbin on 17/1/4.
 */
public class CompanyAdapter extends BaseAdapter {
    private Context context;
    private int[] iamges;
    private String[] titles;
    private String[] des;

    public CompanyAdapter(Context context,int[] iamges,String[] titles,String[] des){
        this.context=context;
        this.iamges=iamges;
        this.titles=titles;
        this.des=des;
    }
    @Override
    public int getCount() {
        return iamges.length;
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.gv_company_item,null);
            viewHolder=new ViewHolder();

            viewHolder.ivCompany= (ImageView) convertView.findViewById(R.id.ivCompany);
            viewHolder.tvName= (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tvDes= (TextView) convertView.findViewById(R.id.tvDes);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.ivCompany.setImageResource(iamges[position]);
        viewHolder.tvName.setText(titles[position]);
        viewHolder.tvDes.setText(des[position]);
        return convertView;
    }

    class ViewHolder {
        ImageView ivCompany;
        TextView tvName;
        TextView tvDes;
    }
}
