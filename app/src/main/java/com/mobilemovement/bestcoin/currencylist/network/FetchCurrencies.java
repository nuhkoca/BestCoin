package com.mobilemovement.bestcoin.currencylist.network;

import android.content.Context;
import android.util.Log;

import com.mobilemovement.bestcoin.currencylist.adapter.CurrencyAdapter;
import com.mobilemovement.bestcoin.model.MarketResponse;
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

public class FetchCurrencies {
    private static final String ON_ERROR_RESUME_NEXT_LOG_TAG = "onErrorResumeNextLog";
    private static final String ON_ERROR__LOG_TAG = "onErrorLog";

    /**
     *  Adapter to load currencies into RecyclerView {@param currencyAdapter
     */

    public static void loadCurrencies(final CurrencyAdapter currencyAdapter) {
        Retrofit retrofit = RetrofitInterceptor.build();

        Observable<MarketResponse> getCurrencies = ObservableHelper.loadCurrencies(retrofit);

        getCurrencies.subscribeOn(Schedulers.io())
                .retry(1)
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends MarketResponse>>() {
                    @Override
                    public Observable<? extends MarketResponse> call(Throwable throwable) {
                        Log.d(ON_ERROR_RESUME_NEXT_LOG_TAG, throwable.getMessage());

                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<MarketResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(ON_ERROR__LOG_TAG, e.getMessage());
                    }

                    @Override
                    public void onNext(MarketResponse marketResponse) {
                        Log.d("onNextLog", marketResponse.getResult().get(0).getMarketCurrencyLong());
                        Log.d("onNextLog", marketResponse.getResult().get(0).getLogoUrl());

                        if (marketResponse.getSuccess())
                            currencyAdapter.swapData(marketResponse.getResult());
                            Log.d("onNextLog", marketResponse.getResult().get(0).getMarketCurrencyLong());
                            Log.d("onNextLog", marketResponse.getResult().get(0).getLogoUrl());
                    }
                });
    }
}