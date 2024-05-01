package com.example.a9malefemale;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        imageView = findViewById(R.id.image_view);

        // Set a listener for radio button changes
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Check which radio button is selected
                if (checkedId == R.id.male_button) {
                    // Set image for male
                    imageView.setImageResource(R.drawable.male);
                } else if (checkedId == R.id.female_button) {
                    // Set image for female
                    imageView.setImageResource(R.drawable.female);
                }
            }
        });

    }
}
