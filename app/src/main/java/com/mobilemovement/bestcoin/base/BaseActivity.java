package com.mobilemovement.bestcoin.base;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
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

/**
 * Created by nuhkoca on 3.12.2017.
 */

public abstract class BaseActivity<B extends ViewDataBinding> extends AppCompatActivity {

    protected B activityDataBinding;
    protected ActionBarDrawerToggle mDrawerToggle;
    protected DrawerLayout mDrawerLayout;
    protected NavigationView mNavigationView;
    protected CollapsingToolbarLayout mCollapsingToolbarLayout;
    protected Toolbar mToolbar;
    protected ImageView mImageView;

    protected void initUI(Toolbar toolbar, DrawerLayout drawerLayout, CollapsingToolbarLayout collapsingToolbarLayout, NavigationView navigationView, ActionBarDrawerToggle actionBarDrawerToggle, ImageView imageView) {
        mToolbar = toolbar;
        setSupportActionBar(toolbar);

        mNavigationView = navigationView;
        setupDrawerContent();

        mDrawerToggle = actionBarDrawerToggle;

        mDrawerLayout = drawerLayout;
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        mImageView = imageView;

        mCollapsingToolbarLayout = collapsingToolbarLayout;

        CollapsingToolbarLayoutBackgroundUtils.changeBackground(mImageView, R.drawable.currency_background, this);

        TransparentUtils.makeNavigationBarTransparentOnly(this);
    }

    private void setupDrawerContent() {
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
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

        mCollapsingToolbarLayout.setTitle(collapsinToolbarLayoutTitle);
        CollapsingToolbarLayoutBackgroundUtils.changeBackground(mImageView, imageId, this);

        if (fragment != null) {
            FragmentUtils.replaceFragment((HolderActivity) this, fragment);
        }

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawerLayout.closeDrawers();
    }
}