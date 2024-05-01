package com.example.a1buttons;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonTopLeft = findViewById(R.id.buttonTopLeft);
        Button buttonTopRight = findViewById(R.id.buttonTopRight);
        Button buttonBottomLeft = findViewById(R.id.buttonBottomLeft);
        Button buttonBottomRight = findViewById(R.id.buttonBottomRight);
        Button buttonCenter1 = findViewById(R.id.buttonCenter1);
        Button buttonCenter2 = findViewById(R.id.buttonCenter2);
        Button buttonCenter3 = findViewById(R.id.buttonCenter3);

        buttonTopLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("button 1");
            }
        });

        // Repeat the same for other buttons...
        buttonTopRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("button 2");
            }
        });
        buttonBottomLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("button 6");
            }
        });
        buttonBottomRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("button 7");
            }
        });
        buttonCenter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("button 3");
            }
        });
        buttonCenter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("button 4");
            }
        });
        buttonCenter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("button 5");
            }
        });

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
