package com.example.bindingadapter.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Constants {

    public static String BASE_URL = "https://jsonplaceholder.typicode.com/" ;
    public static String TAG = "TAG";

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            // There are no active networks.
            return false;
        } else {
            return true;
        }
    }


}
