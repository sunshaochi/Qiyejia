package com.boyuanitsm.echinfo.module.company.ui;

import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.bean.SoftwareCopyright;
import com.boyuanitsm.echinfo.module.company.presenter.ICompanyBasePre;
import com.boyuanitsm.echinfo.module.company.presenter.SoftwareRightPreImpl;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 软件著作权
 * Created by Yang on 2017/1/4 0004.
 */
public class SoftwareRightFrg extends BaseFrg<ICompanyBasePre> implements IBaseListView<SoftwareCopyright> {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<SoftwareCopyright> mAdp;
    private List<SoftwareCopyright> datas = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.rcv_frg_customview;
    }

    @Override
    protected void initView(View fragmentRootView) {
        mPresenter=new SoftwareRightPreImpl(this);
        mPresenter.getDatas(CopyrightAct.companyId);
        initFrg();
    }

    private void initFrg() {
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getContext(), false);
        mAdp = new BaseRecyclerAdapter<SoftwareCopyright>(getContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_copyright_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, SoftwareCopyright item) {
                holder.getTextView(R.id.tv1).setText(item.getSoftwareBookName());
                holder.getTextView(R.id.tv2).setText(item.getTypeNo());
                holder.getTextView(R.id.tv3).setText(item.getCasRn());
                holder.getTextView(R.id.tv4).setText(item.getCasRnCheckDate());
                holder.getTextView(R.id.tv5).setText(item.getFirstReleaseDate());
                holder.getTextView(R.id.tv6).setText(item.getCopyrightOwner());
            }
        };
        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPresenter.getDatas(CopyrightAct.companyId);

            }

            @Override
            public void onLoadMore() {

            }
        });
        rcv.setAdapter(mAdp);
    }

    @Override
    public void setDatas(List<SoftwareCopyright> mDatas) {
        rcv.refreshComplete();
        datas=mDatas;
        mAdp.setData(datas);

    }

    @Override
    public void requestError(int status, String errorMsg) {
        rcv.refreshComplete();
    }

    @Override
    public void requestNoData() {
        rcv.refreshComplete();
    }
}
