package com.quickprog.guia01;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);

        Button russianMultiplicationButton = findViewById(R.id.russianMultiplicationButton);
        Button primeNumberButton = findViewById(R.id.primeNumberButton);
        Button palindromeButton = findViewById(R.id.palindromeButton);
        Button aboutButton = findViewById(R.id.aboutButton);

        russianMultiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProcessActivity.this, RussianMultiplicationActivity.class);
                startActivity(intent);
            }
        });

        primeNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProcessActivity.this, PrimeNumberActivity.class);
                startActivity(intent);
            }
        });

        palindromeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProcessActivity.this, PalindromeActivity.class);
                startActivity(intent);
            }
        });

        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProcessActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}