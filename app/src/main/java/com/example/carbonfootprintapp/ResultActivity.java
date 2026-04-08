package com.example.carbonfootprintapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ResultActivity extends AppCompatActivity {

    TextView carbonValue, tipText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        carbonValue = findViewById(R.id.carbonValue);
        tipText = findViewById(R.id.tipText);

        double carbon = getIntent().getDoubleExtra("carbon", 0);

        carbonValue.setText(String.format(Locale.US, "%.2f kg CO2", carbon));
        showTip(carbon);
    }

    private void showTip(double carbon) {
        if (carbon < 5) {
            tipText.setText("Great job! Your carbon footprint is low.");
        } else if (carbon < 10) {
            tipText.setText("Try to reduce your carbon footprint.");
        } else {
            tipText.setText("High carbon footprint! Use eco-friendly habits.");
        }
    }
}
