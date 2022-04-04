package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class StartRequest extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String FILE_NAME = "request.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createRequestFile() {
        // create file

        String text = "REQUEST: BUYER REP AGREEMENT \r\n";
        FileOutputStream newFileStream = null;
        try {
            newFileStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
            newFileStream.write(text.getBytes());
         //   Toast.makeText(this, "File written to!" + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_SHORT).show();
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

    /** Called when user clicks START button **/
    public void startRequest(View view) {
        createRequestFile();
        Intent intent = new Intent(this, CollectAgentInfo.class);
        startActivity(intent);

    }


}

