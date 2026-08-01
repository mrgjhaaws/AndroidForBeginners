// Chapter 7: Android App #3 -- Simple Dice Roller
// Topic: randomness, and mapping a value to a resource cleanly.

/*
 UNSOLVED (exercise) -- can crash with a resource-not-found error, or
 silently show the wrong face.
 Task: nextInt(6) returns 0-5, but this code treats it as 1-6 directly.
 Find the off-by-one bug.

 int roll = random.nextInt(6);           // <-- 0..5, but...
 dieImage.setImageResource(dieFaces[roll]); // ...used as if it were 1..6
*/

// SOLVED
package com.codingcompany.androidbeginners.ch07;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class DiceRollerActivity extends Activity {

    private final Random random = new Random();

    // Index 0 unused so dieFaces[roll] lines up naturally with a 1-6 roll.
    private final int[] dieFaces = {
            0, // unused placeholder
            R.drawable.die_1,
            R.drawable.die_2,
            R.drawable.die_3,
            R.drawable.die_4,
            R.drawable.die_5,
            R.drawable.die_6,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        ImageView dieImage = findViewById(R.id.dieImage);
        Button rollButton = findViewById(R.id.rollButton);

        rollButton.setOnClickListener(v -> {
            int roll = random.nextInt(6) + 1; // 1..6 inclusive
            dieImage.setImageResource(dieFaces[roll]);
        });
    }
}

/*
 res/layout/activity_dice.xml
 ------------------------------
 <?xml version="1.0" encoding="utf-8"?>
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
     android:layout_width="match_parent"
     android:layout_height="match_parent"
     android:orientation="vertical"
     android:gravity="center">

     <ImageView
         android:id="@+id/dieImage"
         android:layout_width="150dp"
         android:layout_height="150dp"
         android:src="@drawable/die_1"
         android:contentDescription="@string/die_face" />

     <Button
         android:id="@+id/rollButton"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:layout_marginTop="16dp"
         android:text="Roll" />

 </LinearLayout>
*/
