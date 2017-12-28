package com.mobilemovement.bestcoin.view.currencylist.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.base.BaseActivity;
import com.mobilemovement.bestcoin.databinding.ActivityCurrencyDetailsBinding;
import com.mobilemovement.bestcoin.utils.TransparentUtils;

import java.util.Objects;

public class CurrencyDetailsActivity extends BaseActivity<ActivityCurrencyDetailsBinding> implements AppBarLayout.OnOffsetChangedListener, View.OnClickListener {

    private static final int PERCENTAGE_TO_ANIMATE_AVATAR = 20;
    private boolean mIsAvatarShown = true;

    private int mMaxScrollSize;

    @Override
    protected void initUI() {
        setSupportActionBar(activityDataBinding.toolbarCurrencyDetails);
        TransparentUtils.makeCompleteTransparent(this);

        supportPostponeEnterTransition();

        activityDataBinding.aplCurrencyDetails.addOnOffsetChangedListener(this);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null)
            actionBar.setDisplayShowTitleEnabled(false);

        activityDataBinding.toolbarCurrencyDetails.setNavigationOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        String logoUrl = Objects.requireNonNull(extras).getString("result");

        String imageTransitionName = extras.getString("transition-name");
        Objects.requireNonNull(activityDataBinding).ivCurrencyDetailLogo.setTransitionName(imageTransitionName);

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

                        scheduleStartPostponedTransition(activityDataBinding.ivCurrencyDetailLogo);
                        return false;
                    }
                }).into(activityDataBinding.ivCurrencyDetailLogo);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_currency_details;
    }

    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
        super.onBackPressed();
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (mMaxScrollSize == 0)
            mMaxScrollSize = appBarLayout.getTotalScrollRange();

        int percentage = (Math.abs(verticalOffset)) * 100 / mMaxScrollSize;

        if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && mIsAvatarShown) {
            mIsAvatarShown = false;

            activityDataBinding.ivCurrencyDetailLogo.animate()
                    .scaleY(0).scaleX(0)
                    .setDuration(200)
                    .start();
        }

        if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !mIsAvatarShown) {
            mIsAvatarShown = true;

            activityDataBinding.ivCurrencyDetailLogo.animate()
                    .scaleY(1).scaleX(1)
                    .start();
        }

    }

    @Override
    public void onClick(View v) {
        int itemThatWasClicked = v.getId();

        switch (itemThatWasClicked) {
            case R.id.toolbar_currency_details:
                supportFinishAfterTransition();
            default:
                break;
        }

        onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void scheduleStartPostponedTransition(final View sharedElement) {
        sharedElement.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        sharedElement.getViewTreeObserver().removeOnPreDrawListener(this);
                        startPostponedEnterTransition();
                        return true;
                    }
                });
    }
}