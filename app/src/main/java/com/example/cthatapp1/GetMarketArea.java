package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class GetMarketArea extends AppCompatActivity {

    // instance variables
    ArrayList<String> counties = new ArrayList<String>();
    String other;

    EditText otherInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_market_area);

        otherInput = (EditText) findViewById(R.id.countyOtherInput);
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.countyCollin:
                if (checked) {
                    counties.add("Collin County");
                }
            case R.id.countyDallas:
                if (checked) {
                    counties.add("Dallas County");
                }
            case R.id.countyDenton:
                if (checked) {
                    counties.add("Denton County");
                }
            case R.id.countyTarrant:
                if (checked) {
                    counties.add("Tarrant County");
                }
            case R.id.countyRockwall:
                if (checked) {
                    counties.add("Rockwall County");
                }
        }
    }


    private void setMarketArea() {
     if (TextUtils.isEmpty(otherInput.getText().toString())){
         return;
     }
     else {
         other = otherInput.getText().toString();
         counties.add(other);
     }
    }

    public void nextButton(View view){
        setMarketArea();
        Intent intent = new Intent(this, TermLength.class);
        startActivity(intent);
    }


}