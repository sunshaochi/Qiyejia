package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.LoseCreditBean;
import com.boyuanitsm.echinfo.bean.LoseCreditDatabean;
import com.boyuanitsm.echinfo.bean.LoseCreditRowsBean;
import com.boyuanitsm.echinfo.module.company.presenter.CrediteListPreImpl;
import com.boyuanitsm.echinfo.module.company.presenter.ICreditListPre;
import com.boyuanitsm.echinfo.module.company.view.ICrediteListView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 失信信息
 * Created by Yang on 2017/1/5 0005.
 */
public class CreditInfoAct extends BaseAct<ICreditListPre> implements ICrediteListView{
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    private BaseRecyclerAdapter<LoseCreditBean> mAdp;
    private List<LoseCreditBean> datas = new ArrayList<>();
    String sid;
    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("失信信息");
        sid=getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter=new CrediteListPreImpl(this);
        mPresenter.getICrediteByid(sid);
        setRightBtn(R.mipmap.share_circle_icon, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        initFrg();
    }

    private void initFrg() {
//        datas = EchinfoUtils.getTestDatas(3);
        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), false);
        mAdp = new BaseRecyclerAdapter<LoseCreditBean>(getApplicationContext(), datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_creditinfo_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, LoseCreditBean item) {
                holder.getTextView(R.id.tv_name).setText(item.getIname());
                holder.getTextView(R.id.tv_hm).setText(item.getGistid());
                holder.getTextView(R.id.tv_ah).setText(item.getCasecode());
                holder.getTextView(R.id.tv_sf).setText(item.getAreaname());
            }
        };
        mAdp.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle=new Bundle();
                bundle.putParcelable(CreditDetailAct.CREDIT_DETAIL,datas.get(position-1));
                openActivity(CreditDetailAct.class,bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        rcv.setAdapter(mAdp);
    }

    @Override
    public void getCreditListSucess(LoseCreditDatabean databean) {
        if (databean!=null){
            LoseCreditRowsBean courtPerson = databean.getCourtPerson();
            if (courtPerson!=null){
                List<LoseCreditBean> rows = courtPerson.getRows();
                if (rows!=null&&rows.size()>0){
                    datas.addAll(rows);
                }
            }
            LoseCreditRowsBean courtUnit = databean.getCourtUnit();
            if (courtUnit!=null){
                List<LoseCreditBean> rows = courtUnit.getRows();
                if (rows!=null&&rows.size()>0){
                    datas.addAll(rows);
                }
            }
        }
        mAdp.setData(datas);
    }

    @Override
    public void findLoseCreditNoData() {

    }

    @Override
    public void getCreditListFaild(int status, String errorMsg) {
        toast(errorMsg);
    }
}
