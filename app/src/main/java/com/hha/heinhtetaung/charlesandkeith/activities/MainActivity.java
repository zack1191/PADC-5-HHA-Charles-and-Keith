package com.hha.heinhtetaung.charlesandkeith.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.hha.heinhtetaung.charlesandkeith.R;
import com.hha.heinhtetaung.charlesandkeith.adapters.ItemAdapter;
import com.hha.heinhtetaung.charlesandkeith.adapters.ItemViewPagerAdapter;
import com.hha.heinhtetaung.charlesandkeith.data.model.ProductModel;
import com.hha.heinhtetaung.charlesandkeith.data.vo.NewProductVO;
import com.hha.heinhtetaung.charlesandkeith.delegate.ItemDelegate;
import com.hha.heinhtetaung.charlesandkeith.network.response.GetProductResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity implements ItemDelegate {

//    @BindView(R.id.rv_items)
//    RecyclerView rvItem;

    private PublishSubject<GetProductResponse> mPublishSubject;
    private ItemAdapter mItemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        RecyclerView rvItem = findViewById(R.id.rv_items);
        rvItem.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2, GridLayoutManager.VERTICAL, false));
        mItemAdapter = new ItemAdapter(getApplicationContext(), this);
        rvItem.setAdapter(mItemAdapter);

        mPublishSubject = PublishSubject.create();
        ProductModel.getObjInstance(getApplicationContext()).startLoadingproduct(mPublishSubject);
        mPublishSubject.subscribe(new Observer<GetProductResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(GetProductResponse getProductResponse) {
                mItemAdapter.appendNewData(getProductResponse.getNewProducts());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onTapItem() {
        Intent intent = ItemDetailActivity.newIntent(getApplicationContext());
        startActivity(intent);
    }
}
