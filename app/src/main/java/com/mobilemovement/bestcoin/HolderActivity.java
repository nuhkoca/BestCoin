package com.mobilemovement.bestcoin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.mobilemovement.bestcoin.base.BaseActivity;
import com.mobilemovement.bestcoin.databinding.ActivityHolderBinding;
import com.mobilemovement.bestcoin.network.activity.NoInternetActivity;
import com.mobilemovement.bestcoin.utils.ConnectionUtils;
import com.mobilemovement.bestcoin.utils.FragmentUtils;
import com.mobilemovement.bestcoin.view.currencylist.CurrencyListFragment;

import timber.log.Timber;

public class HolderActivity extends BaseActivity<ActivityHolderBinding> {

    private static long backPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean isConnected = ConnectionUtils.pulse(this);

        if (!isConnected) {
            Timber.d("No internet connection");

            Intent noInternetIntent = new Intent(HolderActivity.this, NoInternetActivity.class);
            startActivity(noInternetIntent);
        }

       Fragment mImitationFragmentOf;
       mImitationFragmentOf = new CurrencyListFragment();

        if (savedInstanceState == null)
            FragmentUtils.replaceFragment(this, mImitationFragmentOf);
    }

    @Override
    public void onBackPressed() {
        int timeDelay = getResources().getInteger(R.integer.time_delay);

        if (backPressed + timeDelay > System.currentTimeMillis()) {
            //System.exit(0);

            int backStackCount = FragmentUtils.getBackStackEntryCount();

            if (backStackCount > 0) {
                FragmentUtils.removeAllFragmentsFromBackStack();
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
    protected Toolbar getToolbar() {
        return activityDataBinding.ahToolbarLayout.toolbar;
    }

    @Override
    protected DrawerLayout getDrawerLayout() {
        return activityDataBinding.dlHolderActivity;
    }

    @Override
    protected NavigationView getNavigationView() {
        return activityDataBinding.ahNavViewLayout.nvItemHolder;
    }

    @Override
    protected CollapsingToolbarLayout getCollapsingToolbarLayout() {
        return activityDataBinding.ahToolbarLayout.ctlToolbarLayout;
    }

    @Override
    protected ImageView getImageViewForCollapsingToolbarLayoutBackground() {
        return activityDataBinding.ahToolbarLayout.ivCtlBackground;
    }
}