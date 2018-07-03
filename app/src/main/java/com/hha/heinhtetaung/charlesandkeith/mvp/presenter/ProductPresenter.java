package com.hha.heinhtetaung.charlesandkeith.mvp.presenter;

import android.arch.lifecycle.LiveData;
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
    private MutableLiveData<List<NewProductVO>> mProductLiveData;
    private MutableLiveData<String> mErrorLd;

    @Override
    public void initPresenter(ProductView mView) {
        super.initPresenter(mView);
        mProductLiveData = new MutableLiveData<>();
        mErrorLd = new MutableLiveData<>();
        ProductModel.getObjInstance(mView.getContext()).startLoadingCKProducts(mProductLiveData, mErrorLd);
    }

    public LiveData<List<NewProductVO>> getNewProductLD() {
        return mProductLiveData;
    }


    @Override
    public void onTapItem() {
        mView.launchProductDetail();
    }

}
