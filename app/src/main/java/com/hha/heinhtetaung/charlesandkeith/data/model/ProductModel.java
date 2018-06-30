package com.hha.heinhtetaung.charlesandkeith.data.model;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.hha.heinhtetaung.charlesandkeith.CharlesAndKeithApp;
import com.hha.heinhtetaung.charlesandkeith.data.vo.NewProductVO;
import com.hha.heinhtetaung.charlesandkeith.network.response.GetProductResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by E5 on 6/28/2018.
 */

public class ProductModel extends BaseModel {

    private static ProductModel objInstance;
    private Map<String, NewProductVO> mProductVOMap;

    private int prodcutPageindex = 2;

    protected ProductModel(Context context) {
        super(context);
        mProductVOMap = new HashMap<>();

    }

    public static ProductModel getObjInstance(Context context) {
        if (objInstance == null) {
            objInstance = new ProductModel(context);
        }
        return objInstance;
    }

    public void startLoadingproduct(final PublishSubject<GetProductResponse> mPublishSubject) {
        mProductApi.loadProduct(prodcutPageindex, CharlesAndKeithApp.Access_Token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetProductResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetProductResponse data) {
                        for (NewProductVO newProductVO : data.getNewProducts()
                                ) {
                            mProductVOMap.put(newProductVO.getProudctId(), newProductVO);

                        }
                        mPublishSubject.onNext(data);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public NewProductVO getProductById(String productId) {
        return mProductVOMap.get(productId);
    }

}
