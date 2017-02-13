package com.boyuanitsm.echinfo.module.home.presenter.searchPresenter;

import com.boyuanitsm.echinfo.base.BasePresenterImpl;
import com.boyuanitsm.echinfo.bean.DateBean;
import com.boyuanitsm.echinfo.bean.JudgementBean;
import com.boyuanitsm.echinfo.bean.ResultBean;
import com.boyuanitsm.echinfo.callback.ResultCallback;
import com.boyuanitsm.echinfo.module.home.model.searchModel.ISearchJudgmentModel;
import com.boyuanitsm.echinfo.module.home.model.searchModel.SearchJudgmentModelImpl;
import com.boyuanitsm.echinfo.module.home.view.searchView.ISearchJudgmentView;

import java.util.List;

/**
 * 查判决
 * Q164454216
 * Created by xiaoke on 2017/2/13.
 */

public class SearchJudgmentPresenterImpl extends BasePresenterImpl<ISearchJudgmentView> implements ISearchJudgmentPresenter {
    private ISearchJudgmentModel judgmentModel;
    public SearchJudgmentPresenterImpl(ISearchJudgmentView view) {
        super(view);
        mView=view;
        judgmentModel=new SearchJudgmentModelImpl();
    }

    @Override
    public void getJudgmentInfo(String name, int page, int rows) {
        judgmentModel.findJudgmentInfo(name, page, rows, new ResultCallback<ResultBean<DateBean<JudgementBean>>>() {
            @Override
            public void onError(int status, String errorMsg) {
                mView.findJudgmentInfoFaild(status,errorMsg);
            }

            @Override
            public void onResponse(ResultBean<DateBean<JudgementBean>> response) {
                 List<JudgementBean> list = response.getData().getRows();
                    mView.findJudgmentTotal(response.getData().getTatal());
                if (list!=null&&list.size()>0){
                    mView.findJudgmentInfoSucess(list);
                }else {
                    mView.findJudgmentNoData();
                }
            }
        });
    }

    @Override
    public void getJudgmentType(String type) {
           judgmentModel.getJudgmentType(type, new ResultCallback<ResultBean<List<JudgementBean>>>() {
               @Override
               public void onError(int status, String errorMsg) {
                   mView.getJudgmentTypeFaild(status,errorMsg);
               }

               @Override
               public void onResponse(ResultBean<List<JudgementBean>> response) {
                mView.getJudgmentTypeSucess(response.getData());
               }
           });
    }

    @Override
    public void getHotHistory(String type) {
       judgmentModel.getHotHistory(type, new ResultCallback<ResultBean<List<JudgementBean>>>() {
           @Override
           public void onError(int status, String errorMsg) {
                mView.getHotHistoryFaild(status,errorMsg);
           }

           @Override
           public void onResponse(ResultBean<List<JudgementBean>> response) {
            mView.getHotHistorySucess(response.getData());
           }
       });
    }
}
