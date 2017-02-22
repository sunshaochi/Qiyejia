package com.boyuanitsm.echinfo.module.home.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.HomeComAdapter;
import com.boyuanitsm.echinfo.adapter.HomeZxAdapter;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.bean.AttenBean;
import com.boyuanitsm.echinfo.bean.CompanyBean;
import com.boyuanitsm.echinfo.event.MainTabEvent;
import com.boyuanitsm.echinfo.module.company.ui.CompanyAct;
import com.boyuanitsm.echinfo.module.company.ui.JingyingFwAct;
import com.boyuanitsm.echinfo.module.company.ui.PinpaidocAct;
import com.boyuanitsm.echinfo.module.company.ui.SearchGsByNameAct;
import com.boyuanitsm.echinfo.module.home.presenter.HomePresenterImpl;
import com.boyuanitsm.echinfo.module.home.presenter.IHomePresenter;
import com.boyuanitsm.echinfo.module.home.ui.search.FindBrandAct;
import com.boyuanitsm.echinfo.module.home.ui.search.SearchCopyrightAct;
import com.boyuanitsm.echinfo.module.home.ui.search.SearchHot;
import com.boyuanitsm.echinfo.module.home.ui.search.SearchImplementedAct;
import com.boyuanitsm.echinfo.module.home.ui.search.SearchJudgmentAct;
import com.boyuanitsm.echinfo.module.home.ui.search.SearchPatentAct;
import com.boyuanitsm.echinfo.module.home.ui.search.SearchShareholderAct;
import com.boyuanitsm.echinfo.module.home.ui.search.SearchlosecreditAct;
import com.boyuanitsm.echinfo.module.home.view.IHomeView;
import com.boyuanitsm.echinfo.module.user.ui.LoginAct;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.MyGridView;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.view.FullyLinearLayoutManager;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 首页
 * Created by wangbin on 16/12/22.
 */
public class HomeFrg extends BaseFrg<IHomePresenter> implements IHomeView, View.OnClickListener {
    @BindView(R.id.rcv)
    XRecyclerView rcv;
    RelativeLayout rlTop;
    RecyclerView rcvMyFollow;//我的关注
    RecyclerView rcvHotCom;//热门企业
    RelativeLayout rl_search;//搜索高级搜索


    private BaseRecyclerAdapter<String> disAdapter;//失信适配器
    private BaseRecyclerAdapter<CompanyBean> hotAdapter;//热门企业适配器

    private List<String> datas = new ArrayList<>();
    private List<CompanyBean> companylist = new ArrayList<>();

    private List<AttenBean> attdatas = new ArrayList<>();//关注list
    private BaseRecyclerAdapter<AttenBean> myAdapter;//我的关注适配器

    @Override
    public int getLayout() {
        return R.layout.frg_home;
    }

    @Override
    protected void initView(View fragmentRootView) {
        datas = EchinfoUtils.getTestDatas(0);
        mPresenter = new HomePresenterImpl(this);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getContext(), false);

        View headView = View.inflate(getContext(), R.layout.home_head_view, null);
        rlTop = (RelativeLayout) headView.findViewById(R.id.rlTop);
        rcvHotCom = (RecyclerView) headView.findViewById(R.id.rcvHotCom);
        rcvMyFollow = (RecyclerView) headView.findViewById(R.id.rcvMyFollow);
        rl_search = (RelativeLayout) headView.findViewById(R.id.rl_search);
        headView.findViewById(R.id.cvMyFollow).setOnClickListener(this);
        headView.findViewById(R.id.cvHotCom).setOnClickListener(this);
        headView.findViewById(R.id.cvSxbd).setOnClickListener(this);
        rl_search.setOnClickListener(this);
        mPresenter.getHotHistory("EnterpriseInfo");
        mPresenter.getMyAttention();
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getHotHistory("EnterpriseInfo");
                mPresenter.getMyAttention();
            }

            @Override
            public void onLoadMore() {

            }
        });
        if (!EchinfoUtils.isLogin()) {
            rcvMyFollow.setVisibility(View.GONE);
        } else {
            rcvMyFollow.setVisibility(View.VISIBLE);
        }
        initMyFollow();
        initHotCom();
        /*查企业*/
        MyGridView gvHomeCompany = (MyGridView) headView.findViewById(R.id.gvHomeCompany);
        gvHomeCompany.setAdapter(new HomeComAdapter(getContext()));
        gvHomeCompany.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0://企业名称
                        openActivity(SearchGsByNameAct.class);
                        break;
                    case 1://股东高管
                        openActivity(SearchShareholderAct.class);
                        break;
                    case 2://经营范围
                        openActivity(JingyingFwAct.class);
                        break;
                    case 3://品牌产品
                        openActivity(PinpaidocAct.class);
                        break;
                }
            }
        });
        /*查专项*/
        MyGridView gvZx = (MyGridView) headView.findViewById(R.id.gvZx);
        gvZx.setAdapter(new HomeZxAdapter(getContext()));
        gvZx.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0://查专利
                        openActivity(SearchPatentAct.class);
                        break;
                    case 1://查商标
                        openActivity(FindBrandAct.class);
                        break;
                    case 2://查著作权
                        openActivity(SearchCopyrightAct.class);
                        break;
                    case 3://查判决
                        openActivity(SearchJudgmentAct.class);
                        break;
                    case 4://失信人
                        openActivity(SearchlosecreditAct.class);
                        break;
                    case 5://被执行
                        openActivity(SearchImplementedAct.class);
                        break;
                }
            }
        });
        rcv.addHeaderView(headView);

        if (disAdapter == null) {
            disAdapter = new BaseRecyclerAdapter<String>(getContext(), datas) {
                @Override
                public int getItemLayoutId(int viewType) {
                    return R.layout.rcv_dishonesty_item;
                }

                @Override
                public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

                }
            };
        }
        rcv.setAdapter(disAdapter);
        disAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    /**
     * 我的关注
     */
    private void initMyFollow() {
        myAdapter = new BaseRecyclerAdapter<AttenBean>(getContext(), attdatas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_my_follow;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, AttenBean item) {
                holder.getTextView(R.id.tv_name).setText(item.getCompanyName());
                holder.getTextView(R.id.tv_fr).setText("公司法人:" + item.getLegalPerson());
                holder.getTextView(R.id.tv_zt).setText(item.getManagementStatus());

            }
        };
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvMyFollow.setLayoutManager(linearLayoutManager);
        rcvMyFollow.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString(CompanyAct.COMAPYT_ID, attdatas.get(position).getId());
                openActivity(CompanyAct.class, bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    /**
     * 热门企业
     */
    private void initHotCom() {
        hotAdapter = new BaseRecyclerAdapter<CompanyBean>(getContext(), companylist) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_dishonesty_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, CompanyBean item) {
                holder.getTextView(R.id.tv_name).setText(item.getCompanyName());
                holder.getTextView(R.id.tv_sj).setText(item.getPublishDate());
            }
        };
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvHotCom.setLayoutManager(linearLayoutManager);
        rcvHotCom.setAdapter(hotAdapter);
        hotAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString(CompanyAct.COMAPYT_ID, companylist.get(position).getId());
                openActivity(CompanyAct.class, bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cvMyFollow://我的关注
                if (!EchinfoUtils.isLogin()) {
                    openActivity(LoginAct.class);
                    return;
                }
                EventBus.getDefault().post(new MainTabEvent(1));
                break;
            case R.id.cvHotCom://热门企业
                openActivity(SearchHot.class);
                break;
            case R.id.cvSxbd://失信榜单

                break;
            case R.id.rl_search://高级搜索
                openActivity(SearchGsByNameAct.class);
                break;
        }
    }

    @Override
    public void getHotHistorySucess(List<CompanyBean> suceessMsg) {
        rcv.refreshComplete();
        if (companylist != null & companylist.size() > 0) {
            companylist.clear();
        }
        if (suceessMsg != null && suceessMsg.size() > 0) {
            companylist.addAll(suceessMsg);
        }
        hotAdapter.setData(companylist);
    }

    @Override
    public void getHotHistoryFaild(int status, String errorMsg) {
        toast(errorMsg);

    }


    //关注企业
    @Override
    public void setFollowDatas(List<AttenBean> mdatas) {
        if (attdatas != null && attdatas.size() > 0) {
            attdatas.clear();
        }
        if (mdatas.size() > 4) {
            for (int i = 0; i < 4; i++) {
                attdatas.add(mdatas.get(i));
            }
        } else {
            attdatas = mdatas;
        }
        myAdapter.setData(attdatas);


    }

    @Override
    public void requestError(int status, String errorMsg) {

    }

    @Override
    public void requestNoData() {

    }


    private MyReceiver myReceiver;
    public static final String DATA_UPDATA = "com.update.homeinfo";

    public class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (!EchinfoUtils.isLogin()) {
                rcvMyFollow.setVisibility(View.GONE);
            } else {
                rcvMyFollow.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (myReceiver == null) {
            myReceiver = new MyReceiver();
            mActivity.registerReceiver(myReceiver, new IntentFilter(DATA_UPDATA));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (myReceiver != null) {
            mActivity.unregisterReceiver(myReceiver);
            myReceiver = null;
        }
    }
}
