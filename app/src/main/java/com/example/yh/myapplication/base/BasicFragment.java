package com.example.yh.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

/**
 * Created by yh on 2017/3/29.
 */

public class BasicFragment extends Fragment {
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

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putBoolean(HIDESTATE,isHidden());
    }
}
