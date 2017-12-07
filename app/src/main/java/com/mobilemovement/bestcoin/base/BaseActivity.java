package com.mobilemovement.bestcoin.base;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mobilemovement.bestcoin.R;
import com.mobilemovement.bestcoin.coinlist.CoinListFragment;
import com.mobilemovement.bestcoin.utils.TransparentMaker;

/**
 * Created by nuhkoca on 3.12.2017.
 */

public abstract class BaseActivity<B extends ViewDataBinding> extends AppCompatActivity {

    protected B activityDataBinding;
    protected ActionBarDrawerToggle mDrawerToggle;
    protected DrawerLayout mDrawerLayout;
    protected NavigationView mNavigationView;
    protected Toolbar mToolbar;

    protected void initUI(Toolbar toolbar, DrawerLayout drawerLayout, NavigationView navigationView, ActionBarDrawerToggle actionBarDrawerToggle) {
        mToolbar = toolbar;
        setSupportActionBar(toolbar);

        mNavigationView = navigationView;
        setupDrawerContent();

        mDrawerToggle = actionBarDrawerToggle;

        mDrawerLayout = drawerLayout;
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        TransparentMaker.makeStatusBarTransparent(this);
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
        Class fragmentClass = null;

        switch (menuItem.getItemId()) {
            case R.id.nav_first_fragment:
                fragmentClass = CoinListFragment.class;
                break;
            case R.id.nav_second_fragment:
                fragmentClass = CoinListFragment.class;
                break;
            case R.id.nav_third_fragment:
                fragmentClass = CoinListFragment.class;
                break;
            default:

        }

        try {
            if (fragmentClass != null) {
                fragment = (Fragment) fragmentClass.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_fragment_holder, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawerLayout.closeDrawers();
    }
}
