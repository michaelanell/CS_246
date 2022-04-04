package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CollectBuyerInfo extends AppCompatActivity {
    private static final String TAG = "CollectBuyerInfo";
    private static final String FILE_NAME = "request.txt";

    // instance variables
    String buyerOneName, buyerOneEmail, buyerOnePhone;
    boolean oneBuyer;

    EditText buyerOneNameInput, buyerOneEmailInput, buyerOnePhoneInput;
    RadioGroup numBuyersRadioGroup;
    RadioButton selectedNumBuyers;

    // getters
    public String getBuyerOneName() {
        return buyerOneName;
    }

    public String getBuyerOneEmail() {
        return buyerOneEmail;
    }

    public String getBuyerOnePhone() {
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
        numBuyersRadioGroup = findViewById(R.id.radioGroup);

    }

    private void setBuyerInfo() {
        buyerOneName = buyerOneNameInput.getText().toString();
        buyerOneEmail = buyerOneEmailInput.getText().toString();
        buyerOnePhone = buyerOnePhoneInput.getText().toString();
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

    /** Validation methods **/
    private boolean validateBuyerOnePhone() {
        if (buyerOneName.isEmpty()) {
            buyerOneNameInput.setError("Field cannot be empty");
            return false;
        }
        else {
            buyerOneNameInput.setError(null);
            return true;
        }
    }

    private boolean validateBuyerOneEmail() {
        if (buyerOneEmail.isEmpty()) {
            buyerOneEmailInput.setError("Field cannot be empty");
            return false;
        }
        else {
            buyerOneEmailInput.setError(null);
            return true;
        }
    }

    private boolean validateBuyerOneName() {
        if (buyerOnePhone.isEmpty()) {
            buyerOnePhoneInput.setError("Field cannot be empty");
            return false;
        }
        else {
            buyerOnePhoneInput.setError(null);
            return true;
        }
    }

    private boolean validateNumBuyers() {
        if (numBuyersRadioGroup.getCheckedRadioButtonId()==-1) {
            Toast.makeText(this, "Please select number of buyers", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }

    private void saveUserInput() {
        // creates a FileWriter Object
        String lineBreak = "\r\n";
        FileOutputStream newFileStream = null;
        // format Strings
        buyerOneName = "Buyer Name: " + buyerOneNameInput.getText().toString() + "\r\n";
        buyerOneEmail = "Buyer Email: " + buyerOneEmailInput.getText().toString() + "\r\n";
        buyerOnePhone = "Buyer Phone: " + buyerOnePhoneInput.getText().toString() + "\r\n";

        try {
            newFileStream = openFileOutput(FILE_NAME, MODE_APPEND);
            newFileStream.write(lineBreak.getBytes());
            newFileStream.write(buyerOneName.getBytes());
            newFileStream.write(buyerOneEmail.getBytes());
            newFileStream.write(buyerOnePhone.getBytes());
          //  Toast.makeText(this, "File written to!" + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_SHORT).show();
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
        setBuyerInfo();

        /** Validate user input **/
        if (!validateBuyerOneName() | !validateBuyerOneEmail() | !validateBuyerOnePhone() | !validateNumBuyers()) {
            return;
        }

        /** save data **/
        saveUserInput();


        /** Collect Buyer 2 Info OR Collect Buyer Address **/

        Intent intent;
        if (oneBuyer == false) {
            intent = new Intent(this, CollectBuyer2Info.class);
        } else {
            intent = new Intent(this, CollectBuyerAddress.class);
        }

        startActivity(intent);

    }

}