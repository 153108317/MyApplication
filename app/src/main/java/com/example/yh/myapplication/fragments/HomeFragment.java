package com.example.yh.myapplication.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.activities.PagerSlidingTabStripActivity;
import com.example.yh.myapplication.base.BasicFragment;
import com.example.yh.myapplication.network.HttpUrls;
import com.example.yh.myapplication.presenter.ShopAd;
import com.example.yh.myapplication.views.MyUser;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yh on 2017/3/29.
 */

public class HomeFragment extends BasicFragment implements MyUser{
    @BindView(R.id.textview_home)TextView label;
    @BindView(R.id.textview_home1)TextView label1;
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

    @OnClick({R.id.tv_PagerSlidingTabStrip})
    public void mClick(View view){
        switch (view.getId()){
            case R.id.tv_PagerSlidingTabStrip:
                getBasicActivity().openActivity(PagerSlidingTabStripActivity.class);
                break;
        }
    }

    @Override
    public void getUser(String user) {
        if(user!=null)label.setText(user);
    }
}
