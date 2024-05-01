package com.example.a21signup;

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

    private EditText editTextName, editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonSignUp = findViewById(R.id.buttonSignUp);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (isValidSignUp(name, email, password)) {
                    // Replace the following toast with your sign-up logic
                    Toast.makeText(MainActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid details. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Dummy method to validate sign-up details
    // Method to validate sign-up details
    private boolean isValidSignUp(String name, String email, String password) {
        // Check if name, email, and password are not empty
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return false;
        }

        // Check if email format is valid
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return false;
        }

        // Check if password length is at least 6 characters
        if (password.length() < 6) {
            return false;
        }

        // Add additional password strength requirements if needed (e.g., at least one uppercase letter, one digit, etc.)

        // If all validations pass, return true
        return true;
    }

}
