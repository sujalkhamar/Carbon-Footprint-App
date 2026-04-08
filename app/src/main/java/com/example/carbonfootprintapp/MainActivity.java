package com.example.carbonfootprintapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText travelInput, electricityInput;
    Spinner foodSpinner;
    Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        travelInput = findViewById(R.id.travelInput);
        electricityInput = findViewById(R.id.electricityInput);
        foodSpinner = findViewById(R.id.foodSpinner);
        calculateBtn = findViewById(R.id.calculateBtn);

        // Spinner Data
        String[] foodOptions = {"Vegetarian", "Non-Vegetarian"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                foodOptions
        );
        foodSpinner.setAdapter(adapter);

        // Button Click
        calculateBtn.setOnClickListener(view -> {

            String travelStr = travelInput.getText().toString();
            String electricityStr = electricityInput.getText().toString();

            if (travelStr.isEmpty() || electricityStr.isEmpty()) {
                Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
                return;
            }

            double travel = Double.parseDouble(travelStr);
            double electricity = Double.parseDouble(electricityStr);

            // Calculation
            double travelCarbon = travel * 0.21;
            double electricityCarbon = electricity * 0.5;

            double foodCarbon;
            if (foodSpinner.getSelectedItem().toString().equals("Vegetarian")) {
                foodCarbon = 1.5;
            } else {
                foodCarbon = 3.0;
            }

            double totalCarbon = travelCarbon + electricityCarbon + foodCarbon;

            // Send to Result Activity
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("carbon", totalCarbon);
            startActivity(intent);
        });
    }
}