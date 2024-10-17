// SplashActivity.java
package com.quickprog.guia01;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 3000; // 3 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // Asegúrate de tener el layout correcto

        new Handler().postDelayed(() -> {
            // Después de 3 segundos, iniciar el LoginActivity
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Cerrar el SplashActivity
        }, SPLASH_DURATION);
    }
}
