package com.mobilemovement.bestcoin.utils;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by nuhkoca on 7.12.2017.
 */

public class TransparentUtils {

    /**
     *  Makes activity transparet with the {@param activity
     */

    public static void makeStatusBarTransparent(Activity activity){
        Window w = activity.getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}
