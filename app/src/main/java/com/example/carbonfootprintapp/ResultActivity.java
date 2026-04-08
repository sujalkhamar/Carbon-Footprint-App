package com.example.carbonfootprintapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView carbonValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        carbonValue = findViewById(R.id.carbonValue);

        double carbon = getIntent().getDoubleExtra("carbon", 0);

        carbonValue.setText(String.format("%.2f kg CO2", carbon));
    }
}