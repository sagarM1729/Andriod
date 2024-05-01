package com.example.a8sqlite;

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
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button addButton, showButton, deleteButton;
    TextView dataTextView;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        addButton = findViewById(R.id.addButton);
        showButton = findViewById(R.id.showButton);
        deleteButton = findViewById(R.id.deleteButton);
        dataTextView = findViewById(R.id.dataTextView);

        // Create or open the database
        db = openOrCreateDatabase("my_database", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS my_table (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString().trim();
                if (!TextUtils.isEmpty(name)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("name", name);
                    long result = db.insert("my_table", null, contentValues);
                    if (result != -1) {
                        Toast.makeText(MainActivity.this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
                        editText.setText("");
                    } else {
                        Toast.makeText(MainActivity.this, "Failed to insert data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a name", Toast.LENGTH_SHORT).show();
                }
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.rawQuery("SELECT * FROM my_table", null);
                if (res.getCount() == 0) {
                    showMessage("Error", "No data found");
                    return;
                }

                StringBuilder buffer = new StringBuilder();
                while (res.moveToNext()) {
                    buffer.append("ID: ").append(res.getString(0)).append("\n");
                    buffer.append("Name: ").append(res.getString(1)).append("\n\n");
                }
                dataTextView.setText(buffer.toString());
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idStr = editText.getText().toString().trim();
                if (!TextUtils.isEmpty(idStr)) {
                    int id = Integer.parseInt(idStr);
                    int result = db.delete("my_table", "id = ?", new String[]{idStr});
                    if (result > 0) {
                        Toast.makeText(MainActivity.this, "Data deleted successfully", Toast.LENGTH_SHORT).show();
                        editText.setText("");
                    } else {
                        Toast.makeText(MainActivity.this, "Failed to delete data", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter an ID to delete", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
