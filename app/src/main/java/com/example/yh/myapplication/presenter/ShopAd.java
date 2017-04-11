package com.example.yh.myapplication.presenter;

import com.android.volley.VolleyError;
import com.example.yh.myapplication.interfaces.HttpCallBack;
import com.example.yh.myapplication.network.HttpTask;
import com.example.yh.myapplication.entities.TestBean;
import com.example.yh.myapplication.views.MyUser;

/**
 * Created by yh on 2017/3/31.
 */

public class ShopAd implements HttpCallBack<TestBean>{
    String s;
    private HttpTask mHttpTask;
    private MyUser myUser;
    public ShopAd(MyUser myUser){
        this.myUser= myUser;
    }
    public void getData(String url){
        if(mHttpTask==null){
            mHttpTask=new HttpTask(String.class);
            mHttpTask.setHttpCallBack(this);
            mHttpTask.getStringRequest(url);
        }
    }


    @Override
    public void onSuccess(TestBean result, int typeId) {
        if(myUser!=null)
            myUser.getUser(result.toString());
    }

    @Override
    public void onError(VolleyError volleyError) {

    }
}
