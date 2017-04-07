package com.example.yh.myapplication.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

/**
 * Created by yh on 2017/3/29.
 */

public class BasicActivity extends FragmentActivity {
    protected List<BasicFragment> listFragments;
    public BasicActivity mBasicActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBasicActivity = this;
    }

    public void openActivity(Class<? extends Activity> activity, Bundle bundle) {
        Intent intent = new Intent(this, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

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
}
