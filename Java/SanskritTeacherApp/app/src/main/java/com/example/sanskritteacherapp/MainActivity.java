package com.example.sanskritteacherapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button blackBtn, greenBtn, purpleBtn, redBtn, yellowBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        blackBtn = findViewById(R.id.blackBtn);
        greenBtn = findViewById(R.id.greenBtn);
        purpleBtn = findViewById(R.id.purpleBtn);
        redBtn = findViewById(R.id.redBtn);
        yellowBtn = findViewById(R.id.yellowBtn);

        blackBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);
        redBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);

//        blackBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                MediaPlayer mediaPlayer = new MediaPlayer(); can be done this way
//                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.Black);
//                mediaPlayer.start();
//            }
//        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        int clickedBtnId = v.getId();

        if (clickedBtnId == R.id.blackBtn){
            playSounds(R.raw.black);
        } else if (clickedBtnId == R.id.greenBtn) {
            playSounds(R.raw.green);
        } else if (clickedBtnId == R.id.purpleBtn) {
            playSounds(R.raw.purple);
        } else if (clickedBtnId == R.id.redBtn) {
            playSounds(R.raw.red);
        } else if (clickedBtnId == R.id.yellowBtn) {
            playSounds(R.raw.yellow);
        }
    }

    public void playSounds(int id){
        MediaPlayer mediaPlayer =  MediaPlayer.create(this, id);
        mediaPlayer.start();
    }
}