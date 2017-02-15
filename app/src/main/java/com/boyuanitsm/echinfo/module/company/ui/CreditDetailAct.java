package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.LoseCreditBean;

import butterknife.BindView;

/**
 * 失信公司信息（失信详情）
 * Created by Yang on 2017/1/5 0005.
 */
public class CreditDetailAct extends BaseAct {
    public static final String CREDIT_DETAIL = "credit_detail";
    @BindView(R.id.tv_jgh)
    TextView tvJgh;
    @BindView(R.id.tv_fr)
    TextView tvFr;
    @BindView(R.id.tv_sf)
    TextView tvSf;
    @BindView(R.id.tv_wh)
    TextView tvWh;
    @BindView(R.id.tv_fy)
    TextView tvFy;
    @BindView(R.id.tv_lx)
    TextView tvLx;
    @BindView(R.id.tv_yw)
    TextView tvYw;
    @BindView(R.id.tv_xw)
    TextView tvXw;
    @BindView(R.id.tv_rq)
    TextView tvRq;
    private LoseCreditBean loseCreditBean;
    @Override
    public int getLayout() {
        return R.layout.act_creditdetail;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("失信公司信息");
        loseCreditBean=  getIntent().getParcelableExtra(CREDIT_DETAIL);
        setRightBtn("纠错", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ErrorCorrectionAct.class);
            }
        });
        tvJgh.setText(loseCreditBean.getCardnum());
        tvFr.setText(loseCreditBean.getIname());
        tvFy.setText(loseCreditBean.getCourtname());
        tvXw.setText(loseCreditBean.getDisrupttypename());
        tvLx.setText(loseCreditBean.getPerformance());
        tvRq.setText(loseCreditBean.getPublishdate());
        tvSf.setText(loseCreditBean.getAreaname());
    }

}
