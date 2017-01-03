package com.boyuanitsm.echinfo.module.home.ui.search;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;

import butterknife.BindView;

/**
 * 高级查找，注册资金选择
 * Q164454216
 * Created by xiaoke on 2016/12/30.
 */

public class RegisterMoneyAct extends BaseAct {
    @BindView(R.id.lv)
    ListView lv;
    private String[] strtime = {"不限", "50万以下", "50-100万", "100-500万", "1亿"};

    @Override
    public int getLayout() {
        return R.layout.register_time;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("注册资金");
        setRightBtn("确定", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        initData();
    }

    /**
     * 设置资金适配
     */
    private void initData() {
        lv.setAdapter(new TimeAdapter());
    }

    class TimeAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return strtime.length;
        }

        @Override
        public Object getItem(int position) {
            return strtime[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(getApplicationContext(), R.layout.time_select_item, null);
            TextView tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            tv_time.setText(strtime[position]);
            return convertView;
        }
    }
}
