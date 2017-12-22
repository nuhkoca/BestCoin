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

    /**
     * An instance of Holder Activity to getSupportFragmentManager {@param holderActivity}
     * An instance of a Fragment will be created {@param newFragment}
     * A tag to able to find a Fragment {@param tag}
     */

    public static void replaceFragment(HolderActivity holderActivity, Fragment fragment) {
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = holderActivity.getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped && manager.findFragmentByTag(backStateName) == null) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(FRAGMENT_HOLDER_ID, fragment, backStateName);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }
}