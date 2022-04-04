package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IsThereClientRelationship extends AppCompatActivity {
    private static final String FILE_NAME = "request.txt";

    boolean clientRelationship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_there_client_relationship);
    }

    private void saveUserInput() {
        // creates a FileWriter Object
        String lineBreak = "\r\n";
        FileOutputStream newFileStream = null;

        String clientRelationshipStatus;
        if (clientRelationship == true) {
            clientRelationshipStatus = "Client Relationship Exists - ";
        } else {
            clientRelationshipStatus = "No Client Relationship";
        }

        try {
            newFileStream = openFileOutput(FILE_NAME, MODE_APPEND);
            newFileStream.write(lineBreak.getBytes());
            newFileStream.write(clientRelationshipStatus.getBytes());
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

    public void clientRelationshipYes(View view) {
        /** Set instance variables to user input **/
        clientRelationship = true;

        /** save data **/
        saveUserInput();


        Intent intent = new Intent(this, DefineRelationshipToClient.class);
        startActivity(intent);
    }

    public void clientRelationshipNo(View view){
        /** Set instance variables to user input **/
        clientRelationship = false;

        /** save data **/
        saveUserInput();

        Intent intent = new Intent(this, GetMarketArea.class);
        startActivity(intent);
    }
}