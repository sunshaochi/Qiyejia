package com.boyuanitsm.echinfo.module.home.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.PopupWindow;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 查专利
 * Q164454216
 * Created by xiaoke on 2016/12/29.
 */

public class SearchPatentAct extends BaseAct {
    private XRecyclerView rcv, rcvpp;
    private BaseRecyclerAdapter<String> myAdapter;//推荐阅读适配器
    private List<String> datas = new ArrayList<>();
    private PopupWindow mPopupWindow;
    private String[] strSx = {"类型不限", "发明公布", "发明授权", "外观设计", "实用新型"};

    @Override
    public int getLayout() {
        return R.layout.search_patent;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        datas = EchinfoUtils.getTestDatas(4);
        rcv = (XRecyclerView) findViewById(R.id.rcv);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), false);
        initData();
    }

    /**
     * 填充数据
     */
    private void initData() {
        myAdapter = new BaseRecyclerAdapter<String>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_search_patent;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        rcv.setAdapter(myAdapter);
    }

    /**
     * 待解决：对话框布局有出入
     * 选择对话框，选择好友/全部
     *
     * @param cusPos
     */
    private void selectPop(int cusPos) {

        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.act_select, null);
        mPopupWindow = new PopupWindow(v, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT);
        rcvpp = (XRecyclerView) v.findViewById(R.id.rcv);
        rcvpp = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), false);
        myAdapter = new BaseRecyclerAdapter<String>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_item_select;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        rcvpp.setAdapter(myAdapter);
    }
}
