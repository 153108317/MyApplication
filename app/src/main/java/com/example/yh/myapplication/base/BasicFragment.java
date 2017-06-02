package com.example.yh.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by yh on 2017/3/29.
 */

public abstract class BasicFragment extends Fragment {
    private static final String HIDESTATE="fragmenthidestate";
    private int addCount;
    public BasicActivity getBasicActivity(){
        return (BasicActivity)super.getActivity();
    }

    public int getAddCount() {
        return addCount;
    }


    public void setAddCount(int addCount) {
        this.addCount = addCount;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm=getFragmentManager();
//        RefWatcher refWatcher = MyApplication.refWatcher;
//        refWatcher.watch(this);
        if(savedInstanceState!=null){
            FragmentTransaction ft=getFragmentManager().beginTransaction();
            Log.e("tag","HIDESTATE"+HIDESTATE);
            if(savedInstanceState.getBoolean(HIDESTATE)){
                ft.hide(this);
            }else{
                ft.show(this);
            }
            ft.commit();

        }

    }
    protected abstract int getLayoutId();
    protected abstract void initView();
    protected View v=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null==v){
            v=inflater.inflate(getLayoutId(),container,false) ;
        }
        ButterKnife.bind(this,v);
        initView();
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putBoolean(HIDESTATE,isHidden());
    }
}
