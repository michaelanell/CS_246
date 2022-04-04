package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Intermediary extends AppCompatActivity {
    private static final String FILE_NAME = "request.txt";
    boolean intermediary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediary);
    }

    private void saveUserInput() {
        // creates a FileWriter Object
        String lineBreak = "\r\n";
        String status;
        if (intermediary == true) {
            status = "Intermediary Status\n";
        } else {
            status = "No Intermediary Status\n";
        }

        FileOutputStream newFileStream = null;
        try {
            newFileStream = openFileOutput(FILE_NAME, MODE_APPEND);
          //  newFileStream.write(lineBreak.getBytes());
            newFileStream.write(status.getBytes());
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

    public void nextButtonYes(View view) {
        intermediary = true;
        /** save data **/
        saveUserInput();
        Intent intent = new Intent(this, SaleFees.class);
        startActivity(intent);
    }

    public void nextButtonNo(View view) {
        intermediary = false;
        /** save data **/
        saveUserInput();
        Intent intent = new Intent(this, SaleFees.class);
        startActivity(intent);
    }
}