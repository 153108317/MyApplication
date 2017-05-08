package com.example.yh.myapplication.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yh on 2017/5/2.
 */

public class DetailActivity extends BasicActivity {
    @BindView(R.id.tv)
    TextView tv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        tv.setText("detailActivity");

    }

    @OnClick({R.id.tv})
    public void mclick(View view) {
        switch (view.getId()) {
            case R.id.tv:
                openActivity(OkHttpTestActivity.class);
                break;
        }
    }

    @Override
    protected void addDataAgain() {

    }
}
