package com.example.a24datetime;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView dateAndTimeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TextView
        dateAndTimeTextView = findViewById(R.id.dateAndTimeTextView);

        // Update date and time
        updateDateTime();
    }

    @SuppressLint("SetTextI18n")
    private void updateDateTime() {
        // Get current date and time
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy", Locale.getDefault());
        String formattedDate = dateFormat.format(currentDate);

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String formattedTime = timeFormat.format(currentDate);

        // Display date and time in TextView
        dateAndTimeTextView.setText("Date: " + formattedDate + "\nTime: " + formattedTime);
    }
}
