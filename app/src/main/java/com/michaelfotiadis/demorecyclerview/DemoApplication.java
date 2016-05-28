package com.michaelfotiadis.demorecyclerview;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.michaelfotiadis.demorecyclerview.utils.AppLog;

import io.fabric.sdk.android.Fabric;

/**
 *
 */
public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        AppLog.d("Application initialised");
    }

}
