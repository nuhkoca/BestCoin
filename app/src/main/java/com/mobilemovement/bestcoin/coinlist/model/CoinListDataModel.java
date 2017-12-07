package com.mobilemovement.bestcoin.coinlist.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public class CoinListDataModel extends BaseObservable {
    private String code;
    private String name;
    private Integer minConfirmations;
    private Boolean isCrypto;
    private String minimalAmount;
    private Boolean isBaseOfEnabledPair;
    private Boolean isQuoteOfEnabledPair;
    private Boolean hasEnabledPairs;
    private Boolean isBaseOfEnabledPairForTest;
    private Boolean isQuoteOfEnabledPairForTest;
    private Boolean hasEnabledPairsForTest;

    public CoinListDataModel(String code, String name, Integer minConfirmations, Boolean isCrypto, String minimalAmount, Boolean isBaseOfEnabledPair, Boolean isQuoteOfEnabledPair, Boolean hasEnabledPairs, Boolean isBaseOfEnabledPairForTest, Boolean isQuoteOfEnabledPairForTest, Boolean hasEnabledPairsForTest) {
        this.code = code;
        this.name = name;
        this.minConfirmations = minConfirmations;
        this.isCrypto = isCrypto;
        this.minimalAmount = minimalAmount;
        this.isBaseOfEnabledPair = isBaseOfEnabledPair;
        this.isQuoteOfEnabledPair = isQuoteOfEnabledPair;
        this.hasEnabledPairs = hasEnabledPairs;
        this.isBaseOfEnabledPairForTest = isBaseOfEnabledPairForTest;
        this.isQuoteOfEnabledPairForTest = isQuoteOfEnabledPairForTest;
        this.hasEnabledPairsForTest = hasEnabledPairsForTest;
    }

    @Bindable
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        notifyPropertyChanged(BR.code);
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
    public Integer getMinConfirmations() {
        return minConfirmations;
    }

    public void setMinConfirmations(Integer minConfirmations) {
        this.minConfirmations = minConfirmations;
        notifyPropertyChanged(BR.minConfirmations);
    }

    @Bindable
    public Boolean getCrypto() {
        return isCrypto;
    }

    public void setCrypto(Boolean crypto) {
        isCrypto = crypto;
        notifyPropertyChanged(BR.crypto);
    }

    @Bindable
    public String getMinimalAmount() {
        return minimalAmount;
    }

    public void setMinimalAmount(String minimalAmount) {
        this.minimalAmount = minimalAmount;
        notifyPropertyChanged(BR.minimalAmount);
    }

    @Bindable
    public Boolean getBaseOfEnabledPair() {
        return isBaseOfEnabledPair;
    }

    public void setBaseOfEnabledPair(Boolean baseOfEnabledPair) {
        isBaseOfEnabledPair = baseOfEnabledPair;
        notifyPropertyChanged(BR.baseOfEnabledPair);
    }

    @Bindable
    public Boolean getQuoteOfEnabledPair() {
        return isQuoteOfEnabledPair;
    }

    public void setQuoteOfEnabledPair(Boolean quoteOfEnabledPair) {
        isQuoteOfEnabledPair = quoteOfEnabledPair;
        notifyPropertyChanged(BR.quoteOfEnabledPair);
    }

    @Bindable
    public Boolean getHasEnabledPairs() {
        return hasEnabledPairs;
    }

    public void setHasEnabledPairs(Boolean hasEnabledPairs) {
        this.hasEnabledPairs = hasEnabledPairs;
        notifyPropertyChanged(BR.hasEnabledPairs);
    }

    @Bindable
    public Boolean getBaseOfEnabledPairForTest() {
        return isBaseOfEnabledPairForTest;
    }

    public void setBaseOfEnabledPairForTest(Boolean baseOfEnabledPairForTest) {
        isBaseOfEnabledPairForTest = baseOfEnabledPairForTest;
        notifyPropertyChanged(BR.baseOfEnabledPairForTest);
    }

    @Bindable
    public Boolean getQuoteOfEnabledPairForTest() {
        return isQuoteOfEnabledPairForTest;
    }

    public void setQuoteOfEnabledPairForTest(Boolean quoteOfEnabledPairForTest) {
        isQuoteOfEnabledPairForTest = quoteOfEnabledPairForTest;
        notifyPropertyChanged(BR.quoteOfEnabledPairForTest);
    }

    @Bindable
    public Boolean getHasEnabledPairsForTest() {
        return hasEnabledPairsForTest;
    }

    public void setHasEnabledPairsForTest(Boolean hasEnabledPairsForTest) {
        this.hasEnabledPairsForTest = hasEnabledPairsForTest;
        notifyPropertyChanged(BR.hasEnabledPairsForTest);
    }
}
