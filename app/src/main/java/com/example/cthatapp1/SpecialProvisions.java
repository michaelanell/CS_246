package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SpecialProvisions extends AppCompatActivity {

    // instance variables
    String specialProvisions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_provisions);
    }

    public void getSpecialInstructions(View view) {
        Intent intent = new Intent(this, SpecialInstructions.class);
        startActivity(intent);
    }
}