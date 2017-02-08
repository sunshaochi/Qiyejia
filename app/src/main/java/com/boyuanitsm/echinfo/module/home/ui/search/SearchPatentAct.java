package com.boyuanitsm.echinfo.module.home.ui.search;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.ISearchPatentPresenter;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.SearchPatentPresenterImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchPatentView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.view.FullyLinearLayoutManager;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 查专利
 * Q164454216
 * Created by xiaoke on 2016/12/29.
 */

public class SearchPatentAct extends BaseAct<ISearchPatentPresenter> implements ISearchPatentView,View.OnClickListener {
    private XRecyclerView rcv, rm, recent;
    private BaseRecyclerAdapter<String> myAdapter;//推荐阅读适配器
    private List<String> datas = new ArrayList<>();
    private PopupWindow mPopupWindow;
    private String[] strSx = {"类型不限", "发明公布", "发明授权", "外观设计", "实用新型"};
    private RelativeLayout rl_sj;
    private RelativeLayout rl_lx;
    private LinearLayout ll_sx;
    private EditText query;
    String name;//搜索名字
    String patentType;//专利类型
    String releaseDate;//年份
    int page=1;
    int rows=10;

    @Override
    public int getLayout() {
        return R.layout.search_patent;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        mPresenter=new SearchPatentPresenterImpl(this);
        datas = EchinfoUtils.getTestDatas(4);
        rcv = (XRecyclerView) findViewById(R.id.rcv);
        rl_sj = (RelativeLayout) findViewById(R.id.rl_sj);
        rl_lx = (RelativeLayout) findViewById(R.id.rl_lx);
        ll_sx = (LinearLayout) findViewById(R.id.ll_sx);
        rm = (XRecyclerView) findViewById(R.id.rm);
        recent = (XRecyclerView) findViewById(R.id.xr);
        query= (EditText) findViewById(R.id.query);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), false);
        query.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString().trim())){
                    name=s.toString().trim();
                    mPresenter.findPatentInfo(name,patentType,releaseDate,page,rows);
                }
            }
        });
        initData();
        inithotReSou();
        initRecentSearch();
    }

    /**
     * 填充最近搜索内容
     */
    private void initRecentSearch() {
        myAdapter= new BaseRecyclerAdapter<String>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_rm_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recent.setLayoutManager(linearLayoutManager);
        recent.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    /**
     * 热门搜索数据填充
     */

    private void inithotReSou() {
        myAdapter= new BaseRecyclerAdapter<String>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_rm_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rm.setLayoutManager(linearLayoutManager);
        rm.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    /**
     * 填充数据
     */
    private void initData() {
        query.setHint("请输入专利号，专利名，公司名");
        myAdapter = new BaseRecyclerAdapter<String>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_search_patent;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        rl_sj.setOnClickListener(this);
        rl_lx.setOnClickListener(this);
        rcv.setAdapter(myAdapter);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_sj:
                break;
            case R.id.rl_lx:
                selectPop();
                break;
        }
    }

    @Override
    public void findPatentInfoSucess(String sucessMsg) {

    }

    @Override
    public void findPatentInfoFaild(int status, String errorMsg) {

    }

    @Override
    public void getPatentTypeSucess(String suceessMsg) {

    }

    @Override
    public void getPatentTypeFaild(int status, String errorMsg) {

    }

    class XzSimpleAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return strSx.length;
        }

        @Override
        public Object getItem(int position) {
            return strSx[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(getApplicationContext(), R.layout.rcv_item_select, null);
            TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            tv_title.setText(strSx[position]);
            return convertView;
        }
    }

    /**
     * 选择对话框
     */
    private void selectPop() {
        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.act_select, null);
        mPopupWindow = new PopupWindow(v, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT);
        ListView lv = (ListView) v.findViewById(R.id.lv);
        lv.setAdapter(new XzSimpleAdapter());
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        int xpos = manager.getDefaultDisplay().getWidth() / 2 - mPopupWindow.getWidth() / 2;
        //xoff,yoff基于anchor的左下角进行偏移。
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        mPopupWindow.setAnimationStyle(R.style.ppAnimBottom);
        mPopupWindow.setFocusable(true);
        mPopupWindow.showAsDropDown(ll_sx, xpos, 0);
    }
}
