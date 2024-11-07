package com.example.admin.movieapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Admin on 9/21/2018.
 */

public class Utils {
    public static boolean isInternet(Context ctxt){
        ConnectivityManager cm=(ConnectivityManager) ctxt.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni=cm.getActiveNetworkInfo();
        if(ni!=null&&ni.isConnectedOrConnecting()){
            return true;
        }
        return false;
    }
}
