package com.boyuanitsm.echinfo.module.mine.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.module.mine.presenter.FeedPreImpl;
import com.boyuanitsm.echinfo.module.mine.presenter.IFeedPre;
import com.boyuanitsm.echinfo.module.mine.view.IFeedView;

import butterknife.BindView;

/**
 * 意见反馈
 * Created by Yang on 2016/12/29 0029.
 */
public class FeedBackAct extends BaseAct<IFeedPre>implements IFeedView {
    @BindView(R.id.et_content)
    EditText et_content;
    @BindView(R.id.et_phone)
    EditText et_phone;
    private String content;//意见内容
    private String phone;//联系方式
    @Override
    public int getLayout() {
        return R.layout.act_feedback;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("意见反馈");
        mPresenter=new FeedPreImpl(this);
        setRightBtn("提交", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content=et_content.getText().toString().trim();
                phone=et_phone.getText().toString().trim();
                if(TextUtils.isEmpty(content)){
                    toast("请输入内容");
                    et_content.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(phone)){
                    toast("请输入联系方式");
                    et_phone.requestFocus();
                    return;
                }
                mPresenter.Commit(content,phone);

            }
        });
    }

    @Override
    public void CommitSuc() {
        toast("提交成功");
        finish();

    }

    @Override
    public void requstErroy(int statu, String errormesage) {
        toast(errormesage);

    }
}
