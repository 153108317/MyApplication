package com.example.yh.myapplication.activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicActivity;
import com.example.yh.myapplication.fragments.PictureFragment;
import com.example.yh.myapplication.fragments.PictureFragment1;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/07 11:19
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class PicturesActivity extends BasicActivity {
    @BindView(R.id.mtab_layout)
    public LinearLayout mTabLayout;
    @BindView(R.id.mframelayout)
    public FrameLayout mRramelayout;
    String tabText[] = {"tab1", "tab2", "tab3"};
    int tabImag[];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);////YY
        setContentView(R.layout.activity_pictures);
        ButterKnife.bind(this);
        int e = R.drawable.select_state;
        tabImag = new int[]{e, e, e};
        listFragments = new ArrayList<>();
        listFragments.add(new PictureFragment());
        listFragments.add(new PictureFragment1());
        listFragments.add(new PictureFragment1());
        showFragment(listFragments.get(0), R.id.mframelayout);
        listFragments.get(0).setArguments(getIntent().getExtras());
        for (int i = 0; i < tabText.length; i++) {
            View view = View.inflate(this, R.layout.tab_item, null);

            mTabLayout.addView(view);
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mTabLayout.getChildAt(i).getLayoutParams();
            lp.weight = 1;
            mTabLayout.getChildAt(i).setLayoutParams(lp);
            final ImageView iv = (ImageView) view.findViewById(R.id.tabimagview);
            final TextView tv = (TextView) view.findViewById(R.id.tabname);

            tv.setText(tabText[i]);
            iv.setImageResource(R.drawable.drawable_home);
            // iv.setImageResource();
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int i = 0; i < mTabLayout.getChildCount(); i++) {
//                        mTabLayout.getChildAt(i).findViewById(R.id.tabname).setClickable(false);
//                        mTabLayout.getChildAt(i).findViewById(R.id.tabimagview).setClickable(false);
                        if (view.equals(mTabLayout.getChildAt(i))) {
                            showFragment(listFragments.get(i), R.id.mframelayout);
                        }
                    }
                   // iv.setClickable(true);

                }
            });
        }

    }
}
