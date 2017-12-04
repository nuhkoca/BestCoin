package com.mobilemovement.bestcoin.coinlist.network;

import com.mobilemovement.bestcoin.coinlist.model.CoinListDataModel;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public interface CoinListAPI {

    @GET("/data/all/coinlist")
    Observable<List<CoinListDataModel>> loadCoins();
}
