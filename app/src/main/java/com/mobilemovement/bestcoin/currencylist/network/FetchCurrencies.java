package com.mobilemovement.bestcoin.currencylist.network;

import android.annotation.SuppressLint;
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
import timber.log.Timber;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public class FetchCurrencies {
    
    /**
     *  Adapter to load currencies into RecyclerView {@param currencyAdapter
     **/

    public static void loadCurrencies(final CurrencyAdapter currencyAdapter) {
        Retrofit retrofit = RetrofitInterceptor.build();

        Observable<MarketResponse> getCurrencies = ObservableHelper.loadCurrencies(retrofit);

        getCurrencies.subscribeOn(Schedulers.io())
                .retry(1)
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends MarketResponse>>() {
                    @SuppressLint("TimberArgCount")
                    @Override
                    public Observable<? extends MarketResponse> call(Throwable throwable) {
                        Timber.d(throwable.getMessage());

                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<MarketResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.d(e.getMessage());
                    }

                    @Override
                    public void onNext(MarketResponse marketResponse) {
                        if (marketResponse.getSuccess())
                            currencyAdapter.swapData(marketResponse.getResult());
                            Timber.d("Fetched the data");
                    }
                });
    }
}