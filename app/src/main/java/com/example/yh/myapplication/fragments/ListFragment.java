package com.example.yh.myapplication.fragments;

        import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.activities.PicturesActivity;
import com.example.yh.myapplication.adapters.TestAdapter;
import com.example.yh.myapplication.base.BasicActivity;
import com.example.yh.myapplication.base.BasicFragment;
import com.example.yh.myapplication.entities.TestBean;
import com.example.yh.myapplication.presenter.PresenterTestBean;
import com.example.yh.myapplication.views.IView;

import butterknife.BindView;

/**
 * Created by yh on 2017/3/29.
 */

public class ListFragment extends BasicFragment implements IView<TestBean>{
   @BindView(R.id.mlistview)
    ListView mListView;
    @BindView(R.id.textviewlist)public TextView textviewlist;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initView() {
      //  mListView= (ListView) v.findViewById(R.id.mlistview);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        PresenterTestBean presenterTestBean=new PresenterTestBean(this);
        String url="http://www.weather.com.cn/data/cityinfo/101010100.html";
        presenterTestBean.getData(url);
        textviewlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putSerializable("test",testBean);
                ((BasicActivity) getActivity()).openActivity(PicturesActivity.class,bundle);
            }
        });
    }
private TestBean testBean;
    @Override
    public void getBean(TestBean v) {
        testBean=testBean;
        mListView.setAdapter(new TestAdapter(v.getList(),R.layout.listview_item));

    }
}
