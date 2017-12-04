package com.mobilemovement.bestcoin.coinlist.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public class CoinListDataModel extends BaseObservable {
    private String url;
    private String name;
    private String symbol;
    private String coinName;
    private String fullName;
    private String algorith;
    private String proofType;
    private String fullyPremined;
    private String totalCoinSupply;
    private String preMinedValue;
    private String totalCoinsFreeFloat;
    private String sponsored;

    public CoinListDataModel(String url, String name, String symbol, String coinName, String fullName, String algorith, String proofType, String fullyPremined, String totalCoinSupply, String preMinedValue, String totalCoinsFreeFloat, String sponsored) {
        this.url = url;
        this.name = name;
        this.symbol = symbol;
        this.coinName = coinName;
        this.fullName = fullName;
        this.algorith = algorith;
        this.proofType = proofType;
        this.fullyPremined = fullyPremined;
        this.totalCoinSupply = totalCoinSupply;
        this.preMinedValue = preMinedValue;
        this.totalCoinsFreeFloat = totalCoinsFreeFloat;
        this.sponsored = sponsored;
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        notifyPropertyChanged(BR.symbol);
    }

    @Bindable
    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
        notifyPropertyChanged(BR.coinName);
    }

    @Bindable
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        notifyPropertyChanged(BR.fullName);
    }

    @Bindable
    public String getAlgorith() {
        return algorith;
    }

    public void setAlgorith(String algorith) {
        this.algorith = algorith;
        notifyPropertyChanged(BR.algorith);
    }

    @Bindable
    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
        notifyPropertyChanged(BR.proofType);
    }

    @Bindable
    public String getFullyPremined() {
        return fullyPremined;
    }

    public void setFullyPremined(String fullyPremined) {
        this.fullyPremined = fullyPremined;
        notifyPropertyChanged(BR.fullyPremined);
    }

    @Bindable
    public String getTotalCoinSupply() {
        return totalCoinSupply;
    }

    public void setTotalCoinSupply(String totalCoinSupply) {
        this.totalCoinSupply = totalCoinSupply;
        notifyPropertyChanged(BR.totalCoinSupply);
    }

    @Bindable
    public String getPreMinedValue() {
        return preMinedValue;
    }

    public void setPreMinedValue(String preMinedValue) {
        this.preMinedValue = preMinedValue;
        notifyPropertyChanged(BR.preMinedValue);
    }

    @Bindable
    public String getTotalCoinsFreeFloat() {
        return totalCoinsFreeFloat;
    }

    public void setTotalCoinsFreeFloat(String totalCoinsFreeFloat) {
        this.totalCoinsFreeFloat = totalCoinsFreeFloat;
        notifyPropertyChanged(BR.totalCoinsFreeFloat);
    }

    @Bindable
    public String getSponsored() {
        return sponsored;
    }

    public void setSponsored(String sponsored) {
        this.sponsored = sponsored;
        notifyPropertyChanged(BR.sponsored);
    }
}
