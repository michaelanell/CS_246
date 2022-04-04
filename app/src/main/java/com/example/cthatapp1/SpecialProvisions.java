package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SpecialProvisions extends AppCompatActivity {

    // instance variables
    String specialProvisions;
    EditText specialProvisionsInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_provisions);

        //Collect User Input
        specialProvisionsInput = (EditText) findViewById(R.id.specialProvisionsInput);
    }

    private void setSpecialProvisions() {
        specialProvisions = specialProvisionsInput.getText().toString();

    }

    public void nextButton(View view) {
        /** Set instance variables to user input **/
        setSpecialProvisions();

        /** Get Special Instructions **/
        Intent intent = new Intent(this, SpecialInstructions.class);
        startActivity(intent);
    }

}