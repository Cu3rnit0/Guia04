// LoginActivity.java
package  com.quickprog.guia01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // Datos "quemados" (hardcoded) para el inicio de sesión
    private final String validUsername = "admin"; // Usuario predeterminado
    private final String validPassword = "12345"; // Contraseña predeterminada

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private CheckBox showPasswordCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Asegúrate de que el layout esté correcto

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        showPasswordCheckBox = findViewById(R.id.showPasswordCheckBox);

        // Configuración del checkbox para mostrar/ocultar la contraseña
        showPasswordCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                passwordEditText.setInputType(144); // Mostrar contraseña
            } else {
                passwordEditText.setInputType(129); // Ocultar contraseña
            }
        });

        // Acción del botón de inicio de sesión
        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Verificar si los campos están vacíos
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Por favor, ingresa el usuario y la contraseña", Toast.LENGTH_SHORT).show();
            } else {
                // Validar los datos "quemados"
                if (username.equals(validUsername) && password.equals(validPassword)) {
                    Toast.makeText(LoginActivity.this, "Iniciando sesión...", Toast.LENGTH_SHORT).show();

                    // Redirigir a MainActivity si los datos son correctos
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Cerrar el LoginActivity
                } else {
                    // Mostrar un mensaje de error si los datos son incorrectos
                    Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}