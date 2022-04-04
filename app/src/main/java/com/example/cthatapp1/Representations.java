package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Representations extends AppCompatActivity {
    private static final String FILE_NAME = "request.txt";

    // instance variables
    String representations;
    boolean representationsStatus;

    EditText representationsInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_representations);

        representationsInput = (EditText) findViewById(R.id.representationsInput);
        representations = representationsInput.getText().toString();
    }

    private void areThereRepresentations(){
        if (representations.isEmpty()) {
            representationsStatus = false;
        }
        else {
            representationsStatus = true;
        }
    }

    private void saveUserInput() {
        // creates a FileWriter Object
        String lineBreak = "\r\n";
        FileOutputStream newFileStream = null;
        representations = "Representations: " + representationsInput.getText().toString() + "\r\n";

        try {
            newFileStream = openFileOutput(FILE_NAME, MODE_APPEND);
            newFileStream.write(representations.getBytes());

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
        /** Check if there are representations **/
        areThereRepresentations();

        if (representationsStatus == true) {
            /** save data **/
            saveUserInput();
        }

        Intent intent = new Intent(this, Intermediary.class);
        startActivity(intent);
    }
}