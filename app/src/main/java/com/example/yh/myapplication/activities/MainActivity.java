package com.example.yh.myapplication.activities;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicActivity;
import com.example.yh.myapplication.fragments.HomeFragment;
import com.example.yh.myapplication.fragments.ListFragment;
import com.example.yh.myapplication.fragments.MyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BasicActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.home_radiobutton)
    RadioButton mHOmeRadioButton;
    @BindView(R.id.list_radiobutton)
    RadioButton mListRadioButton;
    @BindView(R.id.my_radiobutton)
    RadioButton mMyRadioButton;
    @BindView(R.id.home_RadioGroup)
    RadioGroup mHomeRadioGroup;
    private HomeFragment mHomeFragment;
    private ListFragment mListFragment;
    private MyFragment myFragment;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mHomeRadioGroup.setOnCheckedChangeListener(this);

        showFragment(0 );
//        showFragment( 1);
//        showFragment( 2);


    }

    private void showFragment(int index) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            switch (index){
                case 0:
                    if(mHomeFragment==null) {
                        mHomeFragment = new HomeFragment();
                        ft.add(R.id.root_LInearLayout, mHomeFragment);
                    }else{
                        ft.show(mHomeFragment);
                    }
                    break;
                case 1:
                    if(mListFragment==null) {
                        mListFragment = new ListFragment();
                        ft.add(R.id.root_LInearLayout, mListFragment);
                    }else{
                        ft.show(mListFragment);
                    }
                    break;
                case 2:
                    if(myFragment==null) {
                        myFragment = new MyFragment();
                        ft.add(R.id.root_LInearLayout, myFragment);
                    }else{
                        ft.show(myFragment);
                    }
                    break;
            }

        ft.commit();
    }

//    @OnClick({R.id.home_radiobutton, R.id.list_radiobutton, R.id.my_radiobutton})
//    public void myclick(View v) {
//    }

    private void hideFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (mHomeFragment != null) {
            ft.hide(mHomeFragment);
        }
        if (mListFragment != null)
            ft.hide(mListFragment);
        if (myFragment != null) {
            ft.hide(myFragment);
        }
        ft.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        hideFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (checkedId) {
            case R.id.home_radiobutton:
                index = 0;
                showFragment( index);
                break;
            case R.id.list_radiobutton:
                index = 1;
                showFragment( index);
                break;
            case R.id.my_radiobutton:
                index = 2;
                showFragment( index);
                break;
        }


    }
}
