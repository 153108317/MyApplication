package com.example.yh.myapplication.api;

import com.android.volley.VolleyError;
import com.example.yh.myapplication.interfaces.HttpCallBack;
import com.example.yh.myapplication.network.HttpTask;
import com.example.yh.myapplication.result.PictureResult;
import com.example.yh.myapplication.views.IView;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/11 16:13
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class GetPictureApi {

    public static void getPictureBeans(String url,int type, final IView iView){
        HttpTask task=new HttpTask(PictureResult.class);
        task.setHttpCallBack(new HttpCallBack<PictureResult>() {

            @Override
            public void onSuccess(PictureResult result, int typeId) {
                if(iView!=null)
                    iView.getBean(result);
            }

            @Override
            public void onError(VolleyError volleyError) {

            }
        });
        task.getJSONObjectResult(url);
    }

}
