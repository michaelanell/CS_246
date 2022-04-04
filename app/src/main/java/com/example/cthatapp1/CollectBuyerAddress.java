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

public class CollectBuyerAddress extends AppCompatActivity {
    private static final String FILE_NAME = "request.txt";

    // instance variables
    String streetAddress, city, state, zipcode;

    EditText streetAddressInput, cityInput, stateInput, zipcodeInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_buyer_address);

        // get user input
        streetAddressInput = (EditText) findViewById(R.id.buyerStreetAddressInput);
        cityInput = (EditText) findViewById(R.id.buyerCityInput);
        stateInput = (EditText) findViewById(R.id.buyerStateInput);
        zipcodeInput = (EditText) findViewById(R.id.buyerZipCodeInput);

    }

    public void setBuyerAddress(){
        streetAddress = streetAddressInput.getText().toString();
        city = cityInput.getText().toString();
        state = stateInput.getText().toString();
        zipcode = zipcodeInput.getText().toString();
    }

    /** Validation methods **/
    private boolean validateStreetAddress() {
        if (streetAddress.isEmpty()) {
            streetAddressInput.setError("Field cannot be empty");
            return false;
        }
        else {
            streetAddressInput.setError(null);
            return true;
        }
    }

    private boolean validateCity() {
        if (city.isEmpty()) {
            cityInput.setError("Field cannot be empty");
            return false;
        }
        else {
            cityInput.setError(null);
            return true;
        }
    }

    private boolean validateState() {
        if (state.isEmpty()) {
            stateInput.setError("Field cannot be empty");
            return false;
        }
        else {
            stateInput.setError(null);
            return true;
        }
    }

    private boolean validateZipcode() {
        if (zipcode.isEmpty()) {
            zipcodeInput.setError("Field cannot be empty");
            return false;
        }
        else {
            zipcodeInput.setError(null);
            return true;
        }
    }

    private void saveUserInput() {
        // creates a FileWriter Object
        String lineBreak = "\r\n";
        String buyerAddress = "Buyer Address: " + streetAddress + ", " + city + ", " + state + " " + zipcode + "\r\n";
        FileOutputStream newFileStream = null;
        try {
            newFileStream = openFileOutput(FILE_NAME, MODE_APPEND);
            newFileStream.write(lineBreak.getBytes());
            newFileStream.write(buyerAddress.getBytes());
           // newFileStream.write(lineBreak.getBytes());
         //   Toast.makeText(this, "File written to!" + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_SHORT).show();
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

    public void nextButton(View view){
        /** Set instance variables to user input **/
        setBuyerAddress();

        /** Validate user input **/
        if (!validateStreetAddress() | !validateCity() | !validateState() | !validateZipcode()) {
            return;
        }

        /** save data **/
        saveUserInput();

        /** Collect if there is Client Relationship **/

        Intent intent = new Intent(this, IsThereClientRelationship.class);
        startActivity(intent);
    }
}