package com.timepay.utils;

import android.util.Log;

import androidx.annotation.NonNull;

import com.crashlytics.android.Crashlytics;

import timber.log.Timber;

public class ReleaseTree extends Timber.Tree {
    @Override
    protected void log(int priority, String tag, @NonNull String message, Throwable t) {

        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return;
        }

        // log your crash to your favourite
        // Sending crash report to Firebase CrashAnalytics

        // FirebaseCrash.report(message);
        // FirebaseCrash.report(new Exception(message));

        if (t != null) {
            try {
                message += "\n" + t.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Crashlytics.log(Log.ERROR, tag, message);
    }
}
