package com.mobilemovement.bestcoin.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.mobilemovement.bestcoin.BuildConfig;
import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by nuhkoca on 20.12.2017.
 */

public class ConnectionUtils {
    public static boolean pulse(Context context) throws IOException {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }

        return networkInfo != null &&
                networkInfo.isConnected() &&
                networkInfo.isConnectedOrConnecting() &&
                networkInfo.isAvailable() ||
                !InetAddress.getByName(BuildConfig.BASEURL).isReachable(5);
    }
}