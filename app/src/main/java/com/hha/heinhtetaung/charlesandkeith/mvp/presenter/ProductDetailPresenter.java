package com.hha.heinhtetaung.charlesandkeith.mvp.presenter;

import com.hha.heinhtetaung.charlesandkeith.data.model.ProductModel;
import com.hha.heinhtetaung.charlesandkeith.mvp.view.ProductDetailview;
import com.hha.heinhtetaung.charlesandkeith.mvp.view.ProductView;
import com.hha.heinhtetaung.charlesandkeith.network.response.GetProductResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by E5 on 6/30/2018.
 */

public class ProductDetailPresenter extends BasePresenter<ProductDetailview> {

    private PublishSubject<GetProductResponse> mPublishSubject;

    public ProductDetailPresenter(ProductDetailview mView) {
        super(mView);
    }

    @Override
    public void onCreat() {
        super.onCreat();

        mPublishSubject = PublishSubject.create();

        ProductModel.getObjInstance(mView.getContext()).startLoadingproduct(mPublishSubject);
        mPublishSubject.subscribe(new Observer<GetProductResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(GetProductResponse getProductResponse) {
                mView.displayProductDetail(getProductResponse.getNewProducts());
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
