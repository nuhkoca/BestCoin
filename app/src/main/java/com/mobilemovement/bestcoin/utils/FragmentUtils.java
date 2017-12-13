package com.mobilemovement.bestcoin.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.mobilemovement.bestcoin.HolderActivity;
import com.mobilemovement.bestcoin.R;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public class FragmentUtils {

    private static final int FRAGMENT_HOLDER_ID = R.id.main_fragment_holder;

    public static void replaceFragment(HolderActivity holderActivity, Fragment newFragment, String tag) {
        Fragment fragment = null;
        Class fragmentClass;

        fragmentClass = newFragment.getClass();

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        if (fragment != null) {
            FragmentManager fragmentManager = holderActivity.getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(FRAGMENT_HOLDER_ID, fragment, tag).commit();
        }
    }
}