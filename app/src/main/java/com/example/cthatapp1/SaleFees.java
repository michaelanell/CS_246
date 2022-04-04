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

public class SaleFees extends AppCompatActivity {
    private static final String FILE_NAME = "request.txt";
    // instance variables
    String salesFee;

    EditText salesFeeInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_fees);

        // get user input
        salesFeeInput = (EditText) findViewById(R.id.salePercentageInput);

    }

    private void setSalesFee() {
        salesFee = "Sales Fee: " + salesFeeInput.getText().toString() + "\r\n";
    }

    /** Validation methods **/
    private boolean validateSalesFee(){
        if (salesFee.isEmpty()) {
            salesFeeInput.setError("Field cannot be empty");
            return false;
        }
        else {
            salesFeeInput.setError(null);
            return true;
        }
    }

    private void saveUserInput() {
        // creates a FileWriter Object
        FileOutputStream newFileStream = null;
        String lineBreak = "\r\n";
        //FORMAT STRINGS
        salesFee = "Sales Fee: " + salesFeeInput.getText().toString() + "\r\n";

        try {
            newFileStream = openFileOutput(FILE_NAME, MODE_APPEND);
            newFileStream.write(lineBreak.getBytes());
            newFileStream.write(salesFee.getBytes());
            newFileStream.write(lineBreak.getBytes());

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
        setSalesFee();

        /** Validate user input **/
        if (!validateSalesFee()) {
            return;
        }

        /** save data **/
        saveUserInput();

        /** Collect Lease Fees **/
        Intent intent = new Intent(this, ServiceProviderFees.class);
        startActivity(intent);
    }
}