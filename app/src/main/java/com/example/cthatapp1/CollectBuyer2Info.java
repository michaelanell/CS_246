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

public class CollectBuyer2Info extends AppCompatActivity {
    private static final String FILE_NAME = "request.txt";

    // instance variables
    String buyerTwoName, buyerTwoEmail, buyerTwoPhone;

    EditText buyerTwoNameInput, buyerTwoEmailInput, buyerTwoPhoneInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_buyer2_info);

        // get user input
        buyerTwoNameInput = (EditText) findViewById(R.id.buyerTwoNameInput);
        buyerTwoEmailInput = (EditText) findViewById(R.id.buyerTwoEmailInput);
        buyerTwoPhoneInput  = (EditText) findViewById(R.id.buyerTwoPhoneInput);

    }

    private void setBuyerTwoInfo() {
        buyerTwoName = buyerTwoNameInput.getText().toString();
        buyerTwoEmail = buyerTwoEmailInput.getText().toString();
        buyerTwoPhone = buyerTwoPhoneInput.getText().toString();

    }

    /** Validation methods **/
    private boolean validateBuyerTwoName() {
        if (buyerTwoName.isEmpty()) {
            buyerTwoNameInput.setError("Field cannot be empty");
            return false;
        }
        else {
            buyerTwoNameInput.setError(null);
            return true;
        }
    }

    private boolean validateBuyerTwoEmail() {
        if (buyerTwoEmail.isEmpty()) {
            buyerTwoEmailInput.setError("Field cannot be empty");
            return false;
        }
        else {
            buyerTwoEmailInput.setError(null);
            return true;
        }
    }

    private boolean validateBuyerTwoPhone() {
        if (buyerTwoPhone.isEmpty()) {
            buyerTwoPhoneInput.setError("Field cannot be empty");
            return false;
        }
        else {
            buyerTwoPhoneInput.setError(null);
            return true;
        }
    }

    private void saveUserInput() {
        // creates a FileWriter Object
        String lineBreak = "\r\n";
        FileOutputStream newFileStream = null;

        // format Strings
        buyerTwoName = "Buyer Two Name: " + buyerTwoNameInput.getText().toString() + "\r\n";
        buyerTwoEmail = "Buyer Two Email: " + buyerTwoEmailInput.getText().toString() + "\r\n";
        buyerTwoPhone = "Buyer Two Phone: " + buyerTwoPhoneInput.getText().toString() + "\r\n";

        try {
            newFileStream = openFileOutput(FILE_NAME, MODE_APPEND);
            newFileStream.write(lineBreak.getBytes());
            newFileStream.write(buyerTwoName.getBytes());
            newFileStream.write(buyerTwoEmail.getBytes());
            newFileStream.write(buyerTwoPhone.getBytes());
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
        setBuyerTwoInfo();

        /** Validate user input **/
        if (!validateBuyerTwoName() | !validateBuyerTwoEmail() | !validateBuyerTwoPhone()) {
            return;
        }

        /** save data **/
        saveUserInput();

        /** Collect Buyer Address **/

       Intent intent = new Intent(this, CollectBuyerAddress.class);
        startActivity(intent);
    }

}