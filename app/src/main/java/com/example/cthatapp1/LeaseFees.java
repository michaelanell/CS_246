package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeaseFees extends AppCompatActivity {
    private static final String FILE_NAME = "request.txt";

    // instance variables
    String leaseFeesPercentage;
    String leaseFeesType;

    EditText leaseFeesPercentageInput;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lease_fees);

        // get user input
        leaseFeesPercentageInput = (EditText) findViewById(R.id.agentNameInput);
    }

    public void onRadioButtonClicked(View view) {
     /*   // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.oneMonthRent:
                if (checked)
                    leaseFeesType = "Lease Fee Type: One month rent";
                    break;
            case R.id.allRentsRadio:
                if (checked)
                    leaseFeesType = "Lease Fee Type: All rents";
                    break;
        }*/
    }

    private void setLeaseFee() {
        leaseFeesPercentage = leaseFeesPercentageInput.getText().toString();
    }

    private boolean validateLeaseFee() {
        if (leaseFeesPercentage.isEmpty()) {
            leaseFeesPercentageInput.setError("Field cannot be empty");
            return false;
        }
        else {
            leaseFeesPercentageInput.setError(null);
            return true;
        }
    }

    private void saveUserInput() {
        // creates a FileWriter Object
        String lineBreak = "\r\n";
        String leaseFeeString = "Lease Fee Percentage: " + leaseFeesPercentage + "\r\n";
        FileOutputStream newFileStream = null;
        try {
            newFileStream = openFileOutput(FILE_NAME, MODE_APPEND);
            newFileStream.write(lineBreak.getBytes());
            newFileStream.write(leaseFeeString.getBytes());
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

    public void nextButton(View view) {
        /** Set instance variables to user input **/
        setLeaseFee();

        /** Validate user input **/
       // if (!validateLeaseFee()) {
       //     return;
      //  }

        /** save data **/
        saveUserInput();

        /** Collect Construction Fees **/
        //Intent intent = new Intent(this, DisplayEntry.class);
        Intent intent = new Intent(this, ServiceProviderFees.class);
        startActivity(intent);
    }

}