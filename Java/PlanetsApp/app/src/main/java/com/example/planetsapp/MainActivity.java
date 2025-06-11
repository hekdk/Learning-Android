package com.example.planetsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetArrayList;
    private static MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        planetArrayList = new ArrayList<>();

        Planet planet1 = new Planet("Mercury", "0 moons", R.drawable.mercury);
        Planet planet2 = new Planet("Venus", "0 moons", R.drawable.venus);
        Planet planet3 = new Planet("Earth", "1 moon", R.drawable.earth);
        Planet planet4 = new Planet("Mars", "2 moons", R.drawable.mars);
        Planet planet5 = new Planet("Jupiter", "95 moons", R.drawable.jupiter);
        Planet planet6 = new Planet("Saturn", "146 moons", R.drawable.saturn);
        Planet planet7 = new Planet("Uranus", "27 moons", R.drawable.uranus);
        Planet planet8 = new Planet("Neptune", "14 moons", R.drawable.neptune);
        Planet planet9 = new Planet("Pluto", "5 moons", R.drawable.pluto);

        planetArrayList.add(planet1);
        planetArrayList.add(planet2);
        planetArrayList.add(planet3);
        planetArrayList.add(planet4);
        planetArrayList.add(planet5);
        planetArrayList.add(planet6);
        planetArrayList.add(planet7);
        planetArrayList.add(planet8);
        planetArrayList.add(planet9);

        adapter = new MyCustomAdapter(planetArrayList, getApplicationContext());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Planet Name: "+ adapter.getItem(position).getPlanetName(), Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}