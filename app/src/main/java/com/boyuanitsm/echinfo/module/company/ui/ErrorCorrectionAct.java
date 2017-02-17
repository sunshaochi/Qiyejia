package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.ErrorBean;
import com.boyuanitsm.echinfo.module.company.presenter.ErrorListPreImpl;
import com.boyuanitsm.echinfo.module.company.presenter.IErrorListPre;
import com.boyuanitsm.echinfo.module.company.view.IErrorListView;
import com.boyuanitsm.echinfo.utils.EchinfoUtils;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.callback.OnItemClickListener;
import com.boyuanitsm.tools.utils.MyLogUtils;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 纠错
 * Created by Yang on 2017/1/4 0004.
 */
public class ErrorCorrectionAct extends BaseAct<IErrorListPre> implements IErrorListView{
    @BindView(R.id.rcv)
    XRecyclerView rcv;

    @BindView(R.id.etContent)
    EditText etContent;
    @BindView(R.id.etPhone)
    EditText etPhone;
    private String content;
    private String phone;
    private BaseRecyclerAdapter<ErrorBean> mAdp;
    private List<ErrorBean> testList = new ArrayList<>();

    private List<ErrorBean> subList;
    private int oldPos=-1;//上次记录的位置
    private String companyId = "";//公司id
    @Override
    public int getLayout() {
        return R.layout.act_errorcorrection;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("纠错");
        initFrg();
    }

    private void initFrg() {
        mPresenter = new ErrorListPreImpl(this);
        mPresenter.getErrorList("correction_manage");
        companyId = "00000386c8e14123b73880a1d487bdc8";
//        testList = EchinfoUtils.getTestDatas(12);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),4);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.setLoadingMoreEnabled(false);
        rcv.setPullRefreshEnabled(false);
        rcv.setLayoutManager(gridLayoutManager);
        mAdp = new BaseRecyclerAdapter<ErrorBean>(getApplicationContext(), testList) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.rcv_errorcorrection_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, final int position, ErrorBean item) {
                ((CheckBox)holder.getView(R.id.cbMsg)).setText(item.getDictName());
//                ((CheckBox)holder.getView(R.id.cbMsg)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                        if (isChecked){
//                            testList.get(position).setChecked(true);
//                        }else {
//                            testList.get(position).setChecked(false);
//                        }
//                    }
//                });

//                MyLogUtils.error("---------:"+testList.toString());
                //是否选中
                if (testList.get(position).isChecked()){
                    ((CheckBox)holder.getView(R.id.cbMsg)).setChecked(true);
                }else {
                    ((CheckBox)holder.getView(R.id.cbMsg)).setChecked(false);
                }
            }
        };
        rcv.setAdapter(mAdp);
        mAdp.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                MyLogUtils.error("oldPos:"+oldPos);
                MyLogUtils.error("position:"+position);
                if (oldPos == -1) {//第一次点击按照正常逻辑走
                    if (!testList.get(position-1).isChecked()) {//判断被点击的项是否被选中(没有被选中)
                        testList.get(position-1).setChecked(true);
                        oldPos = position-1;
                    } else {
                        testList.get(position-1).setChecked(false);
                    }
                    mAdp.setData(testList);
                }else {
                    if (oldPos != position-1) {//上次保存的位置与本次不同
                        if (testList.get(oldPos).isChecked()){
                            testList.get(oldPos).setChecked(false);
                            testList.get(position-1).setChecked(true);
                            oldPos = position-1;
                        }
                    }else {
                        testList.get(position-1).setChecked(false);
                        oldPos = -1;
                    }
                    mAdp.setData(testList);
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    @OnClick({R.id.btnSub})
    void todo(View v){
        switch (v.getId()){
            case R.id.btnSub:
                if (isAvalible()){
                    showProgress("正在提交，请稍后。。。");
                    mPresenter.subErrorMsg(companyId,subList.get(0).getId(),content,phone,0);
                }
                break;
        }
    }

    //判断是否可以提交纠错信息
    private boolean isAvalible(){
        subList=new ArrayList<>();
        for (int i=0;i<testList.size();i++){
            if (testList.get(i).isChecked()){
                subList.add(testList.get(i));
            }
        }
        if (subList.size()==0){
            toast("请选择信息有误的部分！");
            return false;
        }
        content = etContent.getText().toString().trim();
        phone = etPhone.getText().toString().trim();
        if (TextUtils.isEmpty(content)){
            toast("请输入您的内容！");
            etContent.setFocusable(true);
            return false;
        }
        if (TextUtils.isEmpty(phone)){
            toast("请输入您的手机号码！");
            etPhone.setFocusable(true);
            return false;
        }
        if (!EchinfoUtils.checkCellPhone(phone)){
            toast("请输入正确的手机号码！");
            etPhone.setFocusable(true);
            etPhone.setSelection(phone.length());
            return false;
        }
        return true;
    }
    @Override
    public void getErrorListSuccess(List<ErrorBean> mDatas) {
        testList=mDatas;
        mAdp.setData(testList);
    }

    @Override
    public void getErrorListFail(int status, String errorMsg) {
        toast(errorMsg);
    }

    @Override
    public void getErrorNoData() {

    }

    @Override
    public void subErrorSuccess() {
        hideProgress();
        finish();
    }

    @Override
    public void subErrorFail(int status, String errorMsg) {
        toast(errorMsg);
    }

}
