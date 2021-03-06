package com.boyuanitsm.echinfo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;
import com.boyuanitsm.echinfo.bean.EditRecordBean;

import java.util.List;

/**
 * 工商信息界面变更记录适配器
 * Created by Yang on 2017/1/6 0006.
 */
public class BusinessThreeAdp extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
//    private BusinessThreeItemAdp itemAdp;

    private List<EditRecordBean> datas;

    public BusinessThreeAdp(Context context,List<EditRecordBean> datas) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.datas=datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.mlv_businessthree_item, null);
            holder.view_line = view.findViewById(R.id.view_line);
//            holder.mlv = (MyListView) view.findViewById(R.id.mlv);
            holder.tv_time= (TextView) view.findViewById(R.id.tv_time);
            holder.tv_changeTitle= (TextView) view.findViewById(R.id.tv_changeTitle);
            holder.tv_changeBefore= (TextView) view.findViewById(R.id.tv_changeBefore);
            holder.tv_changeAfter= (TextView) view.findViewById(R.id.tv_changeAfter);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if (i == 0) {
            holder.view_line.setVisibility(View.GONE);
        } else {
            holder.view_line.setVisibility(View.VISIBLE);
        }
        holder.tv_time.setText(datas.get(i).getEditTime());
        holder.tv_changeTitle.setText(datas.get(i).getEditType());
        holder.tv_changeBefore.setText(datas.get(i).getBeforeEdit());
        holder.tv_changeAfter.setText(datas.get(i).getAfterEdit());

//        itemAdp = new BusinessThreeItemAdp(context, i);
//        holder.mlv.setSelector(new ColorDrawable(Color.TRANSPARENT));
//        holder.mlv.setAdapter(itemAdp);
        return view;
    }

    private class ViewHolder {
        View view_line;
        TextView tv_time,tv_changeTitle,tv_changeBefore,tv_changeAfter;
    }
}
