package com.example.polynation;

import android.app.Application;

public class PolyNationApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BackgroundCacheLoader.getInstance(this).start();
    }
}
