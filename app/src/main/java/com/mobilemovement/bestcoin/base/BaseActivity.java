package com.mobilemovement.bestcoin.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import timber.log.Timber;

/**
 * Created by nuhkoca on 3.12.2017.
 */

public abstract class BaseActivity<A extends ViewDataBinding> extends AppCompatActivity {

    protected A activityDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDataBinding = DataBindingUtil.setContentView(this, getLayoutId());

        Timber.plant(new Timber.DebugTree());
    }

    protected abstract int getLayoutId();
}