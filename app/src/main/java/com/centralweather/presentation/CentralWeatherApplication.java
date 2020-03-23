package com.centralweather.presentation;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Amber_Chen on 2020-03-18.
 */
public class CentralWeatherApplication  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

    }
}