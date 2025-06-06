package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView welcomeTxt, luckyNumberTxt;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        welcomeTxt = findViewById(R.id.textview2);
        luckyNumberTxt = findViewById(R.id.lucky_number_txt);
        share_btn = findViewById(R.id.share_btn);

        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        int random_num = generateRandomNumber();
        luckyNumberTxt.setText("" + random_num);

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, random_num);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public int generateRandomNumber() {
        Random random = new Random();

        int upper_limit = 1000;
        int randomNumberGenerated = random.nextInt(upper_limit);

        return randomNumberGenerated;
    }

    public void shareData(String userName, int randomNum){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, userName + "got Lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is:" + randomNum);

        startActivity(Intent.createChooser(i, "Choose a Platform"));
    }
}