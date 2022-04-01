package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProtectionPeriod extends AppCompatActivity {
    String protectionPeriod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protection_period);
    }

    public void getAddenda(View view) {
        Intent intent = new Intent(this, Addenda.class);
        startActivity(intent);

        EditText editProtectionPeriod = (EditText) findViewById(R.id.protectionPeriodInput);
        protectionPeriod = editProtectionPeriod.getText().toString();

    }
}