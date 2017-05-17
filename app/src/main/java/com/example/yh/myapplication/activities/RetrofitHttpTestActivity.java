package com.example.yh.myapplication.activities;

import android.widget.TextView;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.api.RetrofitTestApi;
import com.example.yh.myapplication.base.BasicActivity;
import com.example.yh.myapplication.entities.TestBean;
import com.example.yh.myapplication.views.IView;

import butterknife.BindView;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/09 22:37
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class RetrofitHttpTestActivity extends BasicActivity implements IView <TestBean>{
    private RetrofitTestApi mRetrofitTestApi;
    @Override
    protected void addDataAgain() {
        if(mRetrofitTestApi==null){

            mRetrofitTestApi=new RetrofitTestApi(getApplicationContext());
            String API_URL_DEV = "http://test3.d2cmall.com";
            String PASSWORD_LOGIN_URL = API_URL_DEV + "/v2/api/member/login";
             String weatherUrl= "http://www.weather.com.cn";
            mRetrofitTestApi.getData(weatherUrl,this);
        }

    }

    @BindView(R.id.mlabel)
    TextView mLabel;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_okhttptest;
    }

    @Override
    protected void initView() {
        addDataAgain();
    }


    @Override
    public void getBean(TestBean v) {
        mLabel.setText(v.getWeatherinfo().toString());
    }
}
