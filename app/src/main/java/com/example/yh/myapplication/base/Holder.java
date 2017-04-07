package com.example.yh.myapplication.base;


import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yh.myapplication.MyApplication;
import com.example.yh.myapplication.utils.Log;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/06 16:17
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class Holder {
    private int mLayoutId;
    private View mView;
    private int mPosition;
    private SparseArray<View> mViews;

    private Holder(int layoutId, View view, int position) {
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

    public static Holder getInstance(
            int layoutId, View view, int position
    ) {
        Holder holder = null;
        if (view == null) {
            holder = new Holder(layoutId, view, position);
        } else {
            holder = (Holder) view.getTag();
            holder.mPosition = position;
        }
        return holder;
    }
}
