package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.boyuanitsm.echinfo.R;

/**
 * Created by bitch-1 on 2017/2/7.
 */
public class GvAdapter extends BaseAdapter {
    private Context context;

    public GvAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=View.inflate(context,R.layout.item_zczb,null);
        return view;
    }
}
