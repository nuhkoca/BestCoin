package com.mobilemovement.bestcoin.coinlist.network;

import android.util.Log;

import com.mobilemovement.bestcoin.coinlist.adapter.CurrencyAdapter;
import com.mobilemovement.bestcoin.coinlist.model.CurrencyResponse;
import com.mobilemovement.bestcoin.network.ObservableHelper;
import com.mobilemovement.bestcoin.network.RetrofitInterceptor;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public class FetchCoinList {
    public static void loadCurrencies(final CurrencyAdapter currencyAdapter) {
        Retrofit retrofit = RetrofitInterceptor.build();

        Observable<CurrencyResponse> getCurrencies = ObservableHelper.loadCurrencies(retrofit);

        getCurrencies.subscribeOn(Schedulers.io())
                .retry(1)
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends CurrencyResponse>>() {
                    @Override
                    public Observable<? extends CurrencyResponse> call(Throwable throwable) {
                        Log.d("onErrorResumeNext", throwable.getMessage());

                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<CurrencyResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("onErrorLog", e.getMessage());

                    }

                    @Override
                    public void onNext(CurrencyResponse currencyResponse) {
                        if (currencyResponse.getSuccess())
                            currencyAdapter.swapData(currencyResponse.getResults());
                    }
                });
    }
}