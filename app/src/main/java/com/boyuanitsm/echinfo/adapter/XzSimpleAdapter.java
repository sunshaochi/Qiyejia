package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.bean.PatentTypeBean;

import java.util.List;

/**
 * Q164454216
 * Created by xiaoke on 2017/2/9.
 */

public class XzSimpleAdapter extends BaseAdapter {
    private List<PatentTypeBean> typeBeanList;
    private int clickTemp = 0;
    private Context context;
    public XzSimpleAdapter(Context context,List<PatentTypeBean> typeBean, int click) {
        this.context=context;
        this.typeBeanList = typeBean;
        this.clickTemp = click;
    }

    @Override
    public int getCount() {
        return typeBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return typeBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.rcv_item_select, null);
        TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
        RelativeLayout rl_lx = (RelativeLayout) convertView.findViewById(R.id.rl_lx);
        ImageView iv_right = (ImageView) convertView.findViewById(R.id.iv_right);
        tv_title.setText(typeBeanList.get(position).getDictName());
        if (clickTemp == position) {
            rl_lx.setBackgroundColor(Color.WHITE);
            iv_right.setVisibility(View.VISIBLE);
        } else {
            rl_lx.setBackgroundColor(context.getResources().getColor(R.color.bg_grey_color));
            iv_right.setVisibility(View.GONE);
        }
        return convertView;
    }
}
