package com.mobilemovement.bestcoin.view.currencylist.activity;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.databinding.ActivityCurrencyDetailsBinding;

import java.util.Objects;

public class CurrencyDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCurrencyDetailsBinding mActivityCurrencyDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_currency_details);
        supportPostponeEnterTransition();

        Bundle extras = getIntent().getExtras();
        String logoUrl = Objects.requireNonNull(extras).getString("result");

        String imageTransitionName = extras.getString("transition-name");
        Objects.requireNonNull(mActivityCurrencyDetailsBinding).ivCurrencyDetailLogo.setTransitionName(imageTransitionName);

        Glide.with(this)
                .load(logoUrl)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        supportStartPostponedEnterTransition();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {

                        supportStartPostponedEnterTransition();
                        return false;
                    }
                }).into(mActivityCurrencyDetailsBinding.ivCurrencyDetailLogo);

    }
}
