// Chapter 1: Introduction to Android Development
// Topic: the Activity lifecycle -- why apps are event-driven, not
// "run to completion" programs like a typical desktop app.
//
// This file is illustrative: it demonstrates the SHAPE of an Android
// Activity and its lifecycle callbacks. It depends on the Android SDK
// (android.app.Activity, android.os.Bundle, android.util.Log) and is
// meant to be dropped into an Android Studio project, not compiled
// standalone with plain javac.

/*
 UNSOLVED (exercise) -- compiles under the Android SDK, but violates
 the lifecycle contract: it does heavy work (a fake "load user data"
 loop) directly inside onCreate(), which blocks the main/UI thread.
 Task: figure out why this makes the app freeze or show an ANR
 ("Application Not Responding") dialog, then fix it in the SOLVED version.

 public class MainActivityBroken extends Activity {
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         // bug: this runs on the UI thread and blocks rendering
         for (int i = 0; i < 2_000_000_000; i++) {
             // pretend this is "loading user data"
         }
     }
 }
*/

// SOLVED
package com.codingcompany.androidbeginners.ch01;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main); // real project: inflate a layout
        Log.d(TAG, "onCreate: the Activity is being created");

        // Heavy/slow work is moved OFF the UI thread, so the screen can
        // still render immediately.
        new Thread(this::loadUserDataInBackground).start();
    }

    private void loadUserDataInBackground() {
        // Simulate slow work (e.g. a network call or disk read) without
        // freezing the UI thread.
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {
        }
        Log.d(TAG, "Background load finished");

        // Hop back onto the main thread before touching any UI.
        new Handler(Looper.getMainLooper()).post(() ->
                Log.d(TAG, "Back on the UI thread, safe to update views"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Activity is becoming visible");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Activity is now in the foreground and interactive");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: another Activity is taking focus -- save critical state here");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Activity is no longer visible");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Activity is being torn down");
    }
}
