package com.hha.heinhtetaung.charlesandkeith.data.model;

import android.content.Context;

import com.google.gson.Gson;
import com.hha.heinhtetaung.charlesandkeith.network.ProductApi;
import com.hha.heinhtetaung.charlesandkeith.persistence.database.AppDatabase;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by E5 on 6/28/2018.
 */

public abstract class BaseModel {

    protected ProductApi mProductApi;
    protected AppDatabase mDatabase;


    protected BaseModel(Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/ck/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        mProductApi = retrofit.create(ProductApi.class);
        mDatabase = AppDatabase.getObjInstance(context);

    }

}
