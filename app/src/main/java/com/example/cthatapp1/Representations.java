package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Representations extends AppCompatActivity {
    // instance variables
    String representations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_representations);
    }

    public void getIntermediaryStatus(View view) {
        Intent intent = new Intent(this, Intermediary.class);
        startActivity(intent);

        EditText editRepresentations = (EditText) findViewById(R.id.representationsInput);
        representations = editRepresentations.getText().toString();
    }
}