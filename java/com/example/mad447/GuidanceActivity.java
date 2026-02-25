package com.example.mad447;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GuidanceActivity extends AppCompatActivity {

    TextView txtGuidance;
    Button btnCall, btnSMS, btnEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Guidance - 23ITRO47"); // Change to your register number
        setContentView(R.layout.activity_guidance);

        txtGuidance = findViewById(R.id.txtGuidance);
        btnCall = findViewById(R.id.btnCall);
        btnSMS = findViewById(R.id.btnSMS);
        btnEmail = findViewById(R.id.btnEmail);

        String crop = getIntent().getStringExtra("crop");
        String soil = getIntent().getStringExtra("soil");
        String season = getIntent().getStringExtra("season");

        txtGuidance.setText("Selected Crop: " + crop +
                "\nSoil Type: " + soil +
                "\nSeason: " + season +
                "\n\nTips: Use proper irrigation and fertilizers.");

        btnCall.setOnClickListener(v -> showDialog("call"));
        btnSMS.setOnClickListener(v -> showDialog("sms"));
        btnEmail.setOnClickListener(v -> showDialog("email"));
    }

    private void showDialog(String type) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation");
        builder.setMessage("Are you sure you want to " + type + " the expert?");

        builder.setPositiveButton("Yes", (dialog, which) -> {

            if (type.equals("call")) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9876543210"));
                startActivity(intent);
            }

            else if (type.equals("sms")) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:9876543210"));
                intent.putExtra("sms_body", "Need agriculture guidance.");
                startActivity(intent);
            }

            else {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"expert@agri.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,
                        "Agriculture Help");
                startActivity(intent);
            }
        });

        builder.setNegativeButton("No", null);
        builder.show();
    }
}