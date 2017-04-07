package com.example.yh.myapplication.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicFragment;
import com.example.yh.myapplication.network.HttpUrls;
import com.example.yh.myapplication.presenter.ShopAd;
import com.example.yh.myapplication.views.MyUser;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yh on 2017/3/29.
 */

public class HomeFragment extends BasicFragment implements MyUser{
    @BindView(R.id.textview_home)TextView label;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View v=null;
        if (null==v){
            v=inflater.inflate(R.layout.fragment_home,container,false) ;
        }
        ButterKnife.bind(this,v);
        return v;// super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void getUser(String user) {
        if(user!=null)label.setText(user);
    }
}
