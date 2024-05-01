package com.example.a27sound;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSound1 = findViewById(R.id.button_sound1);
        Button buttonSound2 = findViewById(R.id.button_sound2);

        buttonSound1.setOnClickListener(this);
        buttonSound2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int soundResourceId;
        int id = v.getId();
        if (id == R.id.button_sound1) {
            soundResourceId = R.raw.sound1;
        } else if (id == R.id.button_sound2) {
            soundResourceId = R.raw.sound2;
        } else {
            // Handle default case
            return;
        }

        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        mediaPlayer = MediaPlayer.create(this, soundResourceId);
        mediaPlayer.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
