package com.boyuanitsm.echinfo.module.mine.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.UserBean;
import com.boyuanitsm.echinfo.module.mine.presenter.IModifyUserPresenter;
import com.boyuanitsm.echinfo.module.mine.presenter.ModifyUserPresenterImpl;
import com.boyuanitsm.echinfo.module.mine.view.IModifyUserView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.echinfo.widget.ClearEditText;

import butterknife.BindView;


/**
 * 修改资料界面
 * Created by yang on 2016/12/29.
 */
public class EditAct extends BaseAct<IModifyUserPresenter> implements IModifyUserView {
    @BindView(R.id.cet_Edit_Update)
    ClearEditText cet;
    private int TYPE;//1修改密码，2姓名，3公司，4工作
    public static final String USER_TYPE = "type";
    UserBean user;
    String pwd,newPwd;
    boolean flag = true;
    int error;

    @Override
    public int getLayout() {
        return R.layout.act_edit;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        TYPE = getIntent().getIntExtra(USER_TYPE, 0);
        user = new UserBean();
        user = EchinfoUtils.getCurrentUser();
        mPresenter = new ModifyUserPresenterImpl(this);
        setTopT(TYPE);
        setRightBtn("保存", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(cet.getText().toString().trim())){
                    switch (TYPE){
                        case 1:
                            newPwd=cet.getText().toString().trim();
                            pwd=user.getPassword();
                            break;
                        case 2:
                            user.setName(cet.getText().toString().trim());
                            break;
                        case 3:
                            user.setCompanyName(cet.getText().toString().trim());
                            break;
                        case 4:
                            user.setJob(cet.getText().toString().trim());
                            break;
                    }
                    if (TYPE==1){
                        mPresenter.modifyPwd(pwd,newPwd);
                    }else {
                        mPresenter.modifyUser(user);
                    }
                }else {
                    toast("不能为空");
                }
            }
        });

    }

    private void setTopT(int position) {
        switch (position) {
            case 1:
                setTopTitle("修改密码");
                cet.setHint("请输入修改密码");
                cet.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD); //输入隐藏密码类型
                cet.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)}); //最大输入长度
                break;
            case 2:
                setTopTitle("修改姓名");
                if (!TextUtils.isEmpty(user.getName())) {
                    cet.setHint(user.getName());
                } else {
                    cet.setHint("请输入修改名字");
                }
                cet.setInputType(InputType.TYPE_CLASS_TEXT); //输入文本类型
                cet.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)}); //最大输入长度
                break;
            case 3:
                setTopTitle("修改公司");
                if (!TextUtils.isEmpty(user.getCompanyName())) {
                    cet.setHint(user.getCompanyName());
                } else {
                    cet.setHint("请输入修改公司名称");
                }
                cet.setInputType(InputType.TYPE_CLASS_TEXT); //输入文本类型
                cet.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)}); //最大输入长度
                break;
            case 4:
                setTopTitle("修改职业");
                if (!TextUtils.isEmpty(user.getJob())){
                    cet.setHint(user.getJob());
                }else {
                    cet.setHint("请输入修改职业名称");
                }
                cet.setInputType(InputType.TYPE_CLASS_TEXT); //输入文本类型
                cet.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)}); //最大输入长度
                break;
        }
    }

    @Override
    public void modifyUserSucess(String sucessMsg) {
        toast(sucessMsg);
        sendBroadcast(new Intent(MineAct.USER_INFO));
        finish();
    }

    @Override
    public void modifyUserFaild(int status, String errorMsg) {
        toast(errorMsg);
    }

    @Override
    public void modifyPwdSucess(String sucessMsg) {

    }

    @Override
    public void modifyPwdFaild(int status, String errorMsg) {

    }

}
