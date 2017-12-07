package com.mobilemovement.bestcoin.network;

import com.mobilemovement.bestcoin.coinlist.model.CoinListDataModel;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public interface IBestCoinAPI {

    @GET("/en/api/v1/currency/")
    Observable<List<CoinListDataModel>> loadCoins();
}