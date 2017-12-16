package com.mobilemovement.bestcoin.network;

import com.mobilemovement.bestcoin.model.MarketResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by nuhkoca on 4.12.2017.
 */

/**
 *  Interface holds the calls {@link IBestCoinAPI
 */

public interface IBestCoinAPI {

    @GET("public/getmarkets/")
    Observable<MarketResponse> loadCurrencies();
}