package com.boyuanitsm.echinfo.module.home.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.adapter.HomeComAdapter;
import com.boyuanitsm.echinfo.adapter.HomeZxAdapter;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.module.home.presenter.HomePresenterImpl;
import com.boyuanitsm.echinfo.module.home.presenter.IHomePresenter;
import com.boyuanitsm.echinfo.module.home.ui.search.SearchBrandAct;
import com.boyuanitsm.echinfo.module.home.ui.search.SearchPatentAct;
import com.boyuanitsm.echinfo.module.home.view.IHomeView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.MyGridView;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.view.FullyLinearLayoutManager;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 首页
 * Created by wangbin on 16/12/22.
 */
public class HomeFrg extends BaseFrg<IHomePresenter> implements IHomeView, View.OnClickListener{
    @BindView(R.id.rcv)
    XRecyclerView rcv;
    RelativeLayout rlTop;
    RecyclerView rcvMyFollow;//我的关注
    RecyclerView rcvHotCom;//热门企业

    private BaseRecyclerAdapter<String> myAdapter;//我的关注适配器
    private BaseRecyclerAdapter<String> disAdapter;//失信适配器
    private BaseRecyclerAdapter<String> hotAdapter;//热门企业适配器

    private List<String> datas = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.frg_home;
    }

    @Override
    protected void initView(View fragmentRootView) {
        datas = EchinfoUtils.getTestDatas(4);

        mPresenter = new HomePresenterImpl(this);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getContext(), false);
        View headView = View.inflate(getContext(), R.layout.home_head_view, null);
        rlTop = (RelativeLayout) headView.findViewById(R.id.rlTop);
        rcvHotCom = (RecyclerView) headView.findViewById(R.id.rcvHotCom);
        rcvMyFollow= (RecyclerView) headView.findViewById(R.id.rcvMyFollow);
        headView.findViewById(R.id.cvMyFollow).setOnClickListener(this);
        headView.findViewById(R.id.cvHotCom).setOnClickListener(this);
        headView.findViewById(R.id.cvSxbd).setOnClickListener(this);
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

                        break;
                    case 1://股东高管

                        break;
                    case 2://经营范围

                        break;
                    case 3://品牌产品

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
                        openActivity(SearchBrandAct.class);
                        break;
                    case 2://查著作权

                        break;
                    case 3://查判决

                        break;
                    case 4://失信人

                        break;
                    case 5://被执行

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
    private void initMyFollow(){
        myAdapter= new BaseRecyclerAdapter<String>(getContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_my_follow;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvMyFollow.setLayoutManager(linearLayoutManager);
        rcvMyFollow.setAdapter(myAdapter);
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
     * 热门企业
     */
    private void initHotCom() {
        hotAdapter = new BaseRecyclerAdapter<String>(getContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_dishonesty_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvHotCom.setLayoutManager(linearLayoutManager);
        rcvHotCom.setAdapter(hotAdapter);
        hotAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }





    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cvMyFollow://我的关注

                break;
            case R.id.cvHotCom://热门企业

                break;
            case R.id.cvSxbd://失信榜单

                break;
        }
    }
}
