package com.hha.heinhtetaung.charlesandkeith.data.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.hha.heinhtetaung.charlesandkeith.CharlesAndKeithApp;
import com.hha.heinhtetaung.charlesandkeith.data.vo.NewProductVO;
import com.hha.heinhtetaung.charlesandkeith.network.response.GetProductResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by E5 on 6/28/2018.
 */


public class ProductModel extends BaseModel {

    private static ProductModel mInstance;
    private int pageIndex = 2;

    protected ProductModel(Context context) {
        super(context);
    }


    public static ProductModel getObjInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ProductModel(context);
        }
        return mInstance;

    }

    public void startLoadingCKProducts(final MutableLiveData<List<NewProductVO>> mProductLD, final MutableLiveData<String> mErrorLd) {
        Observable<GetProductResponse> getProductResponseObservable = mProductApi.loadProduct(pageIndex, CharlesAndKeithApp.Access_Token);
        getProductResponseObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetProductResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetProductResponse getProductResponse) {
                        if (getProductResponse != null && getProductResponse.getNewProductVOList().size() > 0) {
                            mProductLD.setValue(getProductResponse.getNewProductVOList());
                            addNewProductsToDB(getProductResponse.getNewProductVOList());


                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        mErrorLd.setValue(e.getMessage());
                        mProductLD.setValue(mDatabase.productDAO().getAllProduct());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void addNewProductsToDB(List<NewProductVO> productsVOS) {
        mDatabase.clearAllTables();
        mDatabase.productDAO().insertProducts(productsVOS);
        Log.d(CharlesAndKeithApp.LOG_TAG, "product list" + mDatabase.productDAO().getAllProduct().size());
    }

    public List<NewProductVO> getProductById(String productId) {
        return mDatabase.productDAO().getProductById(productId);
    }

    public LiveData<List<NewProductVO>> getAllProductLiveData() {
        return mDatabase.productDAO().getAllLiveData();
    }

    public LiveData<List<NewProductVO>> getProductLiveDataById(String id) {
        return mDatabase.productDAO().getLiveDataProductById(id);
    }

    public List<NewProductVO> getAllProduct() {
        return mDatabase.productDAO().getAllProduct();
    }


}
