package com.boyuanitsm.echinfo.module.mine.ui;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.widget.ClearEditText;

import butterknife.BindView;


/**
 * 修改资料界面
 * Created by yang on 2016/12/29.
 */
public class EditAct extends BaseAct {
    @BindView(R.id.cet_Edit_Update)
    ClearEditText cet;
    private int TYPE;//1修改密码，2姓名，3公司
    public static final String USER_TYPE = "type";

    @Override
    public int getLayout() {
        return R.layout.act_edit;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        TYPE = getIntent().getIntExtra(USER_TYPE, 0);
        setTopT(TYPE);
        setRightBtn("保存", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(cet.getText().toString().trim())) {
                } else {
                }
            }
        });
    }

    private void setTopT(int position) {
        switch (position) {
            case 1:
                setTopTitle("修改密码");
                cet.setHint("请输入修改密码");
                cet.setInputType(InputType.TYPE_CLASS_TEXT |InputType.TYPE_TEXT_VARIATION_PASSWORD); //输入隐藏密码类型
                cet.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)}); //最大输入长度
                break;
            case 2:
                setTopTitle("修改姓名");
                cet.setHint("请输入修改名字");
                cet.setInputType(InputType.TYPE_CLASS_TEXT); //输入文本类型
                cet.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)}); //最大输入长度
                break;
            case 3:
                setTopTitle("修改公司");
                cet.setHint("请输入修改公司名称");
                cet.setInputType(InputType.TYPE_CLASS_TEXT); //输入文本类型
                cet.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)}); //最大输入长度
                break;
        }
    }

}
