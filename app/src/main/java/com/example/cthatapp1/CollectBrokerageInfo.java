package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CollectBrokerageInfo extends AppCompatActivity {

    String brokerName;
    int brokerLicenseNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_brokerage_info);
    }

    // Set instance variables
    public void setAgentName(View view) {
        EditText editBrokerName = (EditText) findViewById(R.id.brokerageNameInput);
        this.brokerName = editBrokerName.getText().toString();
    }

    public void setAgentLicenseNumber(View view) {
        EditText editBrokerLicenseNumber = (EditText) findViewById(R.id.brokerageLicenseNoInput);
        this.brokerLicenseNumber = Integer.parseInt(editBrokerLicenseNumber.getText().toString());
    }

    /** Called when user clicks Next button **/
    public void collectBuyerInfo(View view) {
        Intent intent = new Intent(this, CollectBuyerInfo.class);
        startActivity(intent);
    }
}