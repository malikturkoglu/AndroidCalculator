package com.malik.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Double result = intent.getDoubleExtra(MainActivity.CALCULATION,100);

        TextView showResult = findViewById(R.id.show_calculation);
        showResult.setText(""+result);

        TextView showText = findViewById(R.id.show_text);

        if(result < 18.5) {
            double gainWeight = Math.round((18.5-result)* 10) / 10.0;;
            showText.setText("Underweight: please gain more weight about : " + gainWeight);
        }
        else if((18.5 < result) && result < 24.9){
            showText.setText("Normal: Very Good keep going");
        }
        else if((25 < result) && result < 29.9){
            double lostWeight = Math.round((result-25)* 10) / 10.0;;
            showText.setText("Overweight: Please be careful , you have to lose weight about : "+lostWeight);
        }
        else {
            double lostWeight = Math.round((result-25)* 10) / 10.0;
            showText.setText("Obese: You are in Danger , you must lose weight about : "+lostWeight);
        }


    }
}