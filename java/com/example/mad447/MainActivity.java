package com.example.mad447;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerCrop, spinnerSoil, spinnerSeason;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Farmer Helper - 23IT0R047"); // Change to your register number
        setContentView(R.layout.activity_main);

        spinnerCrop = findViewById(R.id.spinnerCrop);
        spinnerSoil = findViewById(R.id.spinnerSoil);
        spinnerSeason = findViewById(R.id.spinnerSeason);
        btnSubmit = findViewById(R.id.btnSubmit);

        String[] crops = {"Rice", "Wheat", "Cotton"};
        String[] soils = {"Black Soil", "Red Soil", "Alluvial Soil"};
        String[] seasons = {"Summer", "Winter", "Rainy"};

        spinnerCrop.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, crops));

        spinnerSoil.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, soils));

        spinnerSeason.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, seasons));

        btnSubmit.setOnClickListener(v -> {
            String crop = spinnerCrop.getSelectedItem().toString();
            String soil = spinnerSoil.getSelectedItem().toString();
            String season = spinnerSeason.getSelectedItem().toString();

            Intent intent = new Intent(MainActivity.this, GuidanceActivity.class);
            intent.putExtra("crop", crop);
            intent.putExtra("soil", soil);
            intent.putExtra("season", season);
            startActivity(intent);
        });
    }
}