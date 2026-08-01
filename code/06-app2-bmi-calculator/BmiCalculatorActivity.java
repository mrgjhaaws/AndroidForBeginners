// Chapter 6: Android App #2 -- Body Mass Index (BMI) Calculator
// Topic: reading EditText input, validating it, and displaying a result.

/*
 UNSOLVED (exercise) -- crashes with NumberFormatException if the
 fields are empty, and produces "Infinity" for a height of 0.
 Task: find both problems and fix them in the SOLVED version.

 calculateButton.setOnClickListener(v -> {
     double weight = Double.parseDouble(weightInput.getText().toString()); // <-- bug: no empty check
     double heightCm = Double.parseDouble(heightInput.getText().toString());
     double heightM = heightCm / 100.0;
     double bmi = weight / (heightM * heightM); // <-- bug: no zero-height check
     resultText.setText("BMI: " + bmi);
 });
*/

// SOLVED
package com.codingcompany.androidbeginners.ch06;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BmiCalculatorActivity extends Activity {

    private EditText weightInput;
    private EditText heightInput;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        resultText = findViewById(R.id.resultText);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(v -> calculateBmi());
    }

    private void calculateBmi() {
        Double weight = parseOrNull(weightInput.getText().toString());
        Double heightCm = parseOrNull(heightInput.getText().toString());

        if (weight == null || heightCm == null) {
            resultText.setText("Please enter both weight and height.");
            return;
        }
        if (heightCm <= 0) {
            resultText.setText("Height must be greater than zero.");
            return;
        }

        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);

        resultText.setText(String.format("BMI: %.1f (%s)", bmi, category(bmi)));
    }

    /** Returns null instead of throwing, so the caller can show a friendly message. */
    private Double parseOrNull(String text) {
        if (text == null || text.trim().isEmpty()) {
            return null;
        }
        try {
            return Double.parseDouble(text.trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private String category(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25.0) return "Normal";
        if (bmi < 30.0) return "Overweight";
        return "Obese";
    }
}

/*
 res/layout/activity_bmi.xml
 -----------------------------
 <?xml version="1.0" encoding="utf-8"?>
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
     android:layout_width="match_parent"
     android:layout_height="match_parent"
     android:orientation="vertical"
     android:padding="24dp">

     <EditText
         android:id="@+id/weightInput"
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         android:hint="Weight (kg)"
         android:inputType="numberDecimal" />

     <EditText
         android:id="@+id/heightInput"
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         android:hint="Height (cm)"
         android:inputType="numberDecimal" />

     <Button
         android:id="@+id/calculateButton"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:text="Calculate BMI" />

     <TextView
         android:id="@+id/resultText"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:textSize="18sp"
         android:layout_marginTop="16dp" />

 </LinearLayout>
*/
