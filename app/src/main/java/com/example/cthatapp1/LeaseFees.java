package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class LeaseFees extends AppCompatActivity {

    // instance variables
    String leaseFees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lease_fees);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.oneMonthRent:
                if (checked)
                    leaseFees = "Percentage of one Month";
                    break;
            case R.id.allRentsRadio:
                if (checked)
                    leaseFees = "Percentage of all Rents";
                    break;
        }
    }

    public void getConstructionFees(View view) {
        Intent intent = new Intent(this, ConstructionFees.class);
        startActivity(intent);
    }
}