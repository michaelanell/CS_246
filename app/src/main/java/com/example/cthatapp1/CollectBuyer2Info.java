package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CollectBuyer2Info extends AppCompatActivity {

    // instance variables
    String buyerTwoName, buyerTwoEmail;
    int buyerTwoPhone;

    EditText buyerTwoNameInput;
    EditText buyerTwoEmailInput;
    EditText buyerTwoPhoneInput;

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
        buyerTwoPhone = Integer.parseInt(buyerTwoPhoneInput.getText().toString());

    }

    public void nextButton(View view) {
        setBuyerTwoInfo();
        Intent intent = new Intent(this, CollectBuyerAddress.class);
        startActivity(intent);
    }
}