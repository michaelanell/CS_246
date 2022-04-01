package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Addenda2 extends AppCompatActivity {

    // instance variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addenda2);
    }

    public void collectDueByInfo(View view) {
        Intent intent = new Intent(this, SpecialProvisions.class);
        startActivity(intent);
    }
}