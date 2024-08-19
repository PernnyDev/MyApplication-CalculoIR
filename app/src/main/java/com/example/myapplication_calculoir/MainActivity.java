package com.example.myapplication_calculoir;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText salaryInput;
    private EditText percentageInput;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salaryInput = findViewById(R.id.salaryInput);
        percentageInput = findViewById(R.id.percentageInput);
        resultText = findViewById(R.id.resultText);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateIR();
            }
        });
    }

    private void calculateIR() {
        String salaryStr = salaryInput.getText().toString();
        String percentageStr = percentageInput.getText().toString();

        if (!salaryStr.isEmpty() && !percentageStr.isEmpty()) {
            double salary = Double.parseDouble(salaryStr);
            double percentage = Double.parseDouble(percentageStr);
            double ir = salary * (percentage / 100);
            resultText.setText(String.format("IR to pay: %.2f", ir));
        } else {
            resultText.setText("Please enter both values");
        }
    }
}