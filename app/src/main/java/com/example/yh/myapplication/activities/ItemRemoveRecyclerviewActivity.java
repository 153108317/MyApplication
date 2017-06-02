package com.example.yh.myapplication.activities;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.adapters.RemoveRecyclerViewAdapter;
import com.example.yh.myapplication.api.GetPictureApi;
import com.example.yh.myapplication.base.BasicActivity;
import com.example.yh.myapplication.entities.PictureBean;
import com.example.yh.myapplication.entities.TestBean;
import com.example.yh.myapplication.interfaces.OnItemClickListener;
import com.example.yh.myapplication.network.HttpUrls;
import com.example.yh.myapplication.result.PictureResult;
import com.example.yh.myapplication.utils.Log;
import com.example.yh.myapplication.utils.Utils;
import com.example.yh.myapplication.views.IView;
import com.example.yh.myapplication.widget.RemoveRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/26 11:15
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class ItemRemoveRecyclerviewActivity extends BasicActivity implements IView<PictureResult>, OnItemClickListener<String> {

    @BindView(R.id.mrecylerview)
    RemoveRecyclerView mRecyclerView;
    @BindView(R.id.iv)
    ImageView iv;
    private ArrayList<PictureBean> mList;
    private RemoveRecyclerViewAdapter mRemoveRecyclerViewAdapter;
    private Handler mHandler = new Handler() {
    };

    @Override
    protected int getLayoutId() {
        return R.layout.mrecyclerview;
    }

    @Override
    protected void initView() {
        mList = new ArrayList<>();
        mRemoveRecyclerViewAdapter = new RemoveRecyclerViewAdapter(mList, R.layout.reycelerview_picture1_item);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setOnItemClickListener(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mRemoveRecyclerViewAdapter);
        mRecyclerView.setButton1Content("复位");
        mRecyclerView.setButton2Content("删除");
        addDataAgain();

    }

    @Override
    protected void addDataAgain() {
        GetPictureApi.getPictureBeans(HttpUrls.PICTURESURL + 1, 0, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRemoveRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View view, int position) {

        Log.e("positon" + position);
        List<TestBean> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TestBean testBean = new TestBean();
            testBean.setTitle("title" + i);
            list.add(testBean);
            testBean = null;
        }
        new DefaultSubscriber<String>() {
            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };
        DisposableSubscriber<String> d = new DisposableSubscriber<String>() {
            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };
        Flowable.create(new FlowableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull FlowableEmitter<Object> e) throws Exception {
                e.onNext("");
            }
        }, BackpressureStrategy.BUFFER);

    }


    Consumer<String> mConsumer = new Consumer<String>() {
        @Override
        public void accept(@NonNull String s) throws Exception {
            Log.e("accept" + s);
        }
    };

    @Override
    public void onDeleteClick(int position, int type) throws Exception {
        mObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object bitmap) throws Exception {
                        Log.e("bitmap");
                        iv.setImageBitmap((Bitmap) bitmap);
                    }
                });
        if (type == 1) {
            mRemoveRecyclerViewAdapter.delete(position);
        }
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> e) throws Exception {
                e.onNext("dddd");
            }
        });
    }

    Observer<String> mObserver = new Observer<String>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {
            Log.e("onSubscribe");
        }

        @Override
        public void onNext(@NonNull String s) {
            Log.e("onNext" + s);
        }

        @Override
        public void onError(@NonNull Throwable e) {
            Log.e("onError");
        }

        @Override
        public void onComplete() {
            Log.e("onComplete");
        }
    };
    String imgUrl = "http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-31-17662615_1819763634937161_2829588299293655040_n.jpg";
    Observable<Object> mObservable = (Observable<Object>) Observable.just(imgUrl)
            .subscribeOn(Schedulers.io())

            .map(new Function<String, Object>() {
                @Override
                public Bitmap apply(@NonNull String s) throws Exception {
                    Log.e("apply" + s);
                    Bitmap bitmap = null;
                    return Utils.getBitmap(imgUrl);
                }
            });

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void getBean(PictureResult v) {
        if (v.getResults() != null && v.getResults().size() > 0) {
            mList.addAll(v.getResults());
            mRemoveRecyclerViewAdapter.notifyDataSetChanged();
        }
    }
}
