package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class CollectAgentInfo extends AppCompatActivity {
    private static final String FILE_NAME = "request.txt";


    // instance variables
    String agentName, agentEmail, agentLicenseNumber;

    EditText agentNameInput, agentEmailInput, agentLicenseNumberInput;

    // getters
    public String getAgentName() {
        return agentName;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public String getAgentLicenseNumber() {
        return agentLicenseNumber;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_agent_info);

        // collect user input
        agentNameInput = (EditText) findViewById(R.id.agentNameInput);
        agentEmailInput = (EditText) findViewById(R.id.agentEmailInput);
        agentLicenseNumberInput = (EditText) findViewById(R.id.agentLicenseNumInput);
    }

    private void setAgentInfo(){
        agentName = agentNameInput.getText().toString();
        agentEmail = agentEmailInput.getText().toString();
        agentLicenseNumber = agentLicenseNumberInput.getText().toString();
    }

    /** Validation methods **/
    private boolean validateAgentName(){
        if (agentName.isEmpty()) {
            agentNameInput.setError("Field cannot be empty");
            return false;
        }
        else {
            agentNameInput.setError(null);
            return true;
        }
    }

    private boolean validateAgentEmail(){
        if (agentEmail.isEmpty()) {
            agentEmailInput.setError("Field cannot be empty");
            return false;
        }
        else {
            agentEmailInput.setError(null);
            return true;
        }
    }

    private boolean validateAgentLicenseNumber(){
        if (agentLicenseNumber.isEmpty()) {
            agentLicenseNumberInput.setError("Field cannot be empty");
            return false;
        }
        else {
            agentLicenseNumberInput.setError(null);
            return true;
        }
    }

    private void saveUserInput() {
        // creates a FileWriter Object
        String lineBreak = "\r\n";
        FileOutputStream newFileStream = null;

        // format Strings
        agentName = "Agent Name: " + agentNameInput.getText().toString() + "\r\n";
        agentEmail = "Agent Email: " + agentEmailInput.getText().toString() + "\r\n";
        agentLicenseNumber = "Agent License Number: " + agentLicenseNumberInput.getText().toString() + "\r\n";

        try {
            newFileStream = openFileOutput(FILE_NAME, MODE_APPEND);
            newFileStream.write(lineBreak.getBytes());
            newFileStream.write(agentName.getBytes());
            newFileStream.write(agentEmail.getBytes());
            newFileStream.write(agentLicenseNumber.getBytes());
            //Toast.makeText(this, "File written to!" + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_SHORT).show();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (newFileStream != null) {
                try {
                    newFileStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** Called when user clicks Next button **/
    public void nextButton(View view) {
        /** Set instance variables to user input **/
        setAgentInfo();

        /** Validate user input **/
        if (!validateAgentName() | !validateAgentEmail() | !validateAgentLicenseNumber() ) {
            return;
        }

        /** save data **/
        saveUserInput();

        /** Collect Broker Info **/
        //Intent intent = new Intent(this, DisplayEntry.class);
        Intent intent = new Intent(this, CollectBrokerageInfo.class);
        startActivity(intent);
    }


}