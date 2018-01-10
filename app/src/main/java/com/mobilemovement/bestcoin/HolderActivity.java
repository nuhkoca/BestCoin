package com.mobilemovement.bestcoin;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mobilemovement.bestcoin.base.BaseActivity;
import com.mobilemovement.bestcoin.databinding.ActivityHolderBinding;
import com.mobilemovement.bestcoin.network.activity.NoInternetActivity;
import com.mobilemovement.bestcoin.utils.BackgroundUtils;
import com.mobilemovement.bestcoin.utils.ConnectionUtils;
import com.mobilemovement.bestcoin.utils.FragmentUtils;
import com.mobilemovement.bestcoin.utils.OrientationUtils;
import com.mobilemovement.bestcoin.utils.TransparentUtils;
import com.mobilemovement.bestcoin.view.currencylist.CurrencyListFragment;
import com.mobilemovement.bestcoin.view.market.MarketFragment;

import timber.log.Timber;

public class HolderActivity extends BaseActivity<ActivityHolderBinding> {

    private static long backPressed;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void initUI() {
        setSupportActionBar(activityDataBinding.mainToolbarLayout.toolbar);

        initNavigationDrawerUI();

        boolean isConnected = ConnectionUtils.pulse(this);

        if (!isConnected) {
            Timber.d("No internet connection");

            Intent noInternetIntent = new Intent(HolderActivity.this, NoInternetActivity.class);
            startActivity(noInternetIntent);
        } else {
            Fragment mImitationFragmentOf;
            mImitationFragmentOf = CurrencyListFragment.newInstance();

            FragmentUtils.replaceFragment(this, mImitationFragmentOf);
        }

    }

    @Override
    public void onBackPressed() {
        int timeDelay = getResources().getInteger(R.integer.time_delay);

        if (backPressed + timeDelay > System.currentTimeMillis()) {

            int backStackCount = FragmentUtils.getBackStackEntryCount();

            if (backStackCount > 0) {
                FragmentUtils.removeAllFragmentsFromBackStack();
                super.onBackPressed();
            } else {
                super.onBackPressed();
            }

        } else {
            Toast.makeText(getBaseContext(), getString(R.string.twice_press_to_exit),
                    Toast.LENGTH_SHORT).show();
        }

        backPressed = System.currentTimeMillis();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_holder;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mActionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return mActionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * exclusive methods
     */

    private void setupDrawerContent() {
        activityDataBinding.mainNavViewLayout.nvItemHolder.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    private void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        int imageId = 0;
        String collapsingToolbarLayoutTitle = null;

        int orientation = OrientationUtils.detectOrientation(this);

        if (orientation == 2)
            activityDataBinding.mainToolbarLayout.tvLoading.setVisibility(View.VISIBLE);
        else
            activityDataBinding.mainToolbarLayout.pbLoading.setVisibility(View.VISIBLE);
        activityDataBinding.mainToolbarLayout.tvLoading.setVisibility(View.VISIBLE);

        switch (menuItem.getItemId()) {
            case R.id.nav_fragment_1:
                imageId = R.drawable.currency_background;
                collapsingToolbarLayoutTitle = getString(R.string.fragment_coin_list);
                fragment = CurrencyListFragment.newInstance();
                break;
            case R.id.nav_fragment_2:
                imageId = R.drawable.market_background;
                collapsingToolbarLayoutTitle = getString(R.string.fragment_market);
                fragment = MarketFragment.newInstance();
                break;
            case R.id.nav_fragment_3:
                imageId = R.drawable.market_background;
                //fragment = new CurrencyListFragment();
                break;
            case R.id.nav_fragment_4:
                imageId = R.drawable.market_background;
                //fragment = new CurrencyListFragment();
                break;
            case R.id.nav_fragment_5:
                imageId = R.drawable.market_background;
                //fragment = new CurrencyListFragment();
                break;
            case R.id.nav_fragment_6:
                imageId = R.drawable.market_background;
                //fragment = new CurrencyListFragment();
                break;
            case R.id.nav_fragment_7:
                imageId = R.drawable.market_background;
                //fragment = new CurrencyListFragment();
                break;
            default:
                break;
        }

        activityDataBinding.mainToolbarLayout.ctlToolbarLayout.setTitle(collapsingToolbarLayoutTitle);
        BackgroundUtils.changeBackgroundImage(activityDataBinding.mainToolbarLayout.ivCtlBackground, imageId, this);

        if (fragment != null) {
            FragmentUtils.replaceFragment(this, fragment);
        }

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        activityDataBinding.mainDrawerLayout.closeDrawers();
    }

    private void initNavigationDrawerUI() {
        setupDrawerContent();

        mActionBarDrawerToggle = setupDrawerToggle();
        activityDataBinding.mainDrawerLayout.addDrawerListener(mActionBarDrawerToggle);

        BackgroundUtils.changeBackgroundImage(activityDataBinding.mainToolbarLayout.ivCtlBackground, R.drawable.currency_background, this);

        activityDataBinding.mainToolbarLayout.ctlToolbarLayout.setTitle(getString(R.string.fragment_coin_list));
        TransparentUtils.makeNavigationBarTransparentOnly(this);
        makeNavigationBarColored();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, activityDataBinding.mainDrawerLayout, activityDataBinding.mainToolbarLayout.toolbar, R.string.drawer_open, R.string.drawer_close);
    }

    private void makeNavigationBarColored() {
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.homeNavBarColor));
    }
}