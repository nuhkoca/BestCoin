package com.mobilemovement.bestcoin.network;

import com.mobilemovement.bestcoin.currencylist.model.CurrencyResponse;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by nuhkoca on 9.12.2017.
 */

public class ObservableHelper {
    public static Observable<CurrencyResponse> loadCurrencies(Retrofit retrofit) {
        IBestCoinAPI iBestCoinAPI = retrofit.create(IBestCoinAPI.class);

        return iBestCoinAPI.loadCurrencies();
    }
}
