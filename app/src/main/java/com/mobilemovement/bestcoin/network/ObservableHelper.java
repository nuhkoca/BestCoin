package com.mobilemovement.bestcoin.network;

import com.mobilemovement.bestcoin.coinlist.model.CoinListDataModel;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by nuhkoca on 9.12.2017.
 */

public class ObservableHelper {
    public static Observable<List<CoinListDataModel>> loadCoin(Retrofit retrofit) {
        IBestCoinAPI iBestCoinAPI = retrofit.create(IBestCoinAPI.class);

        return iBestCoinAPI.loadCoins();
    }
}
