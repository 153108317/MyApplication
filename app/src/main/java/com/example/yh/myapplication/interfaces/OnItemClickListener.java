package com.example.yh.myapplication.interfaces;

import android.view.View;

public interface OnItemClickListener<T> {
    /**
     * item点击回调
     *
     * @param view
     * @param position
     */
    void onItemClick(View view, int position,T t);

    /**
     * 删除按钮回调
     *
     * @param position
     */
    void onDeleteClick(int position,T t);
}
