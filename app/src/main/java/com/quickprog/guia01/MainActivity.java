package com.quickprog.guia01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView welcomeTextView;
    private Button aboutButton, processButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar las vistas
        welcomeTextView = findViewById(R.id.welcomeTextView);
        aboutButton = findViewById(R.id.aboutButton);
        processButton = findViewById(R.id.processButton);

        // Obtener el nombre del usuario desde el Intent (si se pasó desde LoginActivity)
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        // Actualizar el saludo con el nombre del usuario
        if (username != null) {
            welcomeTextView.setText("Bienvenido, " + username);
        }

        // Asignar acciones a los botones
        aboutButton.setOnClickListener(v -> {
            // Ir a la actividad "Acerca de"
            Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(aboutIntent);
        });

        processButton.setOnClickListener(v -> {
            // Ir a la actividad "Procesos"
            Intent processIntent = new Intent(MainActivity.this, ProcessActivity.class);
            startActivity(processIntent);
        });
    }
}