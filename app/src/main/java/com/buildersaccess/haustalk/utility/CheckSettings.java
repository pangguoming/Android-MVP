package com.buildersaccess.haustalk.utility;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;

/**
 * Created by pangg_000 on 12/23/2014.
 */
public class CheckSettings {
    private static Context mContext;
    public CheckSettings() {
    }

    public static void init(Context context) {
        mContext=context;
    }

    // 是否有可用网络
    public static boolean isNetworkConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = cm.getActiveNetworkInfo();
        if (network != null) {
            return network.isAvailable();
        }
        return false;
    }
    // Wifi是否可用
    public static boolean isWifiEnable() {
        WifiManager wifiManager = (WifiManager) mContext
                .getSystemService(Context.WIFI_SERVICE);
        return wifiManager.isWifiEnabled();
    }
    // Gps是否可用
    public static boolean isGpsEnable() {
        LocationManager locationManager =
                ((LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE));
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }


}
