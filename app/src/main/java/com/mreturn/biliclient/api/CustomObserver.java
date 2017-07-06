package com.mreturn.biliclient.api;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by mReturn
 * on 2017/7/6.
 */

public abstract class CustomObserver<T> implements Observer<T>{
    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull T t) {
        onSuccess(t);

    }

    @Override
    public void onError(@NonNull Throwable e) {
        onFailure(e);

    }

    @Override
    public void onComplete() {

    }

    protected abstract void onSuccess(T t);

    protected abstract void onFailure(Throwable e);

}
