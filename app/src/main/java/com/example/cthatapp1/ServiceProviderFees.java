package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ServiceProviderFees extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_fees);
    }

    public void getOtherFees(View view) {
        Intent intent = new Intent(this, OtherFees.class);
        startActivity(intent);
    }
}