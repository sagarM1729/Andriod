package com.example.a15table;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String[][] data = {
            {"Java", "James Gosling", "https://www.java.com"},
            {"Python", "Guido van Rossum", "https://www.python.org"},
            {"C++", "Bjarne Stroustrup ", "https://cplusplus.com"},
    };

    private final String[] columnTitles = {"Langauge", "Creator(s)", "URL"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Add column title row
        TableRow titleRow = new TableRow(this);
        titleRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        for (int i = 0; i < columnTitles.length; i++) {
            TextView titleTextView = new TextView(this);
            titleTextView.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            titleTextView.setText(columnTitles[i]);
            titleTextView.setGravity(Gravity.CENTER);
            titleTextView.setPadding(20, 20, 20, 20);
            titleRow.addView(titleTextView);
        }
        tableLayout.addView(titleRow);

        for (int i = 0; i < data.length; i++) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            for (int j = 0; j < data[i].length; j++) {
                TextView textView = new TextView(this);
                textView.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                textView.setText(data[i][j]);
                textView.setGravity(Gravity.CENTER);
                textView.setPadding(20, 20, 20, 20);

                if (j == data[i].length - 1) { // If it's the last column (URL column)
                    final String url = data[i][j];
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            openUrl(url);
                        }
                    });

                }

                tableRow.addView(textView);
            }
            tableLayout.addView(tableRow);
        }
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}

