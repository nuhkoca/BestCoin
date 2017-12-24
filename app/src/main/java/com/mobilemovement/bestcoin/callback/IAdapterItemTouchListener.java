package com.mobilemovement.bestcoin.callback;

public interface IAdapterItemTouchListener {
    void onTouched(String logoUrl, String marketCurrency, String marketCurrencyLong, boolean isActive);
}