package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CollectAgentInfo extends AppCompatActivity {

    // instance variables
    String agentFirstName;
    String agentLastName;
    String agentEmail;
    int agentLicenseNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_agent_info);
    }

    /** Called when user clicks Next button **/
    public void collectBrokerageInfo(View view) {
        Intent intent = new Intent(this, CollectBrokerageInfo.class);
        startActivity(intent);
    }
}