package com.example.exp_autocomplete;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    private String[] suggestions = {"Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape","how to climb"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        listView = findViewById(R.id.listView);

        // Creating adapter for autocompleteTextView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, suggestions);
        autoCompleteTextView.setAdapter(adapter);

        // Set TextChangeListener for the autoCompleteTextView
        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                String searchText = s.toString().trim();
                if (!searchText.isEmpty()) {
                    showListView();
                    filterList(searchText);
                } else {
                    hideListView();
                }
            }
        });

        // ListView item click listener
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedItem = (String) parent.getItemAtPosition(position);
            Toast.makeText(MainActivity.this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
        });
    }

    private void showListView() {
        listView.setVisibility(ListView.VISIBLE);
    }

    private void hideListView() {
        listView.setVisibility(ListView.GONE);
    }

    private void filterList(String searchText) {
        ArrayAdapter<String> filteredAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        for (String item : suggestions) {
            if (item.toLowerCase().contains(searchText.toLowerCase())) {
                filteredAdapter.add(item);
            }
        }
        listView.setAdapter(filteredAdapter);
    }
}
