package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.databinding.tool.util.StringUtils;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GetMarketArea extends AppCompatActivity {
    private static final String FILE_NAME = "request.txt";

    // instance variables
    ArrayList<String> counties = new ArrayList<String>();
    String other;
    String countListString = " ";


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
         other = otherInput.getText().toString();
         counties.add(other);

        for (int i = 0; i < 5; i++ ) {
            countListString += counties.get(i) + ", ";
        }
    }

    private void saveUserInput() {
        // creates a FileWriter Object

        String lineBreak = "\r\n";
        String title = "MarKet Area";


        FileOutputStream newFileStream = null;
        try {
            newFileStream = openFileOutput(FILE_NAME, MODE_APPEND);
            newFileStream.write(lineBreak.getBytes());
            newFileStream.write(title.getBytes());
            newFileStream.write(countListString.getBytes());
            newFileStream.write(lineBreak.getBytes());

           // Toast.makeText(this, "File written to!" + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_SHORT).show();
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
        setMarketArea();

        /** save data **/
        saveUserInput();

       // Intent intent = new Intent(this, DisplayEntry.class);
       Intent intent = new Intent(this, TermLength.class);
        startActivity(intent);
    }


}