package com.example.yh.myapplication.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicFragment;
import com.example.yh.myapplication.presenter.PresenterTestBean;
import com.example.yh.myapplication.result.TestBean;
import com.example.yh.myapplication.views.IView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yh on 2017/3/29.
 */

public class MyFragment extends BasicFragment implements IView<TestBean>{
    @BindView(R.id.textview_my)TextView label;
    @BindView(R.id.imageview_my)ImageView imageView;
    private String imageUrl="http://www.baidu.com/img/bdlogo.png";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=null;

        if(v==null){
            v=inflater.inflate(R.layout.fragment_my,container,false);
        }
        ButterKnife.bind(this,v);
      return v;
       // return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        PresenterTestBean presenterTestBean=new PresenterTestBean(this);
        String url="http://www.weather.com.cn/data/cityinfo/101010100.html";
        presenterTestBean.getData(url);
        presenterTestBean.setImageView(new IView<Bitmap>() {
            @Override
            public void getBean(Bitmap v) {
                imageView.setImageBitmap(v);

            }
        });
        presenterTestBean.getBitmap(imageUrl);
    }

    @Override
    public void getBean(TestBean v) {
        label.setText(""+ v.getWeatherinfo().toString());
    }
}
