package com.example.yh.myapplication.fragments;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yh.myapplication.MyApplication;
import com.example.yh.myapplication.R;
import com.example.yh.myapplication.activities.PagerSlidingTabStripActivity;
import com.example.yh.myapplication.base.BasicFragment;
import com.example.yh.myapplication.network.HttpUrls;
import com.example.yh.myapplication.presenter.ShopAd;
import com.example.yh.myapplication.utils.Log;
import com.example.yh.myapplication.utils.Utils;
import com.example.yh.myapplication.views.MyUser;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yh on 2017/3/29.
 */

public class HomeFragment extends BasicFragment implements MyUser{
    @BindView(R.id.textview_home)TextView label;
    @BindView(R.id.textview_home1)TextView label1;
    @BindView(R.id.scan)Button scan;
    private final int SCANREQUESTCODE=10;
   // private War
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShopAd shopAd=new ShopAd(this);
        shopAd.getData(HttpUrls.INDEXINFO);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void  initView() {
        String str=String.format(getResources().getString(R.string.stylestring),"我是添加的文字","我也是");
        label.setText(Html.fromHtml(str));
        str=String.format(getResources().getString(R.string.label_topical_name),"这是为什么");
        label1.setText(Html.fromHtml(str));
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick({R.id.tv_PagerSlidingTabStrip,R.id.scan})
    public void mClick(View view){
        switch (view.getId()){
            case R.id.tv_PagerSlidingTabStrip:
                getBasicActivity().openActivity(PagerSlidingTabStripActivity.class);
                break;
            case R.id.scan:

                  if(getBasicActivity().permissions(Manifest.permission.CAMERA)){
                      Intent intent=new Intent(MyApplication.mApplicationContext,CaptureActivity.class);
                      startActivityForResult(intent,SCANREQUESTCODE);
                  }

             //   getBasicActivity().openActivity(CaptureActivity.class,SCANREQUESTCODE,null);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){

            case SCANREQUESTCODE:
                //处理扫描结果（在界面上显示）
                if (null != data) {
                    Bundle bundle = data.getExtras();
                    if (bundle == null) {
                        return;
                    }
                    if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                        String result = bundle.getString(CodeUtils.RESULT_STRING);
                        Log.e(result);
                        Utils.Toast("解析结果："+result);
                    } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                        Utils.Toast( "解析二维码失败");
                    }
                }
                break;
        }
    }

    @Override
    public void getUser(String user) {
        if(user!=null)label.setText(user);
    }
}
