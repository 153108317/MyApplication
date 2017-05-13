package com.example.yh.myapplication.api;

import android.content.Context;

import com.example.yh.myapplication.entities.TestBean;
import com.example.yh.myapplication.entities.UserBean;
import com.example.yh.myapplication.network.retrofithttptest.RetrofitHttpTask;
import com.example.yh.myapplication.utils.Log;
import com.example.yh.myapplication.views.IView;

import java.util.HashMap;
import java.util.Map;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/09 22:49
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class RetrofitTestApi {
    public RetrofitTestApi(Context context){

    }
    //http://www.weather.com.cn/data/cityinfo/101010100.html
    private String weatherUrl= "http://www.weather.com.cn/data/cityinfo/";
    public void getData(String url,final IView<TestBean> iView){
        RetrofitHttpTask retrofitHttpTask=new RetrofitHttpTask(TestBean.class);
        retrofitHttpTask.getData(url,iView);
        RetrofitHttpTask retrofitHttpTask1=new RetrofitHttpTask(UserBean.class);
        Map<String,String> param=new HashMap<>();
        param.put("loginCode", "13452582341");
        param .put("password", "12345678");
        param .put("nationCode", "86");
        String API_URL_DEV = "http://test3.d2cmall.com/";
        String PASSWORD_LOGIN_URL = API_URL_DEV + "v2/api/member/login/";
        retrofitHttpTask1.post(PASSWORD_LOGIN_URL,"v2/api/member/login", param,new IView<UserBean>() {
            @Override
            public void getBean(UserBean v) {
                Log.e(v.getDataEntity().getMember().getNickname());
            }
        });
    }

}
