package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProtectionPeriod extends AppCompatActivity {
    String protectionPeriod;
    EditText protectionPeriodInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protection_period);

        // get user input
        protectionPeriodInput = (EditText) findViewById(R.id.protectionPeriodInput);
    }

    private void setProtectionPeriod(){
        protectionPeriod = protectionPeriodInput.getText().toString();
    }

    private boolean validateProtectionPeriod(){
        if (protectionPeriod.isEmpty()) {
            protectionPeriodInput.setError("Field cannot be empty");
            return false;
        }
        else {
            protectionPeriodInput.setError(null);
            return true;
        }
    }

    /** Called when user clicks Next button **/
    public void getAddenda(View view) {
        /** Set instance variables to user input **/
        setProtectionPeriod();

        /** Validate user input **/
        if (!validateProtectionPeriod()) {
            return;
        }

        /** Collect Addenda **/
        Intent intent = new Intent(this, Addenda.class);
        startActivity(intent);
    }
}