package com.example.a3binhex;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView answerTextView;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        answerTextView = findViewById(R.id.answer_textView);
        convertButton = findViewById(R.id.button);

        // Populate the spinner with options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.conversion_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Set click listener for the convert button
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected conversion option from the spinner
                String selectedOption = spinner.getSelectedItem().toString();

                // Get the number from the EditText
                String numberString = ((TextView)findViewById(R.id.number_EditText)).getText().toString().trim();

                // Check if the number field is empty
                if(numberString.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convert the number to integer
                int number = Integer.parseInt(numberString);

                // Perform the conversion based on the selected option
                String result = "";
                switch (selectedOption) {
                    case "Binary":
                        result = Integer.toBinaryString(number);
                        break;
                    case "Hexadecimal":
                        result = Integer.toHexString(number);
                        break;
                    default:
                        // This should never happen, but just in case
                        Toast.makeText(MainActivity.this, "Invalid conversion option", Toast.LENGTH_SHORT).show();
                        return;
                }

                // Update the TextView with the result
                answerTextView.setText(result);
            }
        });
    }
}
