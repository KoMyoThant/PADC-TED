package com.ps.ted.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.ps.ted.TEDApp;

/**
 * Created by pyaesone on 1/31/18.
 */

public class ConfigUtils {

    private static final String KEY_PAGE_INDEX = "KEY_PAGE_INDEX";

    private static ConfigUtils mObjInstance;

    private SharedPreferences mSharedPreferences;

    private ConfigUtils(Context context) {
        mSharedPreferences = context.getSharedPreferences("ConfigUtils", Context.MODE_PRIVATE);
    }

    public static ConfigUtils getInstance(Context context) {
        if (mObjInstance == null) {
            mObjInstance = new ConfigUtils(context);
        }
        return mObjInstance;
    }


    public void savePageIndex(int pageIndex){
        mSharedPreferences.edit().putInt(KEY_PAGE_INDEX,pageIndex).apply();
    }

    public int loadPageIndex(){
        return mSharedPreferences.getInt(KEY_PAGE_INDEX,1);
    }
}
