package com.mobilemovement.bestcoin.network;

import com.mobilemovement.bestcoin.model.MarketResponse;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by nuhkoca on 9.12.2017.
 */

public class ObservableHelper {

    /**
     *  Returns the cal of IBestCoinAPI {@param retrofit
     *  Returns the cal of IBestCoinAPI {@link IBestCoinAPI
     */

    public static Observable<MarketResponse> loadCurrencies(Retrofit retrofit) {
        IBestCoinAPI iBestCoinAPI = retrofit.create(IBestCoinAPI.class);

        return iBestCoinAPI.loadCurrencies();
    }
}
