package com.aayush.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    Button start_btn, stop_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        start_btn = findViewById(R.id.startService);
        stop_btn = findViewById(R.id.stopService);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(getApplicationContext(), MyCustomService.class);
                startService(serviceIntent);
            }
        });

        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(getApplicationContext(), MyCustomService.class);
                stopService(serviceIntent);
            }
        });

        IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        AirplaneModeReceiver br = new AirplaneModeReceiver();
        registerReceiver(br, intentFilter);
    }
}