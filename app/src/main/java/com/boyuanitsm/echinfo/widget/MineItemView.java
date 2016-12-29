package com.boyuanitsm.echinfo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.boyuanitsm.echinfo.R;


/**
 * 我的界面item通用view
 * Created by Yang on 2016/11/6 0006.
 */
public class MineItemView extends LinearLayout {
    private TextView tvLeft;//左边文字
    private ImageView ivLeft;//左边图片
    private TextView tvRight;//右边文字
    private ImageView ivArrow;//右边按钮

    private int LeftTextColor;//左边文字颜色
    private Drawable LeftImgRes;//左边图片资源
    private String LeftText;//左边文字描述
    private float LeftTextSize;//左边文字大小 默认16

    private boolean isShowArrowRight;//是否显示右边箭头
    private boolean isShowLeftImg;//是否显示左边图片

    private boolean isShowTextRight;//是否显示右边文字
    private int RightTextColor;////右边文字颜色
    private String RightText;////右边文字文本
    private float RightTextSize;////右边文字大小

    public MineItemView(Context context) {
        super(context);
    }

    public MineItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            init();
            TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.MineItemView);
            LeftTextColor = mTypedArray.getColor(R.styleable.MineItemView_leftTextColor, Color.parseColor("#333333"));
            LeftText = mTypedArray.getString(R.styleable.MineItemView_leftText);
            LeftTextSize = mTypedArray.getDimensionPixelSize(R.styleable.MineItemView_leftTextSize, 16);
            isShowArrowRight = mTypedArray.getBoolean(R.styleable.MineItemView_isShowArrowRight, true);
            isShowTextRight = mTypedArray.getBoolean(R.styleable.MineItemView_isShowTextRight, true);
            RightText = mTypedArray.getString(R.styleable.MineItemView_rightText);
            RightTextColor = mTypedArray.getColor(R.styleable.MineItemView_rightTextColor, Color.parseColor("#999999"));
            RightTextSize = mTypedArray.getDimensionPixelSize(R.styleable.MineItemView_rightTextSize, 14);
            LeftImgRes = mTypedArray.getDrawable(R.styleable.MineItemView_leftImg);
            isShowLeftImg = mTypedArray.getBoolean(R.styleable.MineItemView_isShowLeftImg, true);
            mTypedArray.recycle();
            initData();
        }
    }

    private void init() {
        View view = View.inflate(getContext(), R.layout.item_mineview, this);
        tvLeft = (TextView) view.findViewById(R.id.tvLeft);
        tvRight = (TextView) view.findViewById(R.id.tvRight);
        ivArrow = (ImageView) view.findViewById(R.id.ivArrow);
        ivLeft = (ImageView) view.findViewById(R.id.ivLeft);
    }


    /**
     * 设置左边字体的大小
     *
     * @param desTextSize 单位是sp
     */
    public void setLeftTextSize(float desTextSize) {
        tvLeft.setTextSize(TypedValue.COMPLEX_UNIT_PX, desTextSize);
        this.LeftTextSize = desTextSize;
    }

    private void setLeftImg(Drawable leftImgRes) {
        if(leftImgRes!=null){
            ivLeft.setBackgroundDrawable(leftImgRes);
            this.LeftImgRes = leftImgRes;
        }
    }

    /**
     * 设置左边描述信息
     *
     * @param desText
     */
    public void setLeftText(String desText) {
        if (desText != null) {
            tvLeft.setText(desText);
            this.LeftText = desText;
        }
    }

    /**
     * 设置左边描述字体颜色
     *
     * @param desTextColor
     */
    public void setLeftTextColor(int desTextColor) {
        tvLeft.setTextColor(desTextColor);
        this.LeftTextColor = desTextColor;
    }

    /**
     * 设置右边文字
     *
     * @param notesText
     */
    public void setRightText(String notesText) {
        if (notesText != null) {
            tvRight.setText(notesText);
            this.RightText = notesText;
        }
    }

    /**
     * 设置右边文字颜色
     *
     * @param notesTextColor
     */
    public void setRightTextColor(int notesTextColor) {
        tvRight.setTextColor(notesTextColor);
        this.RightTextColor = notesTextColor;
    }

    /**
     * 设置字体大小
     *
     * @param notesTextSize
     */
    public void setRightTextSize(float notesTextSize) {
        tvRight.setTextSize(TypedValue.COMPLEX_UNIT_PX, notesTextSize);
        this.RightTextSize = notesTextSize;
    }

    /**
     * 是否显示右边文字
     *
     * @param isShowTextNotes
     */
    public void setIsShowRightText(boolean isShowTextNotes) {
        if (isShowTextNotes) {
            tvRight.setVisibility(View.VISIBLE);
        } else {
            tvRight.setVisibility(View.GONE);
        }
        this.isShowTextRight = isShowTextNotes;
    }

    /**
     * 是否显示右边箭头
     *
     * @param isShowArrowRight
     */
    public void setIsShowArrow(boolean isShowArrowRight) {
        if (isShowArrowRight) {
            ivArrow.setVisibility(View.VISIBLE);
        } else {
            ivArrow.setVisibility(View.GONE);
        }
        this.isShowArrowRight = isShowArrowRight;
    }

    private void setIsShowLeftImg(boolean isShowLeftImg) {
        if (isShowLeftImg) {
            ivLeft.setVisibility(View.VISIBLE);
        } else {
            ivLeft.setVisibility(View.GONE);
        }
        this.isShowLeftImg = isShowLeftImg;
    }

    /**
     * 初始化数据参数
     */
    private void initData() {
        setLeftTextColor(LeftTextColor);
        setLeftText(LeftText);
        setLeftTextSize(LeftTextSize);
        setRightText(RightText);
        setRightTextColor(RightTextColor);
        setRightTextSize(RightTextSize);
        setIsShowRightText(isShowTextRight);
        setIsShowArrow(isShowArrowRight);
        setLeftImg(LeftImgRes);
        setIsShowLeftImg(isShowLeftImg);
    }

}
