package com.example.yh.myapplication.fragments;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicFragment;
import com.example.yh.myapplication.entities.TestBean;
import com.example.yh.myapplication.presenter.PresenterTestBean;
import com.example.yh.myapplication.views.IView;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by yh on 2017/3/29.
 */

public class MyFragment extends BasicFragment implements IView<TestBean> {
    @BindView(R.id.textview_my)
    TextView label;
    @BindView(R.id.imageview_my)
    ImageView imageView;
    @BindView(R.id.avi)
    AVLoadingIndicatorView avi;
    private String imageUrl = "http://www.baidu.com/img/bdlogo.png";
    private ArrayList<String> mList;
    private static final String[] INDICATORS=new String[]{
            "BallPulseIndicator",
            "BallGridPulseIndicator",
            "BallClipRotateIndicator",
            "BallClipRotatePulseIndicator",
            "SquareSpinIndicator",
            "BallClipRotateMultipleIndicator",
            "BallPulseRiseIndicator",
            "BallRotateIndicator",
            "CubeTransitionIndicator",
            "BallZigZagIndicator",
            "BallZigZagDeflectIndicator",
            "BallTrianglePathIndicator",
            "BallScaleIndicator",
            "LineScaleIndicator",
            "LineScalePartyIndicator",
            "BallScaleMultipleIndicator",
            "BallPulseSyncIndicator",
            "BallBeatIndicator",
            "LineScalePulseOutIndicator",
            "LineScalePulseOutRapidIndicator",
            "BallScaleRippleIndicator",
            "BallScaleRippleMultipleIndicator",
            "BallSpinFadeLoaderIndicator",
            "LineSpinFadeLoaderIndicator",
            "TriangleSkewSpinIndicator",
            "PacmanIndicator",
            "BallGridBeatIndicator",
            "SemiCircleSpinIndicator",
            "com.wang.avi.sample.MyCustomIndicator"
    };
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        mList = new ArrayList<>();

        mList.add("BallPulseIndicator");
        mList.add("BallGridPulseIndicator");
        mList.add("BallClipRotateIndicator");
        mList.add("BallClipRotatePulseIndicator");

        mList.add("SquareSpinIndicator");
        mList.add("BallClipRotateMultipleIndicator");
        mList.add("BallPulseRiseIndicator");
        mList.add("BallRotateIndicator");

        mList.add("CubeTransitionIndicator");
        mList.add("BallZigZagIndicator");
        mList.add("BallZigZagDeflectIndicator");
        mList.add("BallTrianglePathIndicator");

        mList.add("BallScaleIndicator");
        mList.add("LineScaleIndicator");
        mList.add("LineScalePartyIndicator");
        mList.add("BallScaleMultipleIndicator");


        mList.add("BallPulseSyncIndicator");
        mList.add("BallBeatIndicator");
        mList.add("LineScalePulseOutIndicator");
        mList.add("LineScalePulseOutRapidIndicator");

        mList.add("BallScaleRippleIndicator");
        mList.add("BallScaleRippleMultipleIndicator");
        mList.add("BallSpinFadeLoaderIndicator");
        mList.add("LineSpinFadeLoaderIndicator");

        mList.add("TriangleSkewSpinIndicator");
        mList.add("PacmanIndicator");
        mList.add("BallGridBeatIndicator");
        mList.add("SemiCircleSpinIndicator");

        mList.add("com.wang.avi.sample.MyCustomIndicator");

    }

    int index;

    private void startAnim() {
        avi.setIndicator(INDICATORS[index]);
        avi.show();
        index++;
        if (index >= INDICATORS.length) {
            index = 0;
        }
        // or avi.smoothToShow();
    }

    private void stopAnim() {
        avi.hide();
        // or avi.smoothToHide();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        PresenterTestBean presenterTestBean = new PresenterTestBean(this);
        String url = "http://www.weather.com.cn/data/cityinfo/101010100.html";
        presenterTestBean.getData(url);
        presenterTestBean.setImageView(new IView<Bitmap>() {
            @Override
            public void getBean(Bitmap v) {
                Drawable backgroud = imageView.getBackground();
                Resources res = getResources();
                Bitmap f = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher);
                Bitmap bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.drawBitmap(f, new Matrix(), null);
                canvas.drawBitmap(v, 100, 100, null);
                f.recycle();
                imageView.setImageBitmap(bitmap);


            }
        });
        presenterTestBean.getBitmap(imageUrl);
    }

    @OnClick({R.id.textview_my, R.id.imageview_my})
    public void mclick(View view) {
        switch (view.getId()) {
            case R.id.textview_my:
                startAnim();
                break;
            case R.id.imageview_my:
                stopAnim();
                break;
        }
        //  getBasicActivity().openActivity(RetrofitHttpTestActivity.class);
    }


    @Override
    public void getBean(TestBean v) {
        label.setText("" + v.getWeatherinfo().toString());
    }
}
