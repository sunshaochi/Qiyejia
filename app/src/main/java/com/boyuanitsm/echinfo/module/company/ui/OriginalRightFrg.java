package com.boyuanitsm.echinfo.module.company.ui;

import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 原创著作权
 * Created by Yang on 2017/1/4 0004.
 */
public class OriginalRightFrg extends BaseFrg{
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<String> mAdp;
    private List<String> testList = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.rcv_frg_customview;
    }

    @Override
    protected void initView(View fragmentRootView) {
        initFrg();
    }

    private void initFrg() {
        testList = EchinfoUtils.getTestDatas(3);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getContext().getApplicationContext(), true);
        mAdp = new BaseRecyclerAdapter<String>(getContext().getApplicationContext(), testList) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_copyright_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {
                holder.getTextView(R.id.tv_rightTitle1).setText("类别");
                holder.getTextView(R.id.tv_rightTitle2).setText("登记号");
                holder.getTextView(R.id.tv_rightTitle3).setText("登记日期");
                holder.getTextView(R.id.tv_rightTitle4).setText("发布日期");
                holder.getTextView(R.id.tv_rightTitle5).setText("创作完成日期");
                holder.getView(R.id.ll_copyRight6).setVisibility(View.GONE);
            }
        };
        rcv.setAdapter(mAdp);
    }
}
