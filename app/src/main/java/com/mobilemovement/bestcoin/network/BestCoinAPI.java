package com.mobilemovement.bestcoin.network;

import com.mobilemovement.bestcoin.coinlist.model.CoinListDataModel;
import com.mobilemovement.bestcoin.coinlist.model.CoinListUpperModel;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public interface BestCoinAPI {

    @GET("/data/all/coinlist")
    Observable<CoinListUpperModel> loadCoins();
}
