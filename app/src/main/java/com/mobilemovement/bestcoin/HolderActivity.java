package com.mobilemovement.bestcoin;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import com.mobilemovement.bestcoin.base.BaseActivity;
import com.mobilemovement.bestcoin.coinlist.CoinListFragment;
import com.mobilemovement.bestcoin.databinding.ActivityHolderBinding;
import com.mobilemovement.bestcoin.utils.FragmentUtils;

public class HolderActivity extends BaseActivity<ActivityHolderBinding> {

    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_holder);

        mActionBarDrawerToggle = setupDrawerToggle();

        initUI(activityDataBinding.ahToolbarLayout.toolbar,
                activityDataBinding.dlHolderActivity,
                activityDataBinding.nvItemHolder,
                mActionBarDrawerToggle);

        activityDataBinding.ahToolbarLayout.ctlToolbarLayout.setTitle(getString(R.string.fragment_coin_list));

        Fragment mImitationFragmentOf = new CoinListFragment();

        FragmentUtils.replaceFragment(this, mImitationFragmentOf);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mActionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, activityDataBinding.dlHolderActivity, activityDataBinding.ahToolbarLayout.toolbar, R.string.drawer_open, R.string.drawer_close);
    }
}