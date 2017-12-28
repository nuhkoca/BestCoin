package com.mobilemovement.bestcoin.utils;

import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by nuhkoca on 18.12.2017.

 * This class detects configuration changes
 */

public class OrientationUtils {

    /**
     *
     * @param context to reach out to getResources() class
     * @return int value
     */

    public static int detectOrientation(Context context) {
        int configuration = context.getResources().getConfiguration().orientation;

        if (configuration == Configuration.ORIENTATION_PORTRAIT) {
            return 1;
        } else {
            return 2;
        }
    }
}
