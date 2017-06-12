package com.example.yh.myapplication.fragments;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yh.myapplication.MyApplication;
import com.example.yh.myapplication.R;
import com.example.yh.myapplication.activities.PagerSlidingTabStripActivity;
import com.example.yh.myapplication.adapters.ShopAdapter;
import com.example.yh.myapplication.base.BasicFragment;
import com.example.yh.myapplication.db.Shop;
import com.example.yh.myapplication.db.ShopDao;
import com.example.yh.myapplication.network.HttpUrls;
import com.example.yh.myapplication.presenter.ShopAd;
import com.example.yh.myapplication.utils.Log;
import com.example.yh.myapplication.utils.Utils;
import com.example.yh.myapplication.views.MyUser;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.yh.myapplication.MyApplication.getDaoSession;

/**
 * Created by yh on 2017/3/29.
 */

public class HomeFragment extends BasicFragment implements MyUser {
    @BindView(R.id.textview_home)
    TextView label;
    @BindView(R.id.textview_home1)
    TextView label1;
    @BindView(R.id.scan)
    Button scan;
    @BindView(R.id.mrecylerview)//mrecylerview
            RecyclerView mRecyclerView;
    private final int SCANREQUESTCODE = 10;
    private List<Shop> mList;
    private ShopAdapter mShopAdapter;

    // private War
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShopAd shopAd = new ShopAd(this);
        shopAd.getData(HttpUrls.INDEXINFO);


    }

    private void getShopData() {
        if (mList == null) {
            mList = new ArrayList<Shop>();
            mShopAdapter = new ShopAdapter(mList, R.layout.item_shop);
            mRecyclerView.setAdapter(mShopAdapter);

        }
        mList.clear();
        mList.addAll(getDaoSession().getShopDao().loadAll()) ;
        Log.e("" + mList.size());
        if (!mList.isEmpty()) {
            for (Shop shop : mList) {
                Log.e("id" + shop.getId() + shop.getName());
            }
        }
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mShopAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

        String str = String.format(getResources().getString(R.string.stylestring), "我是添加的文字", "我也是");
        label.setText(Html.fromHtml(str));
        str = String.format(getResources().getString(R.string.label_topical_name), "这是为什么");
        label1.setText(Html.fromHtml(str));
        getShopData();
    }

    /**
     * 增加单个数据
     * <p>
     * getShopDao().insert(shop);
     * <p>
     * getShopDao().insertOrReplace(shop);
     * <p>
     * 增加多个数据
     * <p>
     * getShopDao().insertInTx(shopList);
     * <p>
     * getShopDao().insertOrReplaceInTx(shopList);
     * <p>
     * 查询全部
     * <p>
     * List< Shop> list = getShopDao().loadAll();
     * <p>
     * List< Shop> list = getShopDao().queryBuilder().list();
     * <p>
     * 查询附加单个条件
     * <p>
     * .where()
     * <p>
     * .whereOr()
     * <p>
     * 查询附加多个条件
     * <p>
     * .where(, , ,)
     * <p>
     * .whereOr(, , ,)
     * <p>
     * 查询附加排序
     * <p>
     * .orderDesc()
     * <p>
     * .orderAsc()
     * <p>
     * 查询限制当页个数
     * <p>
     * .limit()
     * <p>
     * 查询总个数
     * <p>
     * .count()
     * <p>
     * 修改单个数据
     * <p>
     * getShopDao().update(shop);
     * <p>
     * 修改多个数据
     * <p>
     * getShopDao().updateInTx(shopList);
     * <p>
     * 删除单个数据
     * <p>
     * getTABUserDao().delete(user);
     * <p>
     * 删除多个数据
     * <p>
     * getUserDao().deleteInTx(userList);
     * <p>
     * 删除数据ByKey
     * <p>
     * getTABUserDao().deleteByKey();
     */
    public static long index = 0;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick({R.id.tv_PagerSlidingTabStrip, R.id.scan, R.id.btn_add, R.id.btn_edit, R.id.btn_delete, R.id.btn_query})

    public void mClick(View view) {
        switch (view.getId()) {
            case R.id.tv_PagerSlidingTabStrip:
                getBasicActivity().openActivity(PagerSlidingTabStripActivity.class);
                break;
            case R.id.scan:

                if (getBasicActivity().permissions(Manifest.permission.CAMERA)) {
                    Intent intent = new Intent(MyApplication.mApplicationContext, CaptureActivity.class);
                    startActivityForResult(intent, SCANREQUESTCODE);
                }

                //   getBasicActivity().openActivity(CaptureActivity.class,SCANREQUESTCODE,null);
                break;
            case R.id.btn_add:

                index++;
                Shop shop = new Shop(index, "name" + index, "price" + index, (int) (1 + index)
                        , "image_url" + index,
                        "address" + index, Shop.TYPE_CART);
                Shop shop1 = getDaoSession().getShopDao().queryBuilder().where(ShopDao.Properties.Id.eq(index)).unique();

                if (shop1 != null) {
                    Log.e("shop1 id" + shop1.getId() + shop1.getName());
                    Utils.Toast("数据已存在");
                }else{
                getDaoSession().getShopDao().insert(shop);
                }
                getShopData();
                break;
            case R.id.btn_edit:
                if (!mList.isEmpty()) {
                    Shop shop2 = mList.get(0);
                    shop2.setName("我是修改后的名字");
                    getDaoSession().getShopDao().insertOrReplace(shop2);

                 //   getDaoSession().getShopDao().update(shop2);
                    getShopData();
                } else {
                    Utils.Toast("列表为空");
                    Shop shop4 = new Shop(index, "列表为空插入的数据" + index, "price" + index, (int) (1 + index)
                            , "image_url" + index,
                            "address" + index, Shop.TYPE_CART);
                    getDaoSession().getShopDao().insertOrReplace(shop4);
                }

                break;
            case R.id.btn_delete:
                index--;
               // getDaoSession().getShopDao().deleteByKey(1l);
                if (!mList.isEmpty()) {
                    Shop shop3 = mList.get(0);
                    shop3.setName("我是修改后的名字");

                   getDaoSession().getShopDao().delete(shop3);
                    getShopData();
                } else {
                    Utils.Toast("列表为空");
                }
                break;
            case R.id.btn_query:
                getShopData();
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case SCANREQUESTCODE:
                //处理扫描结果（在界面上显示）
                if (null != data) {
                    Bundle bundle = data.getExtras();
                    if (bundle == null) {
                        return;
                    }
                    if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                        String result = bundle.getString(CodeUtils.RESULT_STRING);
                        Log.e(result);
                        Utils.Toast("解析结果：" + result);
                    } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                        Utils.Toast("解析二维码失败");
                    }
                }
                break;
        }
    }

    @Override
    public void getUser(String user) {
        if (user != null) label.setText(user);
    }
}
