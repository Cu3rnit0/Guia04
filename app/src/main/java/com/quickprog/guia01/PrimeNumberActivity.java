package com.quickprog.guia01;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PrimeNumberActivity extends AppCompatActivity {

    private EditText numberEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_number);

        numberEditText = findViewById(R.id.numberEditText);
        resultTextView = findViewById(R.id.resultTextView);
        Button checkButton = findViewById(R.id.checkButton);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfPrime();
            }
        });
    }

    private void checkIfPrime() {
        String input = numberEditText.getText().toString();

        if (input.isEmpty()) {
            resultTextView.setText(R.string.empty_number_error);
            return;
        }

        int number = Integer.parseInt(input);
        boolean isPrime = isPrimeNumber(number);

        if (isPrime) {
            resultTextView.setText(getString(R.string.prime_number_message, number));
        } else {
            resultTextView.setText(getString(R.string.not_prime_number_message, number));
        }
    }

    private boolean isPrimeNumber(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}