package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CollectAgentInfo extends AppCompatActivity {

    // instance variables
    String agentName, agentEmail;
    int agentLicenseNumber;

    EditText agentNameInput;
    EditText agentEmailInput;
    EditText agentLicenseNumberInput;

    // getters
    public String getAgentName() {
        return agentName;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public int getAgentLicenseNumber() {
        return agentLicenseNumber;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_agent_info);

        agentNameInput = (EditText) findViewById(R.id.agentNameInput);
        agentEmailInput = (EditText) findViewById(R.id.agentEmailInput);
        agentLicenseNumberInput = (EditText) findViewById(R.id.agentLicenseNumInput);
    }

    private void setAgentInfo(){
        agentName = agentNameInput.getText().toString();
        agentEmail = agentEmailInput.getText().toString();
        agentLicenseNumber = Integer.parseInt(agentLicenseNumberInput.getText().toString());
    }

    /** Called when user clicks Next button **/
    public void nextButton(View view) {
        setAgentInfo();

        /** Collect Buyer Info **/
        Intent intent = new Intent(this, CollectBuyerInfo.class);
        startActivity(intent);
    }
}