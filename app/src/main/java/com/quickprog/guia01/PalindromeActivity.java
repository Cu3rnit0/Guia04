package com.quickprog.guia01;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PalindromeActivity extends AppCompatActivity {

    private EditText textEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindrome);

        textEditText = findViewById(R.id.textEditText);
        resultTextView = findViewById(R.id.resultTextView);
        Button checkButton = findViewById(R.id.checkButton);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfPalindrome();
            }
        });
    }

    private void checkIfPalindrome() {
        String input = textEditText.getText().toString();

        if (input.isEmpty()) {
            resultTextView.setText(R.string.empty_text_error);
            return;
        }

        String cleanedInput = input.replaceAll("\\s+", "").toLowerCase();
        boolean isPalindrome = isPalindrome(cleanedInput);

        if (isPalindrome) {
            resultTextView.setText(getString(R.string.palindrome_message, input));
        } else {
            resultTextView.setText(getString(R.string.not_palindrome_message, input));
        }
    }

    private boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}