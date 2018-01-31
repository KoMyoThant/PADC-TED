package com.ps.ted;

import android.app.Application;
import android.content.Context;

/**
 * Created by pyaesone on 1/22/18.
 */

public class TEDApp extends Application {

    public static final String LOG_TAG = "TEDApp";

//    private static Context tedAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
//        tedAppContext = getContext();
    }
}
