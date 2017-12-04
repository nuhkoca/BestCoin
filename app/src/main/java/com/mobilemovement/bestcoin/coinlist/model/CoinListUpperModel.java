package com.mobilemovement.bestcoin.coinlist.model;

import android.databinding.BaseObservable;

import java.util.List;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public class CoinListUpperModel extends BaseObservable {
    private String response;
    private String baseImageURL;
    private List<CoinListDataModel> coinListDataModels;

    public CoinListUpperModel(String response, String baseImageURL, List<CoinListDataModel> coinListDataModels) {
        this.response = response;
        this.baseImageURL = baseImageURL;
        this.coinListDataModels = coinListDataModels;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getBaseImageURL() {
        return baseImageURL;
    }

    public void setBaseImageURL(String baseImageURL) {
        this.baseImageURL = baseImageURL;
    }

    public List<CoinListDataModel> getCoinListDataModels() {
        return coinListDataModels;
    }

    public void setCoinListDataModels(List<CoinListDataModel> coinListDataModels) {
        this.coinListDataModels = coinListDataModels;
    }
}
