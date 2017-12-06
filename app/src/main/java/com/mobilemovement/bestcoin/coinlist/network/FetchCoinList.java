package com.mobilemovement.bestcoin.coinlist.network;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mobilemovement.bestcoin.BuildConfig;
import com.mobilemovement.bestcoin.coinlist.adapter.CoinListAdapter;
import com.mobilemovement.bestcoin.coinlist.model.CoinListUpperModel;
import com.mobilemovement.bestcoin.network.IBestCoinAPI;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public class FetchCoinList {

    public static synchronized void fetchCoins(final CoinListAdapter coinListAdapter, final Context context) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        IBestCoinAPI IBestCoinAPI = retrofit.create(IBestCoinAPI.class);

        Observable<CoinListUpperModel> getCoinList = IBestCoinAPI.loadCoins();

        getCoinList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends CoinListUpperModel>>() {
                    @Override
                    public Observable<? extends CoinListUpperModel> call(Throwable throwable) {
                        Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_LONG).show();
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<CoinListUpperModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CoinListUpperModel coinListUpperModel) {
                        coinListAdapter.swapData(coinListUpperModel.getCoinListDataModels());
                    }
                });
    }
}