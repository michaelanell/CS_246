package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class Addenda extends AppCompatActivity {

    // instance variables
    ArrayList<String> addenda = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addenda);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.addendaIABS:
                if (checked)
                    addenda.add("Information About Brokerage Services");
            case R.id.addendaMold:
                if (checked)
                    addenda.add("Protecting Your Home From Mold");
            case R.id.addendaInsurance:
                if (checked)
                    addenda.add("Information Concerning Property Insurance");
            case R.id.addendaGeneral:
                if (checked)
                    addenda.add("General Information and Notice to a Buyer");
        }
    }

    public void nextButton(View view) {
        /** Get Additional Addenda **/
        Intent intent = new Intent(this, Addenda2.class);
        startActivity(intent);
    }
}