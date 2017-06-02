package com.example.yh.myapplication.base;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.yh.myapplication.R;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.List;

import butterknife.ButterKnife;

//import com.squareup.leakcanary.RefWatcher;

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
        this.setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
//        RefWatcher refWatcher = MyApplication.refWatcher;
//        refWatcher.watch(this);
    }

    protected abstract int getLayoutId();

    public ViewStub stubneterror;
    private ImageView mImageback;
    private ImageView mImageviewmsg;

    protected abstract void initView();

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
    boolean hasPermissions=false;
    public boolean permissions(String permission) {

        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(permission).subscribe(granted -> {
            hasPermissions=granted;
            if (granted) {

            } else {
                Uri packageURI = Uri.parse("package:" + "com.example.yh.myapplication");
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                startActivityForResult(intent, 100);
            }
        });
        return hasPermissions;
    }

    public void openActivity(Class<? extends Activity> activity) {
        openActivity(activity, null);
    }

    public void openActivity(Class<? extends Activity> activity, Bundle bundle) {
        Intent intent = new Intent(this, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void openActivity(Class<? extends Activity> activity, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
            startActivityForResult(intent, requestCode, bundle);
            return;
        }
        //startActivity(intent);
        startActivityForResult(intent, requestCode);

    }

    /**
     * 在此方法中重新加载数据
     */
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
