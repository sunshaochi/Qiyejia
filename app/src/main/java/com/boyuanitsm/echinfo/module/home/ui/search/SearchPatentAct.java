package com.boyuanitsm.echinfo.module.home.ui.search;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.PatentBean;
import com.boyuanitsm.echinfo.bean.PatentTypeBean;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.ISearchPatentPresenter;
import com.boyuanitsm.echinfo.module.home.presenter.searchPresenter.SearchPatentPresenterImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchPatentView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.ClearEditText;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 查专利
 * Q164454216
 * Created by xiaoke on 2016/12/29.
 */

public class SearchPatentAct extends BaseAct<ISearchPatentPresenter> implements ISearchPatentView, View.OnClickListener {
    @BindView(R.id.query)
    ClearEditText query;//搜索框
    @BindView(R.id.tv_sj)
    TextView tvSj;//时间
    @BindView(R.id.rl_sj)
    RelativeLayout rlSj;//时间
    @BindView(R.id.tv_lx)
    TextView tv_lx;//专利类型
    @BindView(R.id.iv_lx)
    ImageView iv_lx;//专利类型箭头
    @BindView(R.id.rcv)
    XRecyclerView rcv;
    @BindView(R.id.rl_recent)
    RelativeLayout rlRecent;//最近搜索
    @BindView(R.id.tv_rm)
    TextView tvRm;
    @BindView(R.id.rm)
    XRecyclerView rm;//热门搜索
    @BindView(R.id.rl_lx)
    RelativeLayout rlLx;//类型
    @BindView(R.id.ll_sx)
    LinearLayout llSx;
    @BindView(R.id.ll_jg)
    LinearLayout llJg;
    @BindView(R.id.recent)
    TextView recent;
    @BindView(R.id.xr)
    XRecyclerView xr;
    @BindView(R.id.ll_rs)
    LinearLayout llRs;
    private BaseRecyclerAdapter<PatentBean> myAdapter;//推荐阅读适配器
    private List<PatentBean> datas = new ArrayList<>();//专利列表
    private List<PatentTypeBean> typedatas = new ArrayList<>();//专利类型
    private PopupWindow mPopupWindow;
    private XzSimpleAdapter xzSimpleAdapter;
    String name;//搜索名字
    String patentType;//专利类型
    String releaseDate;//年份
    int page = 1;
    int rows = 10;
    int clickPos = 0;
    int intFlag = 0;//1是获取类型成功2是获取失败
    @Override
    public int getLayout() {
        return R.layout.search_patent;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        mPresenter = new SearchPatentPresenterImpl(this);
        iv_lx.setImageResource(R.mipmap.down_gray);
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
                if (!TextUtils.isEmpty(s.toString().trim())) {
                    name = s.toString().trim();
                    mPresenter.findPatentInfo(name, patentType, releaseDate, page, rows);
                }
            }
        });
        initData();
        //获取专利类型
        mPresenter.getPatentType("paten_type_key");

//        inithotReSou();
//        initRecentSearch();
    }

    /**
     * 填充最近搜索内容
     */
//    private void initRecentSearch() {
//        myAdapter= new BaseRecyclerAdapter<PatentBean>(getApplicationContext(), datas) {
//            @Override
//            public int getItemLayoutId(int viewType) {
//                return R.layout.rcv_rm_item;
//            }
//
//            @Override
//            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {
//
//            }
//        };
//        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getApplicationContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recent.setLayoutManager(linearLayoutManager);
//        recent.setAdapter(myAdapter);
//        myAdapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//            }
//            @Override
//            public void onItemLongClick(View view, int position) {
//
//            }
//        });
//    }

    /**
     * 热门搜索数据填充
     */

//    private void inithotReSou() {
//        myAdapter= new BaseRecyclerAdapter<String>(getApplicationContext(), datas) {
//            @Override
//            public int getItemLayoutId(int viewType) {
//                return R.layout.rcv_rm_item;
//            }
//
//            @Override
//            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {
//
//            }
//        };
//        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getApplicationContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        rm.setLayoutManager(linearLayoutManager);
//        rm.setAdapter(myAdapter);
//        myAdapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//            }
//            @Override
//            public void onItemLongClick(View view, int position) {
//
//            }
//        });
//    }

    /**
     * 填充数据
     */
    private void initData() {
        query.setHint("请输入专利号，专利名，公司名");
        myAdapter = new BaseRecyclerAdapter<PatentBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_search_patent;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, PatentBean item) {
                holder.getTextView(R.id.tv_Name).setText(item.getName());
                holder.getTextView(R.id.tv_sq).setText("申请人：" + item.getApplicatPerson());
                holder.getTextView(R.id.tv_rq).setText("申请日期：" + item.getReleaseDate());
                holder.getTextView(R.id.tv_flh).setText("主类分号：" + item.getApplicationNo());
            }
        };
        rlSj.setOnClickListener(this);
        rlLx.setOnClickListener(this);
        rcv.setAdapter(myAdapter);
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mPresenter.findPatentInfo(name, patentType, releaseDate, page, rows);
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.findPatentInfo(name, patentType, releaseDate, page, rows);
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_sj:
                break;
            case R.id.rl_lx:
                if (intFlag == 1) {
                    selectPop(typedatas);
                } else {
                    toast("获取专利类型失败");
                }
                break;
        }
    }

    @Override
    public void findPatentInfoSucess(List<PatentBean> list) {
        if (page == 1) {
            datas.clear();
        }
        datas.addAll(list);
        myAdapter.setData(datas);
    }

    @Override
    public void findPatentInfoFaild(int status, String errorMsg) {
        toast(errorMsg);
    }

    @Override
    public void findPatentNoData() {

    }

    @Override
    public void getPatentTypeSucess(List<PatentTypeBean> suceessMsg) {
        PatentTypeBean patentTypeBean = new PatentTypeBean();
        patentTypeBean.setDictName("类型不限");
        suceessMsg.add(0, patentTypeBean);
        typedatas = suceessMsg;
        intFlag = 1;
    }


    @Override
    public void getPatentTypeFaild(int status, String errorMsg) {
        intFlag = 2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    class XzSimpleAdapter extends BaseAdapter {
        private List<PatentTypeBean> typeBeanList;
        private int clickTemp = 0;

        public XzSimpleAdapter(List<PatentTypeBean> typeBean, int click) {
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
            convertView = View.inflate(getApplicationContext(), R.layout.rcv_item_select, null);
            TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            RelativeLayout rl_lx = (RelativeLayout) convertView.findViewById(R.id.rl_lx);
            ImageView iv_right = (ImageView) convertView.findViewById(R.id.iv_right);
            tv_title.setText(typeBeanList.get(position).getDictName());
            if (clickTemp == position) {
                rl_lx.setBackgroundColor(Color.WHITE);
                iv_right.setVisibility(View.VISIBLE);
            } else {
                rl_lx.setBackgroundColor(getResources().getColor(R.color.bg_grey_color));
                iv_right.setVisibility(View.GONE);
            }
            return convertView;
        }
    }

    /**
     * 选择对话框
     */
    private void selectPop(final List<PatentTypeBean> typeBean) {
        View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.act_select, null);
        mPopupWindow = new PopupWindow(v, AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT);
        ListView lv = (ListView) v.findViewById(R.id.lv);
        xzSimpleAdapter = new XzSimpleAdapter(typeBean, clickPos);
        lv.setAdapter(xzSimpleAdapter);
        tv_lx.setTextColor(Color.parseColor("#2485f2"));
        iv_lx.setImageResource(R.mipmap.sjtxx);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    patentType = "";
                } else {
                    patentType = typeBean.get(position).getDictName();
                }
                clickPos = position;
                mPopupWindow.dismiss();
                page = 1;
                mPresenter.findPatentInfo(name, patentType, releaseDate, page, rows);
            }
        });
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if (!TextUtils.isEmpty(patentType)) {
                    tv_lx.setText(patentType);
                } else {
                    tv_lx.setText("类型不限");
                }
                tv_lx.setTextColor(Color.parseColor("#000000"));
                iv_lx.setImageResource(R.mipmap.down_gray);
            }
        });
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        int xpos = manager.getDefaultDisplay().getWidth() / 2 - mPopupWindow.getWidth() / 2;
        //xoff,yoff基于anchor的左下角进行偏移。
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(null, ""));
        mPopupWindow.setAnimationStyle(R.style.ppAnimBottom);
        mPopupWindow.setFocusable(true);
        mPopupWindow.showAsDropDown(llSx, xpos, 0);
    }
}
