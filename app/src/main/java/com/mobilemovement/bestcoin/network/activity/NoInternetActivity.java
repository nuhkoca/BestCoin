package com.mobilemovement.bestcoin.network.activity;

import android.view.View;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.base.BaseActivity;
import com.mobilemovement.bestcoin.databinding.ActivityNoInternetBinding;
import com.mobilemovement.bestcoin.utils.ConnectionUtils;
import com.mobilemovement.bestcoin.utils.ToastUtils;
import com.mobilemovement.bestcoin.utils.TransparentUtils;

public class NoInternetActivity extends BaseActivity<ActivityNoInternetBinding> implements View.OnClickListener {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_no_internet;
    }

    @Override
    protected void initUI() {
        TransparentUtils.makeCompleteTransparent(this);

        activityDataBinding.btnNoConnection.setOnClickListener(this);
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