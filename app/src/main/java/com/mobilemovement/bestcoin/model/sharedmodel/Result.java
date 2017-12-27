package com.mobilemovement.bestcoin.model.sharedmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nuhkoca on 14.12.2017.
 */

public class Result extends BaseObservable {
    @SerializedName("MarketCurrency")
    private String marketCurrency;
    @SerializedName("BaseCurrency")
    private String baseCurrency;
    @SerializedName("MarketCurrencyLong")
    private String marketCurrencyLong;
    @SerializedName("BaseCurrencyLong")
    private String baseCurrencyLong;
    @SerializedName("MinTradeSize")
    private Double minTradeSize;
    @SerializedName("MarketName")
    private String marketName;
    @SerializedName("IsActive")
    private Boolean isActive;
    @SerializedName("Created")
    private String created;
    @SerializedName("Notice")
    private Object notice;
    @SerializedName("IsSponsored")
    private Object isSponsored;
    @SerializedName("LogoUrl")
    private String logoUrl;

    public Result() {}

    public Result(String marketCurrency, String baseCurrency, String marketCurrencyLong, String baseCurrencyLong, Double minTradeSize, String marketName, Boolean isActive, String created, Object notice, Object isSponsored, String logoUrl) {
        this.marketCurrency = marketCurrency;
        this.baseCurrency = baseCurrency;
        this.marketCurrencyLong = marketCurrencyLong;
        this.baseCurrencyLong = baseCurrencyLong;
        this.minTradeSize = minTradeSize;
        this.marketName = marketName;
        this.isActive = isActive;
        this.created = created;
        this.notice = notice;
        this.isSponsored = isSponsored;
        this.logoUrl = logoUrl;
    }

    @Bindable
    public String getMarketCurrency() {
        return marketCurrency;
    }

    public void setMarketCurrency(String marketCurrency) {
        this.marketCurrency = marketCurrency;
        notifyPropertyChanged(BR.marketCurrency);
    }

    @Bindable
    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
        notifyPropertyChanged(BR.baseCurrency);
    }

    @Bindable
    public String getMarketCurrencyLong() {
        return marketCurrencyLong;
    }

    public void setMarketCurrencyLong(String marketCurrencyLong) {
        this.marketCurrencyLong = marketCurrencyLong;
        notifyPropertyChanged(BR.marketCurrencyLong);
    }

    @Bindable
    public String getBaseCurrencyLong() {
        return baseCurrencyLong;
    }

    public void setBaseCurrencyLong(String baseCurrencyLong) {
        this.baseCurrencyLong = baseCurrencyLong;
        notifyPropertyChanged(BR.baseCurrencyLong);
    }

    @Bindable
    public Double getMinTradeSize() {
        return minTradeSize;
    }

    public void setMinTradeSize(Double minTradeSize) {
        this.minTradeSize = minTradeSize;
        notifyPropertyChanged(BR.minTradeSize);
    }

    @Bindable
    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
        notifyPropertyChanged(BR.marketName);
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
    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
        notifyPropertyChanged(BR.created);
    }

    @Bindable
    public Object getNotice() {
        return notice;
    }

    public void setNotice(Object notice) {
        this.notice = notice;
        notifyPropertyChanged(BR.notice);
    }

    @Bindable
    public Object getIsSponsored() {
        return isSponsored;
    }

    public void setIsSponsored(Object isSponsored) {
        this.isSponsored = isSponsored;
        notifyPropertyChanged(BR.isSponsored);
    }

    @Bindable
    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        notifyPropertyChanged(BR.logoUrl);
    }
}
