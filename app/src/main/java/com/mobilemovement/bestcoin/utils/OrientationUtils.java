package com.mobilemovement.bestcoin.utils;

import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by nuhkoca on 18.12.2017.
 */

public class OrientationUtils {
    public static int detectOrientation(Context context) {
        int configuration = context.getResources().getConfiguration().orientation;

        if (configuration == Configuration.ORIENTATION_PORTRAIT) {
            return 1;
        } else {
            return 2;
        }
    }
}
