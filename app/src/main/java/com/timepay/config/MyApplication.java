package com.timepay.config;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.crashlytics.android.Crashlytics;
import com.timepay.utils.ReleaseTree;
import com.timepay.utils.TypefaceUtil;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

public class MyApplication extends Application {

    public MyApplication() {
    }


    @Override
    public void onCreate() {
        super.onCreate();

        try {
            TypefaceUtil.setDefaultFont(getApplicationContext(), "SERIF", "fonts/Roboto-Light.ttf");
        } catch (Exception e) {
            e.printStackTrace();
        }

        final Fabric fabric = new Fabric.Builder(this)
                .kits(new Crashlytics())
                .debuggable(true)
                .build();
        Fabric.with(fabric);

//        if (BuildConfig.DEBUG) {
//            Timber.plant(new Timber.DebugTree());
//        } else {
//            Timber.plant(new ReleaseTree());
//        }

        Timber.plant(new ReleaseTree());

    }


    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
