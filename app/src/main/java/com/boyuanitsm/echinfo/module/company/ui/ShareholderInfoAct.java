package com.boyuanitsm.echinfo.module.company.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.base.BaseAct;
import com.boyuanitsm.echinfo.bean.StockMsgBean;
import com.boyuanitsm.tools.base.BaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 股东信息
 * Created by Yang on 2017/1/4 0004.
 */
public class ShareholderInfoAct extends BaseAct {
//    @BindView(R.id.rcv)
//    XRecyclerView rcv;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_czsj)
    TextView tvCzsj;//出资时间
    @BindView(R.id.tv_rjcz)
    TextView tvRjcz;//认缴出资
    @BindView(R.id.tv_sjsj)
    TextView tvSjsj;//实缴时间
    @BindView(R.id.tv_sjcz)
    TextView tvSjcz;//实缴出资
    @BindView(R.id.tv_fs)
    TextView tvFs;//出资方式
    public static final String GUDONGINFO="holderInfo";
    private BaseRecyclerAdapter<String> mAdp;
    private List<String> testList = new ArrayList<>();
    private StockMsgBean stockMsgBean;
    @Override
    public int getLayout() {
        return R.layout.rcv_customview;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setTopTitle("股东信息");
        setRightBtn("纠错", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ErrorCorrectionAct.class);
            }
        });
        initFrg();
    }

    private void initFrg() {
        stockMsgBean=  getIntent().getParcelableExtra(GUDONGINFO);
        tvName.setText(stockMsgBean.getLegalPerson());
        tvCzsj.setText(stockMsgBean.getEstablishDate());
        tvSjsj.setText(stockMsgBean.getRealSubcribeTime());
        tvSjcz.setText(stockMsgBean.getRealSubcribe());
        tvFs.setText(stockMsgBean.getSubcribeType());
        tvRjcz.setText(stockMsgBean.getSubcribe());
//        testList = EchinfoUtils.getTestDatas(3);
//        rcv = EchinfoUtils.getLinearRecyclerView(rcv, getApplicationContext(), true);
//        mAdp = new BaseRecyclerAdapter<String>(getApplicationContext(), testList) {
//            @Override
//            public int getItemLayoutId(int viewType) {
//                return R.layout.rcv_shareholderinfo_item;
//            }
//
//            @Override
//            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {
//
//            }
//        };
//        rcv.setAdapter(mAdp);
    }

}
