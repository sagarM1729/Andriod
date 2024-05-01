package com.example.a17dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showDialogButton = findViewById(R.id.showDialogButton);
        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the dialog when the button is clicked
                showDialog();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sample Dialog")
                .setMessage("This is a sample dialog.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle positive button click
                        dialog.dismiss(); // Dismiss the dialog
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle negative button click
                        dialog.dismiss(); // Dismiss the dialog
                    }
                })
                .setCancelable(false); // Prevent the dialog from being dismissed when tapping outside of it

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
