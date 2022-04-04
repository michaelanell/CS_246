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

public class DefineRelationshipToClient extends AppCompatActivity {
    private static final String FILE_NAME = "request.txt";

    // instance variables
    String clientRelationship;
    EditText clientRelationshipInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_define_relationship_to_client);

        // get user input
        clientRelationshipInput = (EditText) findViewById(R.id.relationshipToClientInput);
    }

    public void setClientRelationship() {
        clientRelationship = clientRelationshipInput.getText().toString();
    }

    /** Validation methods **/
    private boolean validateClientRelationship() {
        if (clientRelationship.isEmpty()) {
            clientRelationshipInput.setError("Field cannot be empty");
            return false;
        }
        else {
            clientRelationshipInput.setError(null);
            return true;
        }
    }

    private void saveUserInput() {
        // creates a FileWriter Object
        FileOutputStream newFileStream = null;
        String lineBreak = "\r\n";
        // format String
        clientRelationship = "Client Relationship: " + clientRelationshipInput.getText().toString() + "\r\n";

        try {
            newFileStream = openFileOutput(FILE_NAME, MODE_APPEND);
            newFileStream.write(clientRelationship.getBytes());

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

    public void nextButton(View view){
        /** Set instance variables to user input **/
        setClientRelationship();

        /** Validate user input **/
        if (!validateClientRelationship()) {
            return;
        }

        /** save data **/
        saveUserInput();

        /** Collect Marker Area **/
        //Intent intent = new Intent(this, DisplayEntry.class);
        Intent intent = new Intent(this, GetMarketArea.class);
        startActivity(intent);
    }
}