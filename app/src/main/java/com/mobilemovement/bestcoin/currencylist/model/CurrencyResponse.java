package com.mobilemovement.bestcoin.currencylist.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nuhkoca on 9.12.2017.
 */

public class CurrencyResponse extends BaseObservable {
    @SerializedName("success")
    private Boolean success;
    @SerializedName("message")
    private String message;
    @SerializedName("result")
    private List<Result> result;

    public CurrencyResponse() {
    }

    @Bindable
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
        notifyPropertyChanged(BR.success);
    }

    @Bindable
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyPropertyChanged(BR.message);
    }

    @Bindable
    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
        notifyPropertyChanged(BR.result);
    }
}