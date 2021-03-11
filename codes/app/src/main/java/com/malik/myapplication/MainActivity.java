package com.malik.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String CALCULATION = "activity.1.100";
private EditText editHeight;
private EditText editWeight;
private Button button;
private double ibm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editHeight = findViewById(R.id.TakingHeight);
        editWeight = findViewById(R.id.TakingWeight);
        button = findViewById(R.id.button_activity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editHeight.getText().toString().length() == 0){
                    editHeight.setText("1");
                }
                if(editWeight.getText().toString().length() == 0){
                    editWeight.setText("1");
                }

                double height = Double.parseDouble(editHeight.getText().toString());
                double weight = Double.parseDouble(editWeight.getText().toString());

                double ibmPure = weight / (height * height);

                ibm = Math.round(ibmPure* 10) / 10.0;




                openActivity2();
            }
        });
    }

    public void openActivity2(){

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(CALCULATION,ibm);
        startActivity(intent);
    }

}
