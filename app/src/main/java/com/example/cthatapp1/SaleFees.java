package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SaleFees extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_fees);
    }

    public void getLeaseFees(View view) {
        Intent intent = new Intent(this, LeaseFees.class);
        startActivity(intent);
    }
}