package com.example.a23profilepage;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        Button editButton = findViewById(R.id.editButton);

        // Set profile data
        nameTextView.setText("John Doe");
        emailTextView.setText("john.doe@example.com");

        // Handle edit button click
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditProfileDialog();
            }
        });
    }

    private void showEditProfileDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit Profile");

        // Inflate and set the layout for the dialog
        View view = getLayoutInflater().inflate(R.layout.dialog_edit_profile, null);
        builder.setView(view);

        // Find views within the dialog
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final TextView editNameTextView = view.findViewById(R.id.editNameTextView);
        final TextView editEmailTextView = view.findViewById(R.id.editEmailTextView);

        // Populate edit text fields with current data
        editNameTextView.setText(nameTextView.getText());
        editEmailTextView.setText(emailTextView.getText());

        // Set up the buttons and their onClickListeners
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Update profile data with edited values
                nameTextView.setText(editNameTextView.getText());
                emailTextView.setText(editEmailTextView.getText());
                Toast.makeText(MainActivity.this, "Profile updated", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Dismiss the dialog
                dialog.dismiss();
            }
        });

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

