package com.mobilemovement.bestcoin.network.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.databinding.ActivityNoInternetBinding;
import com.mobilemovement.bestcoin.utils.TransparentUtils;

public class NoInternetActivity extends AppCompatActivity {

    ActivityNoInternetBinding mActivityNoInternetBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityNoInternetBinding = DataBindingUtil.setContentView(this, R.layout.activity_no_internet);

        TransparentUtils.makeStatusBarTransparent(this);

        mActivityNoInternetBinding.btnNoConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
