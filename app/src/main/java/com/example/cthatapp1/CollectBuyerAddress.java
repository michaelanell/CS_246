package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CollectBuyerAddress extends AppCompatActivity {

    // instance variables
    String streetAddress;
    String city;
    String state;
    int zipcode;

    EditText streetAddressInput;
    EditText cityInput;
    EditText stateInput;
    EditText zipcodeInput;

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
        zipcode = Integer.parseInt(zipcodeInput.getText().toString());
    }

    public void nextButton(View view){
        setBuyerAddress();
        Intent intent = new Intent(this, IsThereClientRelationship.class);
        startActivity(intent);
    }
}