package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Intermediary extends AppCompatActivity {

    boolean intermediary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediary);

    }

    public void getSaleFees(View view) {
        Intent intent = new Intent(this, SaleFees.class);
        startActivity(intent);
    }
}