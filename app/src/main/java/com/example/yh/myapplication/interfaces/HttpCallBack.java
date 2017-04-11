package com.example.yh.myapplication.interfaces;

import com.android.volley.VolleyError;
import com.example.yh.myapplication.base.BasicResult;

/**
 * Created by yh on 2017/3/31.
 */

public interface HttpCallBack<T extends BasicResult> {
    /***
     * @param typeId 默认0*/
    void onSuccess(
            T result,int typeId
    );
    void onError(VolleyError volleyError);
}
