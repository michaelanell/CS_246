package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class TermLength extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private static final String FILE_NAME = "request.txt";

    String termStartDate, termEndDate;
    private EditText startDate;
    private EditText endDate;
    boolean dateType = Boolean.parseBoolean(null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_length);

        startDate = (EditText) findViewById(R.id.startDate);
        endDate = (EditText) findViewById(R.id.endDate);

        findViewById(R.id.setStartDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateType = false;
                showDatePickerDialog();
            }
        });

        findViewById(R.id.setEndDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateType = true;
                showDatePickerDialog();
            }
        });
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        String date = month + "/" + dayOfMonth + "/" + year;

        if (dateType == false) {
            startDate.setText(date);
        }
        else if (dateType) {
            endDate.setText(date);
        }
    }

    private void setTermDates() {
        termStartDate = startDate.getText().toString();
        termEndDate = endDate.getText().toString();
    }

    private boolean validateStartDate(){

        if (termStartDate.isEmpty()) {
            startDate.setError("Field cannot be empty");
            return false;
        }
        else {
            startDate.setError(null);
            return true;
        }
    }

    private boolean ValidateEndDate(){
        if (termEndDate.isEmpty()) {
            endDate.setError("Field cannot be empty");
            return false;
        }
        else {
            endDate.setError(null);
            return true;
        }
    }

    private void saveUserInput() {
        // creates a FileWriter Object
        String lineBreak = "\r\n";

        String wholeTerm = "Term Length: Start Date: " + termStartDate + " End Date:" + termEndDate + "\r\n";
        FileOutputStream newFileStream = null;
        try {
            newFileStream = openFileOutput(FILE_NAME, MODE_APPEND);
            newFileStream.write(lineBreak.getBytes());
            newFileStream.write(wholeTerm.getBytes());
            newFileStream.write(lineBreak.getBytes());
            //Toast.makeText(this, "File written to!" + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_SHORT).show();
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
        setTermDates();

        /** Validate user input **/
        if (!validateStartDate() | !ValidateEndDate()  ) {
            return;
        }

        /** save data **/
        saveUserInput();

        /** Collect Representations **/
        Intent intent = new Intent(this, Intermediary.class);
        startActivity(intent);
    }
}