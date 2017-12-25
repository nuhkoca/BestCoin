package com.mobilemovement.bestcoin.utils;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import com.mobilemovement.bestcoin.R;

/**
 * Created by nuhkoca on 7.12.2017.
 */

public class TransparentUtils {

    /**
     *  Makes navigation bar transparent only with the {@param appCompatActivity
     */

    public static void makeNavigationBarTransparentOnly(AppCompatActivity activity){
        Window w = activity.getWindow();

        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        w.setNavigationBarColor(ContextCompat.getColor(activity.getApplicationContext(), R.color.navBarColor));
    }

    /**
     *  Makes entire transparent with the {@param appCompatActivity
     */

    public static void makeCompleteTransparent(AppCompatActivity activity){
        Window w = activity.getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}
