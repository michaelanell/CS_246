package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.net.Uri;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class SubmitEntry extends AppCompatActivity {
    private static final String FILE_NAME = "request.txt";
    Button button;
    TextView viewEntry;
    String data;
    TextView displayData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_entry);

        viewEntry = findViewById(R.id.viewEntry);

        button = findViewById(R.id.submitButton);
        displayData = findViewById(R.id.dataView);

        setDisplay();

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view)
            {
                String emailsend = "michaela@simplifysmallbiz.com";
                String emailsubject = "REQUEST For Buyer Representation Agreement";
                String emailbody = viewEntry.getText().toString();

                // define Intent object
                // with action attribute as ACTION_SEND
                Intent intent = new Intent(Intent.ACTION_SEND);

                // add three fields to intent using putExtra function
                intent.putExtra(Intent.EXTRA_EMAIL,
                        new String[] { emailsend });
                intent.putExtra(Intent.EXTRA_SUBJECT, emailsubject);
                intent.putExtra(Intent.EXTRA_TEXT, emailbody);

                // set type of intent
                intent.setType("message/rfc822");

                // startActivity with intent with chooser
                // as Email client using createChooser function
                startActivity(
                        Intent
                                .createChooser(intent,
                                        "Choose an Email client :"));
            }
        });

    }

    public void setDisplay() {
        FileInputStream fis = null;

        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            viewEntry.setText(sb.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}