package com.example.yh.myapplication.activities;

import android.view.View;
import android.widget.TextView;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yh on 2017/5/2.
 */

public class DetailActivity extends BasicActivity {
    @BindView(R.id.tv)
    TextView tv;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }
    @Override
    protected void initView() {
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
