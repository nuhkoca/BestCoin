package com.mobilemovement.bestcoin.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import com.mobilemovement.bestcoin.BuildConfig;
import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by nuhkoca on 20.12.2017.
 */

public class ConnectionUtils {

    private static final int TIMEOUT_DURATION = 5;

    /**
     *
     * @param context from activity or fragment
     * @return true if conditions
     */

    public static boolean pulse(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }

        return networkInfo != null &&
                networkInfo.isConnected() &&
                networkInfo.isConnectedOrConnecting() &&
                networkInfo.isAvailable() &&
                !wifiIsConnectedButNoInternet(BuildConfig.BASEURL);
    }

    /**
     *
     * @param hostName to check accessing
     * @return true if conditions
     */

    @SuppressLint({"StaticFieldLeak"})
    private static boolean wifiIsConnectedButNoInternet(final String hostName) {
        new AsyncTask<Boolean, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Boolean... booleans) {
                try {
                    return InetAddress.getByName(hostName).isReachable(TIMEOUT_DURATION);
                } catch (IOException e) {
                    return null;
                }
            }
        }.execute();

        return false;
    }
}