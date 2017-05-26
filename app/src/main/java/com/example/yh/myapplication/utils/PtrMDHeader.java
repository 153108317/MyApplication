package com.example.yh.myapplication.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/23 11:37
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class PtrMDHeader extends View implements PtrUIHandler {
    private final Paint paint = new Paint();
    private final RectF ovalLoading = new RectF();
    private final RectF ovalBlueBack = new RectF();

    private int mWidth;
    private int mHeight;
    private int centerX;
    private int centerY;
    private int mLoadingStrokeWidth;
    private int radiusBlue;
    private int radiusWhite;

    public PtrMDHeader(Context context) {
        this(context, null);
    }

    public PtrMDHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final float scale = getResources().getDisplayMetrics().density;
        // 先拿60dip的高度耍耍
        int heightSize = MeasureSpec.makeMeasureSpec((int) (60 * scale + 0.5f), View.MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightSize);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w; // PtrMDHeader的宽度
        mHeight = h; // PtrMDHeader的高度
        centerX = mWidth / 2; // X轴中心点
        centerY = mHeight / 2; // Y轴中心点

        radiusBlue = mHeight / 4; // 蓝色背景半径
        radiusWhite = radiusBlue / 2; // 白色Loading半径
        mLoadingStrokeWidth = radiusBlue / 8; // 白色Loading尺寸

        /* 白色Loading所在矩形区域 */
        ovalLoading.left = centerX - radiusWhite;
        ovalLoading.right = centerX + radiusWhite;
        ovalLoading.top = centerY - radiusWhite;
        ovalLoading.bottom = centerY + radiusWhite;

        /** 蓝色扇形所在矩形区域*/
        ovalBlueBack.left = centerX - radiusBlue;
        ovalBlueBack.right = centerX + radiusBlue;
        ovalBlueBack.top = centerY - radiusBlue;
        ovalBlueBack.bottom = centerY + radiusBlue;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0xffcccccc);

        paint.setAntiAlias(true);
        // 蓝色背景
        paint.setColor(0xFF5AB1E8);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(centerX, centerY, radiusBlue, paint);
        // 白色loading
        paint.setColor(0xFFFFFFFF);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(mLoadingStrokeWidth);
        canvas.drawArc(ovalLoading, 90, 270, false, paint);
    }

    @Override
    public void onUIReset(PtrFrameLayout ptrFrameLayout) {
        Log.d("PtrMDHeader"+ "onUIReset");
    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
        Log.d("PtrMDHeader"+ "onUIRefreshPrepare");
    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
        Log.d("PtrMDHeader"+ "onUIRefreshBegin");
    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
        Log.d("PtrMDHeader"+ "onUIRefreshComplete");
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean b, byte b1, PtrIndicator ptrIndicator) {
        Log.d("PtrMDHeader"+ "onUIPositionChange b:" + b + ", b1:" + b1 + "percent:" + ptrIndicator.getCurrentPercent());
    }
}
