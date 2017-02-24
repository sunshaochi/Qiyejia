package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.widget.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by bitch-1 on 2017/2/24.
 */
public class PinrunAct extends BaseAct {
    @BindView(R.id.gv_yx)
    MyGridView gv_yx;
    private MyGridAdapter adapter;//印象适配器
//    private List<String>list=new ArrayList<>();
    @Override
    public int getLayout() {
        return R.layout.act_dianpin;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("发表评论");
        adapter=new MyGridAdapter();
        gv_yx.setAdapter(adapter);

    }

    /**
     * 印象适配器
     */
    private class MyGridAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 8;
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
            view=View.inflate(PinrunAct.this,R.layout.gv_item,null);
            return view;
        }
    }
}
