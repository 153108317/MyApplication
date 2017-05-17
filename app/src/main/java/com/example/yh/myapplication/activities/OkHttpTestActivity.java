package com.example.yh.myapplication.activities;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.api.OkHttpGetDataApi;
import com.example.yh.myapplication.base.BasicActivity;
import com.example.yh.myapplication.entities.TestBean;
import com.example.yh.myapplication.entities.UserBean;
import com.example.yh.myapplication.network.HttpUrls;
import com.example.yh.myapplication.views.IView;

import butterknife.BindView;
import okhttp3.FormBody;
import okhttp3.RequestBody;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/08 20:01
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class OkHttpTestActivity extends BasicActivity implements IView<TestBean> {
    private OkHttpGetDataApi mOkHttpGetDataApi;
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
    protected void addDataAgain() {
        if (mOkHttpGetDataApi == null)
            mOkHttpGetDataApi = new OkHttpGetDataApi(this);
        mOkHttpGetDataApi.getData(HttpUrls.WEATHURL, 0, this);
        RequestBody formBody = new FormBody.Builder()
                .add("loginCode", "13452582341")
                .add("password", "12345678")
                .add("nationCode", "86")
                .add("app", "APP.Buyer.Android")
                .add("appVersion", "V2.3.6")
                .add("appTerminal", "APP.Buyer.Android")

                .build();
        String API_URL_DEV = "http://test3.d2cmall.com";
        String PASSWORD_LOGIN_URL = API_URL_DEV + "/v2/api/member/login";
        mOkHttpGetDataApi.getData(PASSWORD_LOGIN_URL, formBody, 0, new IView<UserBean>() {
            @Override
            public void getBean(UserBean v) {

            }
        });
    }

    private TestBean mTestBean;

    @Override
    public void getBean(TestBean v) {
        if (mHandler != null) {
            mHandler.sendEmptyMessage(1);
            mTestBean = v;
        }


    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mLabel.setText(mTestBean.getWeatherinfo().toString());
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler = null;
    }
}
