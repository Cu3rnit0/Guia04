package com.quickprog.guia01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RussianMultiplicationActivity extends AppCompatActivity {
    private EditText number1EditText;
    private EditText number2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_russian_multiplication);

        // Inicializar los elementos de la interfaz
        number1EditText = findViewById(R.id.number1EditText);
        number2EditText = findViewById(R.id.number2EditText);
        Button calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        // Configurar el evento del botón
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMultiplicacionRusa();
            }
        });
    }

    private void calcularMultiplicacionRusa() {
        String number1Text = number1EditText.getText().toString();
        String number2Text = number2EditText.getText().toString();

        // Validar campos vacíos
        if (number1Text.isEmpty() || number2Text.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        int number1 = Integer.parseInt(number1Text);
        int number2 = Integer.parseInt(number2Text);

        // Lógica de la multiplicación rusa
        int result = multiplicacionRusa(number1, number2);

        // Mostrar el resultado
        resultTextView.setText("Resultado: " + result);
    }

    private int multiplicacionRusa(int a, int b) {
        int resultado = 0;

        while (a > 0) {
            if (a % 2 == 1) { // Si es impar
                resultado += b;
            }
            a /= 2; // Dividir a entre 2
            b *= 2; // Multiplicar b por 2
        }

        return resultado;
    }
}