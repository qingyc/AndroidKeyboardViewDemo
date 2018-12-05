package com.example.ableqing.androidkeyboardviewdemo;

import android.app.Application;

/**
 *
 * 类说明:
 *
 * @author qing
 * @time 31/01/2018 17:59
 */
public class MyApp extends Application {

    private static MyApp sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static MyApp getInstance() {
        return sInstance;
    }
}
