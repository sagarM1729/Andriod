package com.example.a28form;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private RadioGroup radioGroupGender;
    private CheckBox checkBoxTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBoxTerms = findViewById(R.id.checkBoxTerms);

        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String name = editTextName.getText().toString();

        int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
        String gender = "";
        if (selectedGenderId != -1) {
            RadioButton radioButton = findViewById(selectedGenderId);
            gender = radioButton.getText().toString();
        }

        boolean termsAccepted = checkBoxTerms.isChecked();

        // Perform validation if needed
        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (selectedGenderId == -1) {
            Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!termsAccepted) {
            Toast.makeText(this, "Please accept the terms and conditions", Toast.LENGTH_SHORT).show();
            return;
        }

        // Process the form data
        // For example, you can send the data to a server or save it locally
        // Here, we just display a toast with the collected information
        String message = "Name: " + name + "\nGender: " + gender + "\nTerms Accepted: " + termsAccepted;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
