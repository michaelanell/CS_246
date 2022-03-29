package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SpecialInstructions extends AppCompatActivity {

    //instance variables
    String specialInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_instructions);
    }

    public void displayEntry(View view) {
        Intent intent = new Intent(this, DisplayEntry.class);
        startActivity(intent);
    }

}