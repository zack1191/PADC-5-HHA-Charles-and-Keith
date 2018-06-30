package com.hha.heinhtetaung.charlesandkeith.mvp.presenter;

import android.arch.lifecycle.MutableLiveData;

import com.hha.heinhtetaung.charlesandkeith.data.model.ProductModel;
import com.hha.heinhtetaung.charlesandkeith.data.vo.NewProductVO;
import com.hha.heinhtetaung.charlesandkeith.delegate.ItemDelegate;
import com.hha.heinhtetaung.charlesandkeith.mvp.view.ProductView;
import com.hha.heinhtetaung.charlesandkeith.network.response.GetProductResponse;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by E5 on 6/30/2018.
 */

public class ProductPresenter extends BasePresenter<ProductView> implements ItemDelegate {
    private List<NewProductVO> mProductVOS;
    private PublishSubject<GetProductResponse> mPublishSubject;

    public ProductPresenter(ProductView view) {
        super(view);
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
                mView.displayProduct(getProductResponse.getNewProducts());
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
        mView.launchProductDetail();
    }
}
