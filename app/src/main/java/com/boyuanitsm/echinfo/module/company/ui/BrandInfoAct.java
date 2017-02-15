package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.BrandBean;
import com.boyuanitsm.echinfo.widget.MineItemView;
import com.boyuanitsm.echinfo.widget.MyListView;

import butterknife.BindView;

/**
 * 商标详细信息
 * Q164454216
 * Created by xiaoke on 2017/2/15.
 */

public class BrandInfoAct extends BaseAct {
    @BindView(R.id.ivRight)
    ImageView ivRight;
    @BindView(R.id.rl_right)
    RelativeLayout rlRight;
    @BindView(R.id.iv_log)
    ImageView ivLog;//商标log
    @BindView(R.id.miv_mc)
    MineItemView mivMc;//商标名称
    @BindView(R.id.miv_lx)
    MineItemView mivLx;//商标类型
    @BindView(R.id.miv_zch)
    MineItemView mivZch;//注册号
    @BindView(R.id.miv_sq)
    MineItemView mivSq;//申请时间
    @BindView(R.id.miv_zt)
    MineItemView mivZt;//状态
    @BindView(R.id.miv_qx)
    MineItemView mivQx;//使用期限
    @BindView(R.id.tv_sqr)
    TextView tvSqr;//申请人
    @BindView(R.id.tv_sqdz)
    TextView tvSqdz;//申请地址
    @BindView(R.id.tv_dljg)
    TextView tvDljg;//代理机构
    @BindView(R.id.lv_lc)
    MyListView lvLc;//申请流程
    @BindView(R.id.lv_fw)
    MyListView lvFw;//服务列表
    @BindView(R.id.miv_ch)
    MineItemView mivCh;//初审公告号
    @BindView(R.id.miv_crq)
    MineItemView mivCrq;//初审公告日期
    @BindView(R.id.miv_zgh)
    MineItemView mivZgh;//注册公告号
    @BindView(R.id.miv_rq)
    MineItemView mivRq;//注册公告日期
    public static  final String BRANDINFO="brand_info";
    private BrandBean brandBean;
    @Override
    public int getLayout() {
        return R.layout.act_brandetail;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("商标详情");
       brandBean= getIntent().getParcelableExtra(BRANDINFO);
        ivRight.setImageResource(R.mipmap.share);
        mivMc.setRightText(brandBean.getName());
        mivLx.setRightText(brandBean.getType());
        mivZch.setRightText(brandBean.getRegisterNo());
        mivSq.setRightText(brandBean.getApplicatTime());
        mivZt.setRightText(brandBean.getStatus());
        mivQx.setRightText(brandBean.getUseTime());
        tvSqr.setText(brandBean.getApplicatPerson());
//        tvSqdz.setText();
        tvDljg.setText(brandBean.getAgent());

    }


}
