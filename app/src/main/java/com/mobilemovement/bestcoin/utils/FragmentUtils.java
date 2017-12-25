package com.mobilemovement.bestcoin.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.mobilemovement.bestcoin.HolderActivity;
import com.mobilemovement.bestcoin.R;

/**
 * Created by nuhkoca on 4.12.2017.
 */

public class FragmentUtils {

    private static final int FRAGMENT_HOLDER_ID = R.id.main_fragment_holder;
    private static FragmentManager mFragmentManager;

    /**
     * An instance of Holder Activity to getSupportFragmentManager {@param holderActivity}
     * An instance of a Fragment will be created {@param newFragment}
     * A tag to able to find a Fragment {@param tag}
     */

    public static void replaceFragment(HolderActivity holderActivity, Fragment fragment) {
        String backStateName = fragment.getClass().getName();

        mFragmentManager = holderActivity.getSupportFragmentManager();
        boolean fragmentPopped = mFragmentManager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped && mFragmentManager.findFragmentByTag(backStateName) == null) { //fragment not in back stack, create it.
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            ft.replace(FRAGMENT_HOLDER_ID, fragment, backStateName);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    /**
     *
     * @return count of fragments that Fragment Manager holds.
     */

    public static int getBackStackEntryCount() {
        return mFragmentManager.getBackStackEntryCount();
    }

    /**
     * remove all fragments from the backstack
     */

    public static void removeAllFragmentsFromBackStack() {
        for (int i = 0; i < mFragmentManager.getBackStackEntryCount(); i++) {
            mFragmentManager.popBackStack();
        }
    }
}