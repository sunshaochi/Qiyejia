package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.QiYeZsBean;

import butterknife.BindView;

/**
 * 企业证书详情接口
 * Q164454216
 * Created by xiaoke on 2017/2/21.
 */

public class QiYeZsInfo extends BaseAct {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_dw)
    TextView tvDw;
    @BindView(R.id.tv_jb)
    TextView tvJb;
    @BindView(R.id.tv_hm)
    TextView tvHm;
    @BindView(R.id.tv_rq)
    TextView tvRq;
    @BindView(R.id.tv_sf)
    TextView tvSf;
    @BindView(R.id.tv_bg)
    TextView tvBg;
    @BindView(R.id.tv_ba)
    TextView tvBa;
    public static final String QIYE_INFO = "qiye_info";
    private QiYeZsBean qiYeZsBean;

    @Override
    public int getLayout() {
        return R.layout.act_qiye_info;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("证书详情");
        qiYeZsBean = getIntent().getParcelableExtra(QIYE_INFO);
        if (qiYeZsBean != null) {
            tvName.setText(qiYeZsBean.getRemark());
            tvDw.setText(qiYeZsBean.getRemark());
//            tvDw.setText();
            tvRq.setText(qiYeZsBean.getReleaseCertificateDate());
            tvJb.setText(qiYeZsBean.getCertificateType());

        }

    }


}
