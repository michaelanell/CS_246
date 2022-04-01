package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OtherFees extends AppCompatActivity {

    String otherFees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_fees);
    }

    public void getProtectionPeriod(View view) {
        Intent intent = new Intent(this, ServiceProviderFees.class);
        startActivity(intent);

        EditText editOtherFees = (EditText) findViewById(R.id.otherFeesInput);

        otherFees = editOtherFees.getText().toString();
    }
}