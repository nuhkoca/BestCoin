package com.mobilemovement.bestcoin.coinlist.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public class Result extends BaseObservable {
    private String currency;
    private String currencyLong;
    private Integer minConfirmation;
    private Double txFee;
    private Boolean isActive;
    private String coinType;
    private String baseAddress;
    private Object notice;

    public Result(String currency, String currencyLong, Integer minConfirmation, Double txFee, Boolean isActive, String coinType, String baseAddress, Object notice) {
        this.currency = currency;
        this.currencyLong = currencyLong;
        this.minConfirmation = minConfirmation;
        this.txFee = txFee;
        this.isActive = isActive;
        this.coinType = coinType;
        this.baseAddress = baseAddress;
        this.notice = notice;
    }

    @Bindable
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
        notifyPropertyChanged(BR.currency);
    }

    @Bindable
    public String getCurrencyLong() {
        return currencyLong;
    }

    public void setCurrencyLong(String currencyLong) {
        this.currencyLong = currencyLong;
        notifyPropertyChanged(BR.currencyLong);
    }

    @Bindable
    public Integer getMinConfirmation() {
        return minConfirmation;
    }

    public void setMinConfirmation(Integer minConfirmation) {
        this.minConfirmation = minConfirmation;
        notifyPropertyChanged(BR.minConfirmation);
    }

    @Bindable
    public Double getTxFee() {
        return txFee;
    }

    public void setTxFee(Double txFee) {
        this.txFee = txFee;
        notifyPropertyChanged(BR.txFee);
    }

    @Bindable
    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
        notifyPropertyChanged(BR.active);
    }

    @Bindable
    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
        notifyPropertyChanged(BR.coinType);
    }

    @Bindable
    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
        notifyPropertyChanged(BR.baseAddress);
    }

    @Bindable
    public Object getNotice() {
        return notice;
    }

    public void setNotice(Object notice) {
        this.notice = notice;
        notifyPropertyChanged(BR.notice);
    }
}