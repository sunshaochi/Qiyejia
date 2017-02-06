package com.boyuanitsm.tools.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boyuanitsm.tools.callback.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BaseRecyclerAdapter<p>
 * Fuction: RecyclerView通用适配器<p>
 * CreateDate:2016/2/16 22:47<p>
 * UpdateUser:<p>
 * UpdateDate:<p>
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {


    protected List<T> mData;
    protected Context mContext;
    protected boolean mUseAnimation;
    protected LayoutInflater mInflater;
    protected OnItemClickListener mClickListener;

    private RecyclerView.LayoutManager mLayoutManager;

    private int mLastPosition = -1;

    public BaseRecyclerAdapter(Context context, List<T> data) {
        this(context, data, true);
    }

    public BaseRecyclerAdapter(Context context, List<T> data, boolean useAnimation) {
        this(context, data, useAnimation, null);
    }

    public BaseRecyclerAdapter(Context context, List<T> data, boolean useAnimation, RecyclerView.LayoutManager layoutManager) {
        mContext = context;
        mUseAnimation = useAnimation;
        mLayoutManager = layoutManager;
        mData = data == null ? new ArrayList<T>() : data;
        mInflater = LayoutInflater.from(context);
    }


    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final BaseRecyclerViewHolder holder = new BaseRecyclerViewHolder(mContext,
                    mInflater.inflate(getItemLayoutId(viewType), parent, false));
            if (mClickListener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mClickListener.onItemClick(v, holder.getLayoutPosition());
                    }
                });
            }
            return holder;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
            bindData(holder, position, mData.get(position));
//            if (mUseAnimation) {
//                setAnimation(holder.itemView, position);
//            }
    }

//    protected void setAnimation(View viewToAnimate, int position) {
//        if (position > mLastPosition) {
//            Animation animation = AnimationUtils
//                    .loadAnimation(viewToAnimate.getContext(), R.anim.item_bottom_in);
//            viewToAnimate.startAnimation(animation);
//            mLastPosition = position;
//        }
//    }

//    @Override
//    public void onViewDetachedFromWindow(BaseRecyclerViewHolder holder) {
//        super.onViewDetachedFromWindow(holder);
//        if (mUseAnimation && holder.itemView.getAnimation() != null && holder.itemView
//                .getAnimation().hasStarted()) {
//            holder.itemView.clearAnimation();
//        }
//    }

    public void add(int pos, T item) {
        mData.add(pos, item);
        notifyItemInserted(pos);
    }

    public void delete(int pos) {
        mData.remove(pos);
        notifyItemRemoved(pos);
    }

    public void addMoreData(List<T> data) {
        int startPos = mData.size();
        mData.addAll(data);
        notifyItemRangeInserted(startPos, data.size());
    }

    public List<T> getData() {
        return mData;
    }

    public void setData(List<T> data) {
        mData = data;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        // KLog.e("插入: "+i);
        return mData != null ? mData.size()  : 0;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }

    public abstract int getItemLayoutId(int viewType);

    public abstract void bindData(BaseRecyclerViewHolder holder, int position, T item);



}
