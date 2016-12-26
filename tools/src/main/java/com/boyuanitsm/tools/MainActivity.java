package com.boyuanitsm.tools;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;

import com.boyuanitsm.tools.base.BaseRecyclerAdapter;
import com.boyuanitsm.tools.base.BaseRecyclerViewHolder;
import com.boyuanitsm.tools.view.xrecyclerview.ProgressStyle;
import com.boyuanitsm.tools.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private BaseRecyclerAdapter<String> adapter;
    private XRecyclerView rcv;
    private List<String> datas=new ArrayList<>();
    private int refreshTime = 0;
    private int times = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv= (XRecyclerView) findViewById(R.id.rcv);
        for(int i=0;i<30;i++){
            datas.add("爱是非得失两回事"+i);
        }
        adapter=new BaseRecyclerAdapter<String>(this,datas) {
            @Override
            public int getItemLayoutId(int viewType) {
                return R.layout.lv_item;
            }

            @Override
            public void bindData(BaseRecyclerViewHolder holder, int position, String item) {
                 holder.getTextView(R.id.tvItem).setText(item);
            }
        };

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        rcv.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        rcv.setArrowImageView(R.drawable.iconfont_downgrey);
        rcv.setLoadingMoreEnabled(true);
        rcv.setLayoutManager(linearLayoutManager);
        rcv.setAdapter(adapter);

        rcv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshTime++;
                times = 0;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        datas.clear();
                        for (int i = 0; i < 15; i++) {
                            datas.add("item" + i + "after " + refreshTime + " times of refresh");
                        }
                        adapter.setData(datas);
                        rcv.refreshComplete();
                    }

                }, 1000);            //refresh data here
            }

            @Override
            public void onLoadMore() {
                if (times < 2) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            rcv.loadMoreComplete();
                            for (int i = 0; i < 15; i++) {
                                datas.add("item" + (i + datas.size()));
                            }
                            adapter.setData(datas);
                            rcv.refreshComplete();
                        }
                    }, 1000);
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {

                            adapter.notifyDataSetChanged();
                            rcv.loadMoreComplete();
                        }
                    }, 1000);
                }
                times++;
            }
        });
        rcv.setRefreshing(true);

    }


}
