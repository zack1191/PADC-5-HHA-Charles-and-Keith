package com.hha.heinhtetaung.charlesandkeith.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hha.heinhtetaung.charlesandkeith.R;
import com.hha.heinhtetaung.charlesandkeith.adapters.ItemViewPagerAdapter;
import com.hha.heinhtetaung.charlesandkeith.data.model.ProductModel;
import com.hha.heinhtetaung.charlesandkeith.data.vo.NewProductVO;
import com.hha.heinhtetaung.charlesandkeith.mvp.presenter.ProductDetailPresenter;
import com.hha.heinhtetaung.charlesandkeith.mvp.presenter.ProductPresenter;
import com.hha.heinhtetaung.charlesandkeith.mvp.view.ProductDetailview;
import com.hha.heinhtetaung.charlesandkeith.network.response.GetProductResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by E5 on 6/28/2018.
 */

public class ItemDetailActivity extends AppCompatActivity implements ProductDetailview {


    @BindView(R.id.vp_news_details_images)
    ViewPager vpNewsDetail;

    private ItemViewPagerAdapter mItemViewPagerAdapter;
    private ProductDetailPresenter mProductDetailPresenter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ItemDetailActivity.class);
//        intent.putExtra("productId", productId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        ButterKnife.bind(this, this);

        mProductDetailPresenter = ViewModelProviders.of(this).get(ProductDetailPresenter.class);
        mProductDetailPresenter.initPresenter(this);

        mProductDetailPresenter.getProductDetail().observe(this, new android.arch.lifecycle.Observer<List<NewProductVO>>() {
            @Override
            public void onChanged(@Nullable List<NewProductVO> productVOS) {
                displayProductDetail(productVOS);
            }
        });

        mItemViewPagerAdapter = new ItemViewPagerAdapter(getApplicationContext());
        vpNewsDetail.setAdapter(mItemViewPagerAdapter);


    }


    public void displayProductDetail(List<NewProductVO> mNewProductVOS) {
        mItemViewPagerAdapter.setProductVp(mNewProductVOS);
    }

    @Override
    public Context getContext() {
        return null;
    }

}
