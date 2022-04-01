package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ServiceProviderFees extends AppCompatActivity {

    String serviceProviderFees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_fees);
    }

    public void getOtherFees(View view) {
        Intent intent = new Intent(this, OtherFees.class);
        startActivity(intent);

        EditText editServiceProviderFees = (EditText) findViewById(R.id.serviceProviderInput);

        serviceProviderFees = editServiceProviderFees.getText().toString();
    }
}