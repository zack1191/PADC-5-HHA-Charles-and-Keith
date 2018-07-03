package com.hha.heinhtetaung.charlesandkeith.mvp.presenter;

import android.arch.lifecycle.LiveData;

import com.hha.heinhtetaung.charlesandkeith.data.model.ProductModel;
import com.hha.heinhtetaung.charlesandkeith.data.vo.NewProductVO;
import com.hha.heinhtetaung.charlesandkeith.mvp.view.ProductDetailview;
import com.hha.heinhtetaung.charlesandkeith.mvp.view.ProductView;
import com.hha.heinhtetaung.charlesandkeith.network.response.GetProductResponse;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by E5 on 6/30/2018.
 */

public class ProductDetailPresenter extends BasePresenter<ProductDetailview> {

    @Override
    public void initPresenter(ProductDetailview mView) {
        super.initPresenter(mView);
    }

    public LiveData<List<NewProductVO>> getProductDetail() {
        return ProductModel.getObjInstance(mView.getContext()).getAllProductLiveData();
    }
}
