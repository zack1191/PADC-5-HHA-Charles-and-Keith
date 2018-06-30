package com.hha.heinhtetaung.charlesandkeith.mvp.presenter;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.hha.heinhtetaung.charlesandkeith.mvp.view.BaseView;

/**
 * Created by E5 on 6/30/2018.
 */

public abstract class BasePresenter<T extends BaseView> {
    protected T mView;

    public BasePresenter(T mView) {
        this.mView = mView;
    }

    public void onCreat() {

    }

    public void onStart() {

    }

    public void onStop() {

    }

    public void onResume() {

    }

    public void onPause() {

    }

    public void onDestroy() {

    }
}
