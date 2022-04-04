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

public class CollectBrokerageInfo extends AppCompatActivity {
    private static final String FILE_NAME = "request.txt";

    // instance variables
    String brokerName, brokerLicenseNumber;
    EditText brokerNameInput, brokerLicenseNumberInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_brokerage_info);

        // collect user input
        brokerNameInput = (EditText) findViewById(R.id.brokerageNameInput);
        brokerLicenseNumberInput = (EditText) findViewById(R.id.brokerageLicenseNoInput);

    }

    private void setBrokerInfo() {
        brokerName = brokerNameInput.getText().toString();
        brokerLicenseNumber = brokerLicenseNumberInput.getText().toString();
    }

    /** Validation methods **/
    private boolean validateBrokerName() {
        if (brokerName.isEmpty()) {
            brokerNameInput.setError("Field cannot be empty");
            return false;
        }
        else {
            brokerNameInput.setError(null);
            return true;
        }
    }

    private boolean validateBrokerLicense() {
        if (brokerLicenseNumber.isEmpty()) {
            brokerLicenseNumberInput.setError("Field cannot be empty");
            return false;
        }
        else {
            brokerLicenseNumberInput.setError(null);
            return true;
        }
    }

    private void saveUserInput() {
        // creates a FileWriter Object
        String lineBreak = "\r\n";
        FileOutputStream newFileStream = null;

        // format Strings
        brokerName = "Broker Name: " + brokerNameInput.getText().toString() + "\r\n";
        brokerLicenseNumber = "Broker License Number: " + brokerLicenseNumberInput.getText().toString() + "\r\n";

        try {
            newFileStream = openFileOutput(FILE_NAME, MODE_APPEND);
            newFileStream.write(lineBreak.getBytes());
            newFileStream.write(brokerName.getBytes());
            newFileStream.write(brokerLicenseNumber.getBytes());
           // Toast.makeText(this, "File written to!" + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_SHORT).show();
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
        setBrokerInfo();

        /** Validate user input **/
        if (!validateBrokerName() | !validateBrokerLicense()  ) {
            return;
        }

        /** save data **/
        saveUserInput();

        /** Collect Buyer Info **/


        Intent intent = new Intent(this, CollectBuyerInfo.class);
        startActivity(intent);
    }


}