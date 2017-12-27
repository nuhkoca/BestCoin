package com.mobilemovement.bestcoin.network.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.base.BaseActivity;
import com.mobilemovement.bestcoin.databinding.ActivityNoInternetBinding;
import com.mobilemovement.bestcoin.utils.ConnectionUtils;
import com.mobilemovement.bestcoin.utils.ToastUtils;
import com.mobilemovement.bestcoin.utils.TransparentUtils;

public class NoInternetActivity extends BaseActivity<ActivityNoInternetBinding> implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TransparentUtils.makeCompleteTransparent(this);
        makeNavigationBarColored();

        activityDataBinding.btnNoConnection.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_no_internet;
    }

    @Override
    public void onBackPressed() {
        boolean isConnected = ConnectionUtils.pulse(this);

        if (!isConnected) {
            ToastUtils.showErrorMessage(this, getString(R.string.no_connection_error_message));
        } else {
            super.onBackPressed();
        }
    }

    private void makeNavigationBarColored() {
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.noInternetActivityColor));
    }

    @Override
    public void onClick(View v) {
        boolean isConnected = ConnectionUtils.pulse(getBaseContext());

        if (!isConnected) {
            ToastUtils.showErrorMessage(getBaseContext(), getString(R.string.no_connection_error_message));
        } else {
            super.onBackPressed();
        }
    }
}