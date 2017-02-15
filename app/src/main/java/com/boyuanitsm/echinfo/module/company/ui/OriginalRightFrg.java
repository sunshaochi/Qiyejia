package com.boyuanitsm.echinfo.module.company.ui;

import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseFrg;
import com.boyuanitsm.echinfo.bean.CopyrightsBean;
import com.boyuanitsm.echinfo.module.company.presenter.ICompanyBasePre;
import com.boyuanitsm.echinfo.module.company.presenter.OriginalRightPreImpl;
import com.boyuanitsm.echinfo.module.company.view.IBaseListView;
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
public class OriginalRightFrg extends BaseFrg<ICompanyBasePre>  implements IBaseListView<CopyrightsBean> {
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<CopyrightsBean> mAdp;
    private List<CopyrightsBean> datas = new ArrayList<>();

    @Override
    public int getLayout() {
        return R.layout.rcv_frg_customview;
    }

    @Override
    protected void initView(View fragmentRootView) {
        mPresenter=new OriginalRightPreImpl(this);
        mPresenter.getDatas(CopyrightAct.companyId);
        initFrg();
    }

    private void initFrg() {
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getContext().getApplicationContext(), false);
        mAdp = new BaseRecyclerAdapter<CopyrightsBean>(getContext().getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_copyright_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, CopyrightsBean item) {
                holder.getTextView(R.id.tv_rightTitle1).setText("类别");
                holder.getTextView(R.id.tv_rightTitle2).setText("登记号");
                holder.getTextView(R.id.tv_rightTitle3).setText("登记日期");
                holder.getTextView(R.id.tv_rightTitle4).setText("发布日期");
                holder.getTextView(R.id.tv_rightTitle5).setText("创作完成日期");
                holder.getView(R.id.ll_copyRight6).setVisibility(View.GONE);

                holder.getTextView(R.id.tv1).setText(item.getType());
                holder.getTextView(R.id.tv2).setText(item.getCasRn());
                holder.getTextView(R.id.tv3).setText(item.getCasRnDate());
                holder.getTextView(R.id.tv4).setText(item.getFirstReleaseDate());
                holder.getTextView(R.id.tv5).setText(item.getFinishCreateDate());

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
    public void setDatas(List<CopyrightsBean> mdatas) {
        rcv.refreshComplete();
        datas=mdatas;
        mAdp.setData(datas);
    }

    @Override
    public void requestError(int status, String errorMsg) {
        rcv.refreshComplete();
        toast(errorMsg);
    }

    @Override
    public void requestNoData() {
        rcv.refreshComplete();
    }
}
