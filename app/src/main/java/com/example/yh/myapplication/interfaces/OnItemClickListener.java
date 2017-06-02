package com.example.yh.myapplication.interfaces;

import android.view.View;

public interface OnItemClickListener<T> {
    /**
     * item点击回调
     *
     * @param view
     * @param position
     */
    void onItemClick(View view, int position);

    /**
     * 删除按钮回调
     *
     * @param position
     * @param type 0 ,第一个按钮，1第二个按钮
     */
    void onDeleteClick(int position,int type) throws Exception;
}
