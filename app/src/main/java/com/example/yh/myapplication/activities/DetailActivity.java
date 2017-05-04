package com.example.yh.myapplication.activities;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yh on 2017/5/2.
 */

public class DetailActivity extends BasicActivity {
    @BindView(R.id.tv)TextView tv;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        tv.setText("detailActivity");

    }


    @Override
    protected void addDataAgain() {

    }
}
