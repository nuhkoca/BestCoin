package com.mobilemovement.bestcoin.coinlist.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nuhkoca on 9.12.2017.
 */

public class CurrencyResponse extends BaseObservable {
    private Boolean success;
    private String message;
    private List<Result> results;

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
    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
        notifyPropertyChanged(BR.results);
    }
}