package com.hha.heinhtetaung.charlesandkeith.activities;

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

public class ItemDetailActivity extends AppCompatActivity {


    @BindView(R.id.vp_news_details_images)
    ViewPager vpNewsDetail;

    private ItemViewPagerAdapter mItemViewPagerAdapter;
    private PublishSubject<GetProductResponse> mPublishSubject;
    private List<NewProductVO> mNewProductVOS;

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

        mItemViewPagerAdapter = new ItemViewPagerAdapter(getApplicationContext());
        vpNewsDetail.setAdapter(mItemViewPagerAdapter);


        mPublishSubject = PublishSubject.create();

        ProductModel.getObjInstance(getApplicationContext()).startLoadingproduct(mPublishSubject);
        mPublishSubject.subscribe(new Observer<GetProductResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(GetProductResponse getProductResponse) {
                mItemViewPagerAdapter.setNewVPList(getProductResponse.getNewProducts());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}
