package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProtectionPeriod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protection_period);
    }

    public void getProtectionPeriod(View view) {
        Intent intent = new Intent(this, ServiceProviderFees.class);
        startActivity(intent);
    }
}