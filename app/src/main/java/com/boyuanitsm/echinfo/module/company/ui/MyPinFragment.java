package com.boyuanitsm.echinfo.module.company.ui;

import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.bean.AttenBean;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by bitch-1 on 2017/2/24.
 */
public class MyPinFragment extends BaseFrg {
    @BindView(R.id.rcv)
    XRecyclerView rcv;
    private List<String>testlist=new ArrayList<>();
    private BaseRecyclerAdapter<String> myAdapter;//
    @Override
    public int getLayout() {
        return R.layout.mypinfra;
    }

    @Override
    protected void initView(View fragmentRootView) {
        testlist=EchinfoUtils.getTestDatas(4);
        rcv= EchinfoUtils.getLinearRecyclerView(rcv,getContext(),true);
        myAdapter=new BaseRecyclerAdapter<String>(getContext(),testlist) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.item_mypin;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {

            }
        };

    }
}
