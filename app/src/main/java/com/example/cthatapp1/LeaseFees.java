package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LeaseFees extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lease_fees);
    }

    public void getConstructionFees(View view) {
        Intent intent = new Intent(this, ConstructionFees.class);
        startActivity(intent);
    }
}