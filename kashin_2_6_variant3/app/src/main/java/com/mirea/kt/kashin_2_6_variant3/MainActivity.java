package com.mirea.kt.kashin_2_6_variant3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText startEditText;
    private EditText endEditText;
    private EditText divisorEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startEditText = findViewById(R.id.startEditText);
        endEditText = findViewById(R.id.endEditText);
        divisorEditText = findViewById(R.id.divisorEditText);
        Button searchButton = findViewById(R.id.searchButton);
        resultTextView = findViewById(R.id.resultTextView);

        searchButton.setOnClickListener(v -> {
            String startText = startEditText.getText().toString().trim();
            String endText = endEditText.getText().toString().trim();
            String divisorText = divisorEditText.getText().toString().trim();

            if (startText.isEmpty() || endText.isEmpty() || divisorText.isEmpty()) {
                Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "All fields are required");
                return;
            }

            int start = Integer.parseInt(startText);
            int end = Integer.parseInt(endText);
            int divisor = Integer.parseInt(divisorText);

            List<Integer> divisibleNumbers = new ArrayList<>();

            if (divisor == 0) {
                Toast.makeText(getApplicationContext(), "Divisor cannot be equal 0", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "Divisor cannot be equal 0");
            } else {
                for (int i = start; i <= end; i++) {
                    if (i % divisor == 0) {
                        divisibleNumbers.add(i);
                    }
                }

                StringBuilder result = new StringBuilder();
                for (int num : divisibleNumbers) {
                    result.append(num).append("\n");
                }
                resultTextView.setText(result.toString());
                Log.d(TAG, "Divisible numbers found: " + result);
            }
        });
    }
}