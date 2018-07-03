package com.hha.heinhtetaung.charlesandkeith.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hha.heinhtetaung.charlesandkeith.R;
import com.hha.heinhtetaung.charlesandkeith.adapters.ItemAdapter;
import com.hha.heinhtetaung.charlesandkeith.adapters.ItemViewPagerAdapter;
import com.hha.heinhtetaung.charlesandkeith.data.model.ProductModel;
import com.hha.heinhtetaung.charlesandkeith.data.vo.NewProductVO;
import com.hha.heinhtetaung.charlesandkeith.delegate.ItemDelegate;
import com.hha.heinhtetaung.charlesandkeith.mvp.presenter.ProductPresenter;
import com.hha.heinhtetaung.charlesandkeith.mvp.view.ProductView;
import com.hha.heinhtetaung.charlesandkeith.network.response.GetProductResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity implements ProductView {

//    @BindView(R.id.rv_items)
//    RecyclerView rvItem;

    private PublishSubject<GetProductResponse> mPublishSubject;
    private ItemAdapter mItemAdapter;
    private ProductPresenter mProductPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        ProductModel.getObjInstance(getApplicationContext());

        mProductPresenter = ViewModelProviders.of(this).get(ProductPresenter.class);
        mProductPresenter.initPresenter(this);

        mProductPresenter.getNewProductLD().observe(this, new android.arch.lifecycle.Observer<List<NewProductVO>>() {
            @Override
            public void onChanged(@Nullable List<NewProductVO> productVOS) {
                displayProduct(productVOS);
            }
        });

        mProductPresenter.getErrorLD().observe(this, new android.arch.lifecycle.Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        final RecyclerView rvItem = findViewById(R.id.rv_items);
        rvItem.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2, GridLayoutManager.VERTICAL, false));
        mItemAdapter = new ItemAdapter(getApplicationContext(), mProductPresenter);
        rvItem.setAdapter(mItemAdapter);


    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void launchProductDetail() {
        Intent intent = ItemDetailActivity.newIntent(getApplicationContext());
        startActivity(intent);

    }

    public void displayProduct(List<NewProductVO> newProductVOS) {
        mItemAdapter.appendNewData(newProductVOS);
    }

}
