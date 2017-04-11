package com.example.yh.myapplication.base;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/08 09:57
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class RecylerViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;

    public RecylerViewHolder(View view) {
        super(view);
        mViews = new SparseArray<>();
        itemView.setTag(this);
    }

    private void addChildView(int viewId) {
        if (mViews.get(viewId) == null) {
            mViews.put(viewId, itemView.findViewById(viewId));
        }
    }

    public TextView getTextView(int viewId) {
        addChildView(viewId);
        return (TextView) mViews.get(viewId);
    }

    public void setText(int textId, int stringId) {
        addChildView(textId);
        ((TextView) mViews.get(textId)).setText(stringId);
    }

    public void setText(int textId, String content) {
        addChildView(textId);
        if (content != null)
            ((TextView) mViews.get(textId)).setText(content);
    }

    public void setImage(int imageViewId, int resId) {
        ImageView imageView = getImageView(imageViewId);
        imageView.setImageResource(resId);
    }

    private ImageView getImageView(int imageViewId) {
        addChildView(imageViewId);
        return (ImageView) mViews.get(imageViewId);
    }

    public void setImage(int imageViewId, Bitmap bitmap) {
        if (bitmap != null)
            getImageView(imageViewId).setImageBitmap(bitmap);
    }


    public View getView(int viewId) {
        addChildView(viewId);
        return mViews.get(viewId);
    }

    public View getRootView() {
        return itemView;
    }

}
