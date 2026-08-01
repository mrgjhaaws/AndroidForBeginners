// Chapter 3: Test Drive: The Hello World App
// Topic: connecting an XML layout to a Java Activity.
//
// Paired with: res/layout/activity_main.xml (below, as a comment block,
// since this repo's code files are single-file per concept).

/*
 UNSOLVED (exercise) -- will crash at runtime with a
 ClassCastException or a "resource not found" error.
 Task: the id used in findViewById() doesn't match the id declared in
 the XML layout. Find the mismatch.

 // XML has: android:id="@+id/greetingText"
 TextView greeting = findViewById(R.id.greeting_text); // <-- bug: wrong id
 greeting.setText("Hello, Android!");
*/

// SOLVED
package com.codingcompany.androidbeginners.ch03;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HelloWorldActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Matches android:id="@+id/greetingText" in the XML below
        TextView greeting = findViewById(R.id.greetingText);
        Button sayHelloButton = findViewById(R.id.sayHelloButton);

        sayHelloButton.setOnClickListener(v ->
                greeting.setText("Hello, Android! You tapped the button."));
    }
}

/*
 res/layout/activity_main.xml
 -----------------------------
 <?xml version="1.0" encoding="utf-8"?>
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
     android:layout_width="match_parent"
     android:layout_height="match_parent"
     android:orientation="vertical"
     android:padding="24dp"
     android:gravity="center">

     <TextView
         android:id="@+id/greetingText"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:text="Hello, world!"
         android:textSize="20sp" />

     <Button
         android:id="@+id/sayHelloButton"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:layout_marginTop="16dp"
         android:text="Say Hello" />

 </LinearLayout>
*/
