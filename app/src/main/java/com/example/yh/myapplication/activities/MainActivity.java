package com.example.yh.myapplication.activities;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.yh.myapplication.Event.MyEvent;
import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicActivity;
import com.example.yh.myapplication.fragments.HomeFragment;
import com.example.yh.myapplication.fragments.ListFragment;
import com.example.yh.myapplication.fragments.MyFragment;
import com.example.yh.myapplication.utils.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

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
        ActivityInfo info= null;
        try {
            info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Log.e("info"+info);
        if(info!=null){
            Log.e("info.metaData"+info.metaData);
            Log.e("info.metaData"+info.metaData.getString("yh"));
        }
     //   Toast.makeText(this,info.metaData.getString("yh"),Toast.LENGTH_SHORT).show();
        showFragment(0 );
//        showFragment( 1);
//        showFragment( 2);

        EventBus.getDefault().register(this);
    }



    @Override
    protected void addDataAgain() {

    }
    @Subscribe(threadMode = ThreadMode.MainThread)
public void helloSomeOne(MyEvent myEvent){
Log.e(myEvent.getMsg());
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
    public void onEventMainThread(MyEvent event) {

        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Log.e( msg);

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
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
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
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
