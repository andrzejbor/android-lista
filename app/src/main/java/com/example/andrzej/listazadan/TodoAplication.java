package com.example.andrzej.listazadan;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Andrzej on 25.11.2016.
 */

public class TodoAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
