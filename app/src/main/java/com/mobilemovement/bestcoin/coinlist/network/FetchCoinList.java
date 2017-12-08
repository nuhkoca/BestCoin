package com.mobilemovement.bestcoin.coinlist.network;

import com.mobilemovement.bestcoin.coinlist.adapter.CoinListAdapter;
import com.mobilemovement.bestcoin.coinlist.model.CoinListDataModel;
import com.mobilemovement.bestcoin.network.ObservableHelper;
import com.mobilemovement.bestcoin.network.RetrofitInterceptor;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public class FetchCoinList {
    public static void loadCoins(final CoinListAdapter coinListAdapter) {
        Retrofit retrofit = RetrofitInterceptor.build();

        Observable<List<CoinListDataModel>> getCoinList = ObservableHelper.loadCoin(retrofit);

        getCoinList.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends List<CoinListDataModel>>>() {
                    @Override
                    public Observable<? extends List<CoinListDataModel>> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<List<CoinListDataModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<CoinListDataModel> coinListDataModel) {
                        coinListAdapter.swapData(coinListDataModel);
                    }
                });
    }
}