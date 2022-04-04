package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SpecialInstructions extends AppCompatActivity {

    //instance variables
    String specialInstructions;
    EditText specialInstructionsInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_instructions);

        specialInstructionsInput = (EditText) findViewById(R.id.specialInstructionsInput);
    }

    private void setSpecialInstructions() {
        specialInstructions = specialInstructionsInput.getText().toString();
    }

    /** Validation methods **/
    private boolean validateSpecialInstructions() {
        if (specialInstructions.isEmpty()) {
            specialInstructionsInput.setError("Field cannot be empty");
            return false;
        }
        else {
            specialInstructionsInput.setError(null);
            return true;
        }
    }


    public void displayEntry(View view) {
        /** Set instance variables to user input **/
        setSpecialInstructions();


        /** Display Entry **/
        Intent intent = new Intent(this, DisplayEntry.class);
        startActivity(intent);

    }

}