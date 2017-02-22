package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.WebsiteBean;
import com.boyuanitsm.echinfo.module.company.presenter.IWebsitePre;
import com.boyuanitsm.echinfo.module.company.presenter.IWebsitePreImpl;
import com.boyuanitsm.echinfo.module.company.view.IWebsiteView;
import com.boyuanitsm.echinfo.widget.MineItemView;

import java.util.List;

import butterknife.BindView;

/**
 * 注册网站信息
 * Created by Yang on 2017/1/5 0005.
 */
public class WebsiteAct extends BaseAct<IWebsitePre> implements IWebsiteView {
    @BindView(R.id.tv_name)
    MineItemView tv_name;
    @BindView(R.id.tv_shouye)
    MineItemView tv_shouye;
    @BindView(R.id.tv_beian)
    MineItemView tv_beian;
    @BindView(R.id.tv_time)
    MineItemView tv_time;
    @BindView(R.id.tv_zt)
    MineItemView tv_zt;
    @BindView(R.id.tv_danwei)
    MineItemView tv_danwei;
    private String companyId;
    @Override
    public int getLayout() {
        return R.layout.act_website;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("网站信息");
        mPresenter=new IWebsitePreImpl(this);
        companyId = getIntent().getStringExtra(CompanyAct.COMAPYT_ID);
        mPresenter.getData(companyId);
    }


    @Override
    public void setData(List<WebsiteBean> data) {
        tv_name.setRightText(data.get(0).getWebName());
        tv_shouye.setRightText(data.get(0).getAddress());
        tv_beian.setRightText(data.get(0).getPublishNo());
        tv_time.setRightText(data.get(0).getEstablishDate());
        tv_zt.setRightText(data.get(0).getStatus());
        tv_danwei.setRightText(data.get(0).getOrtNature());
    }

    @Override
    public void requestError(int status, String errorMsg) {

    }

    @Override
    public void requestNoData() {

    }
}
