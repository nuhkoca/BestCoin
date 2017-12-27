package com.mobilemovement.bestcoin.callback;

import android.widget.ImageView;

import com.mobilemovement.bestcoin.model.sharedmodel.Result;

public interface IAdapterItemTouchListener {
    void onCurrencyTouch(Result result, ImageView imageView);
}