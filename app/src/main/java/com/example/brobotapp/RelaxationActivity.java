package com.example.brobotapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RelaxationActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView meditation;
    private ImageView breathingEx;
    private ImageView music;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relaxation);

        meditation = findViewById(R.id.meditation);
        breathingEx = findViewById(R.id.breathingEx);
        music = findViewById(R.id.music);

        meditation.setOnClickListener(this);
        breathingEx.setOnClickListener(this);
        music.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        if(view == meditation) {
            startActivity(new Intent(this, MeditationActivity.class));
        }
        if(view == breathingEx) {
            startActivity(new Intent(this, BreathingActivity.class));
        }
        if(view == music) {
            startActivity(new Intent(this, MusicActivity.class));
        }
    }
}
