package com.mobilemovement.bestcoin.view.currencylist.network;

import com.mobilemovement.bestcoin.callback.IResponseListener;
import com.mobilemovement.bestcoin.model.MarketResponse;
import com.mobilemovement.bestcoin.model.Result;
import com.mobilemovement.bestcoin.network.ObservableHelper;
import com.mobilemovement.bestcoin.network.RetrofitInterceptor;
import com.mobilemovement.bestcoin.view.currencylist.adapter.CurrencyAdapter;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public class FetchCurrencies {

    private static final String BITCOIN_CONDITION  ="Bitcoin";
    
    /**
     *  Adapter to load currencies into RecyclerView {@param currencyAdapter
     **/

    public static void loadCurrencies(final CurrencyAdapter currencyAdapter, final IResponseListener iResponseListener) {
        final Retrofit retrofit = RetrofitInterceptor.build();

        final Observable<MarketResponse> getCurrencies = ObservableHelper.loadCurrencies(retrofit);

        getCurrencies.subscribeOn(Schedulers.io())
                .retry(1)
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends MarketResponse>>() {
                    @Override
                    public Observable<? extends MarketResponse> call(Throwable throwable) {
                        Timber.d(throwable.getMessage());

                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<MarketResponse>() {
                    @Override
                    public void onCompleted() { }

                    @Override
                    public void onError(Throwable e) {
                        Timber.d(e.getMessage());
                        iResponseListener.onFailed();
                    }

                    @Override
                    public void onNext(MarketResponse marketResponse) {
                        List<Result> results = new ArrayList<>();

                        if (marketResponse.getSuccess())

                            for (int i = 0; i < marketResponse.getResult().size(); i++) {
                                if (marketResponse.getResult().get(i).getBaseCurrencyLong().equals(BITCOIN_CONDITION)) {

                                    Result result = new Result();

                                    result.setLogoUrl(marketResponse.getResult().get(i).getLogoUrl());
                                    result.setMarketCurrency(marketResponse.getResult().get(i).getMarketCurrency());
                                    result.setMarketCurrencyLong(marketResponse.getResult().get(i).getMarketCurrencyLong());
                                    result.setActive(marketResponse.getResult().get(i).getActive());

                                    results.add(result);
                                }
                            }

                        marketResponse.setResult(results);
                        currencyAdapter.swapData(marketResponse.getResult());
                        Timber.d("Fetched currency data");
                    }
                });
    }
}