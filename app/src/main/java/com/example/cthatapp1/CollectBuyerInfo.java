package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class CollectBuyerInfo extends AppCompatActivity {
    private static final String TAG = "CollectBuyerInfo";

    // instance variables
    String buyerOneName, buyerOneEmail;
    int buyerOnePhone;
    boolean oneBuyer;

    EditText buyerOneNameInput;
    EditText buyerOneEmailInput;
    EditText buyerOnePhoneInput;


    // getters
    public String getBuyerOneName() {
        return buyerOneName;
    }

    public String getBuyerOneEmail() {
        return buyerOneEmail;
    }

    public int getBuyerOnePhone() {
        return buyerOnePhone;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_buyer_info);

        // get user input
        buyerOneNameInput = (EditText) findViewById(R.id.buyerOneNameInput);
        buyerOneEmailInput = (EditText) findViewById(R.id.buyerOneEmailInput);
        buyerOnePhoneInput  = (EditText) findViewById(R.id.buyerOnePhoneInput);

    }

    private void setBuyerInfo() {
        buyerOneName = buyerOneNameInput.getText().toString();
        buyerOneEmail = buyerOneEmailInput.getText().toString();
        buyerOnePhone = Integer.parseInt(buyerOnePhoneInput.getText().toString());
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.oneBuyer:
                if (checked)
                    oneBuyer = true;
                    break;
            case R.id.twoBuyers:
                if (checked)
                    oneBuyer = false;
                    break;
        }
    }

    public void nextButton(View view) {
        setBuyerInfo();

        Intent intent;
        if (oneBuyer == false) {
            intent = new Intent(this, CollectBuyer2Info.class);
        } else {
            intent = new Intent(this, CollectBuyerAddress.class);
        }
        startActivity(intent);
    }
}