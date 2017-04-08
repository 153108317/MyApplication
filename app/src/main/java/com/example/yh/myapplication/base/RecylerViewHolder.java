package com.example.yh.myapplication.base;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yh.myapplication.MyApplication;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/08 09:57
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class RecylerViewHolder extends RecyclerView.ViewHolder {
    public RecylerViewHolder(View view) {
        super(view);
    }
    private int mLayoutId;
    private View mView;
    private int mPosition;
    private SparseArray<View> mViews;

    private RecylerViewHolder(int layoutId, View view, int position) {
        super(view);
        mLayoutId = layoutId;
        mView = View.inflate(MyApplication.mApplicationContext, layoutId, null);
        mViews = new SparseArray<>();
        mView.setTag(this);
        mPosition = position;
    }

    public void setText(int textId, int stringId) {
        TextView textView = (TextView) mViews.get(textId);
        if (textView == null) {
            textView = (TextView) mView.findViewById(textId);
            mViews.put(textId, textView);

        }
        textView.setText(stringId);
    }

    public void setText(int textId, String content) {
        TextView textView = (TextView) mViews.get(textId);
        if (textView == null) {
            textView = (TextView) mView.findViewById(textId);
            mViews.put(textId, textView);

        }

        if (content != null)
            textView.setText(content);

    }

    public void setImage(int imageViewId, int resId) {
        ImageView imageView = getImageView(imageViewId);
        imageView.setImageResource(resId);
    }

    private ImageView getImageView(int imageViewId) {
        ImageView imageView = (ImageView) mViews.get(imageViewId);
        if (imageView == null) {
            imageView = (ImageView) mView.findViewById(imageViewId);
            mViews.put(imageViewId, imageView);
        }
        return imageView;
    }

    public void setImage(int imageViewId, Bitmap bitmap) {
        ImageView imageView = getImageView(imageViewId);
        if(bitmap!=null)
            imageView.setImageBitmap(bitmap);
    }


    public View getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return view;
    }

    public View getRootView() {
        return mView;
    }

}
