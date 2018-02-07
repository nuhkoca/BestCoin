package com.mobilemovement.bestcoin.view.currencylist.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.base.BaseActivity;
import com.mobilemovement.bestcoin.bindadapter.module.GlideApp;
import com.mobilemovement.bestcoin.databinding.ActivityCurrencyDetailsBinding;
import com.mobilemovement.bestcoin.utils.TransparentUtils;
import com.mobilemovement.bestcoin.view.currencylist.CurrencyDetailsHolderFragment;

import java.util.Objects;

public class CurrencyDetailsActivity extends BaseActivity<ActivityCurrencyDetailsBinding> implements AppBarLayout.OnOffsetChangedListener, View.OnClickListener {

    private static final int PERCENTAGE_TO_ANIMATE_AVATAR = 20;
    private boolean mIsAvatarShown = true;

    private int mMaxScrollSize;
    private Bundle extras;

    @Override
    protected void initUI() {
        setSupportActionBar(activityDataBinding.toolbarCurrencyDetails);
        TransparentUtils.makeCompleteTransparent(this);
        supportPostponeEnterTransition();

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null)
            actionBar.setDisplayShowTitleEnabled(false);

        activityDataBinding.aplCurrencyDetails.addOnOffsetChangedListener(this);
        activityDataBinding.toolbarCurrencyDetails.setNavigationOnClickListener(this);
        extras = getIntent().getExtras();

        activityDataBinding.aplCurrencyDetails.setBackgroundResource(R.drawable.currency_background);

        applyImageViewTransition(extras);
        loadCurrencyIcon();
        loadMarketCurrencyLong();
        handleTabLayoutProcess();
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

        int scrollRange = appBarLayout.getTotalScrollRange();

        if (scrollRange + verticalOffset == 0) {
            activityDataBinding.aplCurrencyDetails.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        } else if (scrollRange + verticalOffset > 200) {
            activityDataBinding.aplCurrencyDetails.setBackgroundResource(R.drawable.currency_background);
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

    private void loadCurrencyIcon() {
        GlideApp.with(this)
                .asBitmap()
                .load(loadImageUrl(extras))
                .listener(new RequestListener<Bitmap>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                        supportStartPostponedEnterTransition();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {

                        scheduleStartPostponedTransition(activityDataBinding.ivCurrencyDetailLogo);
                        return false;
                    }
                }).into(activityDataBinding.ivCurrencyDetailLogo);
    }

    private String loadImageUrl(Bundle extras) {
        return extras.getString("image");
    }

    private void applyImageViewTransition(Bundle extras) {
        String imageTransitionName = extras.getString("transition-name");
        Objects.requireNonNull(activityDataBinding).ivCurrencyDetailLogo.setTransitionName(imageTransitionName);
    }

    private void loadMarketCurrencyLong() {
        activityDataBinding.tvCurrencyDetailCurrencyLongName.setText(extras.getString("long-name"));
    }

    private void handleTabLayoutProcess() {
        activityDataBinding.vpCurrencyDetail.setAdapter(new TabsAdapter(getSupportFragmentManager()));
        activityDataBinding.tlCurrencyDetail.setupWithViewPager(activityDataBinding.vpCurrencyDetail);
        activityDataBinding.tlCurrencyDetail.setTabTextColors(
                ContextCompat.getColor(this, R.color.colorWhite),
                ContextCompat.getColor(this, R.color.colorWhite)
        );
    }

    private class TabsAdapter extends FragmentPagerAdapter {
        private static final int TAB_COUNT = 1;

        TabsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return TAB_COUNT;
        }

        @Override
        public Fragment getItem(int i) {
            return CurrencyDetailsHolderFragment.newInstance(extras);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Details";
        }
    }
}