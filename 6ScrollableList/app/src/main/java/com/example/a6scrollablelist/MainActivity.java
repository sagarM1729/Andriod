package com.example.a6scrollablelist;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] countries = {
            "United States", "United Kingdom", "Canada", "Australia", "Germany", "France", "Italy", "Japan", "China", "India", "Brazil", "Mexico", "South Korea", "Russia", "Spain", "Netherlands", "Switzerland", "Sweden", "Norway", "Denmark"
    };


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ListView
        listView = findViewById(R.id.listView);

        // Create ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);

        // Set adapter to ListView
        listView.setAdapter(adapter);

        // Set click listener for ListView items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the clicked item text
                String selectedItem = (String) parent.getItemAtPosition(position);
                // Show a Toast message with the selected item
                Toast.makeText(MainActivity.this, "Clicked: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
