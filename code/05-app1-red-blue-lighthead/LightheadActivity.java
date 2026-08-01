// Chapter 5: Android App #1 -- Red/Blue Lighthead
// Topic: click listeners, boolean state, and updating a view.

/*
 UNSOLVED (exercise) -- compiles, but the button never visually
 changes anything.
 Task: find the bug. Hint: it's not in the listener logic itself.

 rootLayout.setOnClickListener(v -> {
     isRed = !isRed;
     int color = isRed ? Color.RED : Color.BLUE;
     // bug: this creates a NEW View reference to a different layout
     // instead of updating the one actually on screen
     View someOtherView = new View(MainActivity.this);
     someOtherView.setBackgroundColor(color);
 });
*/

// SOLVED
package com.codingcompany.androidbeginners.ch05;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LightheadActivity extends Activity {

    private boolean isRed = true;
    private View rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lighthead);

        rootLayout = findViewById(R.id.rootLayout);
        Button toggleButton = findViewById(R.id.toggleButton);

        applyColor(); // set the initial color before any tap happens

        toggleButton.setOnClickListener(v -> {
            isRed = !isRed;
            applyColor();
        });
    }

    private void applyColor() {
        int color = isRed ? Color.RED : Color.BLUE;
        rootLayout.setBackgroundColor(color);
    }
}

/*
 res/layout/activity_lighthead.xml
 ----------------------------------
 <?xml version="1.0" encoding="utf-8"?>
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
     android:id="@+id/rootLayout"
     android:layout_width="match_parent"
     android:layout_height="match_parent"
     android:orientation="vertical"
     android:gravity="center">

     <Button
         android:id="@+id/toggleButton"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:text="Toggle Color" />

 </LinearLayout>
*/
