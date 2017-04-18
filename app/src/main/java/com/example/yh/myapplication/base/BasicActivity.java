package com.example.yh.myapplication.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.yh.myapplication.R;

import java.util.List;

/**
 * Created by yh on 2017/3/29.
 */

public abstract class BasicActivity extends FragmentActivity implements View.OnClickListener {
    protected List<BasicFragment> listFragments;
    public BasicActivity mBasicActivity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_basic);
        mBasicActivity = this;
    }

    public ViewStub stubneterror;
    private ImageView mImageback;
    private ImageView mImageviewmsg;

    public void setContentView(int layoutId) {
        ViewStub stubtitle = (ViewStub) findViewById(R.id.viewstub_titlebar);
        ViewStub stubcontent = (ViewStub) findViewById(R.id.viewstub_content);
        stubtitle.setLayoutResource(R.layout.titlebar);
        stubtitle.inflate();
        stubcontent.setLayoutResource(layoutId);
        mImageback = (ImageView) findViewById(R.id.imageview_back);
        mImageviewmsg = (ImageView) findViewById(R.id.imageview_msg);
        mImageback.setOnClickListener(this);
        mImageviewmsg.setOnClickListener(this);
        stubcontent.inflate();
    }

    public void openActivity(Class<? extends Activity> activity, Bundle bundle) {
        Intent intent = new Intent(this, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    /**在此方法中重新加载数据*/
    protected abstract void addDataAgain();
    protected void showFragment(BasicFragment fragment, int rootGroupId) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (listFragments != null) {
            for (Fragment fg : listFragments) {
                ft.hide(fg);
            }
        }
        if (fragment.getAddCount() == 0) {
            fragment.setAddCount(1);
            ft.add(rootGroupId, fragment);
        } else {
            ft.show(fragment);
        }

        ft.commit();
    }

    private LinearLayout mLinearLayoutNetError;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_back:
                finish();
                break;
            case R.id.imageview_msg:
                if (stubneterror == null) {
                    stubneterror = (ViewStub) findViewById(R.id.viewstub_net_error);
                    mLinearLayoutNetError = (LinearLayout) stubneterror.inflate();

                    mLinearLayoutNetError.setOnClickListener(this);
                } else {
                    stubneterror.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.net_errorId:
                mLinearLayoutNetError.setVisibility(View.GONE);
                addDataAgain();
                break;

        }
    }
}
