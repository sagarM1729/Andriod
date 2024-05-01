package com.example.a18basicquery;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase database;
    private EditText editTextName, editTextAge;
    private Button buttonAdd, buttonDeleteAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonDeleteAll = findViewById(R.id.buttonDeleteAll);

        // Create or open the database
        database = openOrCreateDatabase("StudentDB", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER)");

        // Add click listener to the Add button
        buttonAdd.setOnClickListener(v -> {
            String name = editTextName.getText().toString().trim();
            String ageString = editTextAge.getText().toString().trim();
            if (!name.isEmpty() && !ageString.isEmpty()) {
                int age = Integer.parseInt(ageString);
                addStudent(name, age);
                displayAllStudents();
                editTextName.setText("");
                editTextAge.setText("");
            }
        });

        // Add click listener to the Delete All button
        buttonDeleteAll.setOnClickListener(v -> {
            deleteAllStudents();
            displayAllStudents();
        });

        // Display all students initially
        displayAllStudents();
    }

    private void addStudent(String name, int age) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        database.insert("students", null, values);
    }

    private void deleteAllStudents() {
        database.delete("students", null, null);
    }

    private void displayAllStudents() {
        TextView textView = findViewById(R.id.textView);
        StringBuilder builder = new StringBuilder();
        Cursor cursor = database.query("students", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int studentId = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            int age = cursor.getInt(cursor.getColumnIndexOrThrow("age"));
            builder.append("ID: ").append(studentId).append(", Name: ").append(name).append(", Age: ").append(age).append("\n");
        }
        cursor.close();
        textView.setText(builder.toString());
    }
}
