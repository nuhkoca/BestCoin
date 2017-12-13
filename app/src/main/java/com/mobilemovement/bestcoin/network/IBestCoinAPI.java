package com.mobilemovement.bestcoin.network;

import com.mobilemovement.bestcoin.currencylist.model.CurrencyResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public interface IBestCoinAPI {

    @GET("public/getcurrencies/")
    Observable<CurrencyResponse> loadCurrencies();
}