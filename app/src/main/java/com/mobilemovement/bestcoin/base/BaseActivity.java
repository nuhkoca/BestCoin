package com.mobilemovement.bestcoin.base;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.mobilemovement.bestcoin.HolderActivity;
import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.utils.CollapsingToolbarLayoutBackgroundUtils;
import com.mobilemovement.bestcoin.utils.FragmentUtils;
import com.mobilemovement.bestcoin.utils.TransparentUtils;
import com.mobilemovement.bestcoin.view.currencylist.CurrencyListFragment;
import com.mobilemovement.bestcoin.view.market.MarketFragment;

import timber.log.Timber;

/**
 * Created by nuhkoca on 3.12.2017.
 */

public abstract class BaseActivity<A extends ViewDataBinding> extends AppCompatActivity {

    protected A activityDataBinding;
    protected ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDataBinding = DataBindingUtil.setContentView(this, getLayoutId());

        if (getToolbar() != null && getDrawerLayout() != null && getNavigationView() != null && getCollapsingToolbarLayout() != null) {
            initNavigationDrawerUI();
        }

        Timber.plant(new Timber.DebugTree());
    }

    protected void initNavigationDrawerUI() {
        setSupportActionBar(getToolbar());

        mActionBarDrawerToggle = setupDrawerToggle();
        setupDrawerContent();
        getDrawerLayout().addDrawerListener(mActionBarDrawerToggle);

        CollapsingToolbarLayoutBackgroundUtils.changeBackground(getImageViewForCollapsingToolbarLayoutBackground(), R.drawable.currency_background, this);

        getCollapsingToolbarLayout().setTitle(getString(R.string.fragment_coin_list));
        TransparentUtils.makeNavigationBarTransparentOnly(this);
        makeNavigationBarColored();
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

    protected void setupDrawerContent() {
        getNavigationView().setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    protected void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        int imageId = 0;
        String collapsinToolbarLayoutTitle = null;

        switch (menuItem.getItemId()) {
            case R.id.nav_fragment_1:
                imageId = R.drawable.currency_background;
                collapsinToolbarLayoutTitle = getString(R.string.fragment_coin_list);
                fragment = new CurrencyListFragment();
                break;
            case R.id.nav_fragment_2:
                imageId = R.drawable.market_background;
                collapsinToolbarLayoutTitle = getString(R.string.fragment_market);
                fragment = new MarketFragment();
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

        getCollapsingToolbarLayout().setTitle(collapsinToolbarLayoutTitle);
        CollapsingToolbarLayoutBackgroundUtils.changeBackground(getImageViewForCollapsingToolbarLayoutBackground(), imageId, this);

        if (fragment != null) {
            FragmentUtils.replaceFragment((HolderActivity) this, fragment);
        }

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        getDrawerLayout().closeDrawers();
    }

    protected abstract int getLayoutId();

    protected abstract Toolbar getToolbar();

    protected abstract DrawerLayout getDrawerLayout();

    protected abstract NavigationView getNavigationView();

    protected abstract CollapsingToolbarLayout getCollapsingToolbarLayout();

    protected abstract ImageView getImageViewForCollapsingToolbarLayoutBackground();

    protected ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, getDrawerLayout(), getToolbar(), R.string.drawer_open, R.string.drawer_close);
    }

    protected void makeNavigationBarColored() {
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.navBarColor));
    }
}