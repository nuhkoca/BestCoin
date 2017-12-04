package com.mobilemovement.bestcoin;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private static final long DELAY_IN_SECONDS = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initMainActivity();
    }

    private void initMainActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent coinListActivity = new Intent(SplashActivity.this, HolderActivity.class);
                coinListActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(coinListActivity);
            }
        }, DELAY_IN_SECONDS);
    }
}
