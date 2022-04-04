package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ServiceProviderFees extends AppCompatActivity {

    String serviceProviderFees;
    EditText serviceProviderFeesInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_fees);

        serviceProviderFeesInput = (EditText) findViewById(R.id.serviceProviderInput);

    }

    private void setServiceProviderFees() {
        serviceProviderFees = serviceProviderFeesInput.getText().toString();
    }

    /** Validation methods **/
    private boolean validateServiceProviderFees() {
        if (serviceProviderFees.isEmpty()) {
            serviceProviderFeesInput.setError("Field cannot be empty");
            return false;
        }
        else {
            serviceProviderFeesInput.setError(null);
            return true;
        }
    }

    public void getOtherFees(View view) {
        /** Set instance variables to user input **/
        setServiceProviderFees();

        /** Validate user input **/
        if (!validateServiceProviderFees()) {
            return;
        }

        /** Collect Broker Info **/
        Intent intent = new Intent(this, ProtectionPeriod.class);
        startActivity(intent);
    }
}