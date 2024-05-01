package com.example.a21loginscreen;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (isValidCredentials(email, password)) {
                    // Replace the following toast with your authentication logic
                    Toast.makeText(MainActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Dummy method to validate email and password
    private boolean isValidCredentials(String email, String password) {
        // Check if name, email, and password are not empty
        if (email.isEmpty() || password.isEmpty()) {
            return false;
        }

        // Check if email format is valid
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false;
        }




        // If all validations pass, return true
        return true;
    }
}
