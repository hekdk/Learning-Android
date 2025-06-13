package com.example.sportsapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Sport> sportList;

    private CustomAdapter sportAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        sportList = new ArrayList<>();

        Sport s1 = new Sport("Basketball",R.drawable.basketball);
        Sport s2 = new Sport("Football",R.drawable.football);
        Sport s3 = new Sport("Ping pong",R.drawable.ping);
        Sport s4 = new Sport("Tennis",R.drawable.tennis);
        Sport s5 = new Sport("Volleyball",R.drawable.volley);

        sportList.add(s1);
        sportList.add(s2);
        sportList.add(s3);
        sportList.add(s4);
        sportList.add(s5);

        sportAdapter = new CustomAdapter(sportList, new onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Sport item = sportList.get(position);
                Toast.makeText(MainActivity.this, "Clicked: " + item.sportName, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(sportAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}