package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DefineRelationshipToClient extends AppCompatActivity {

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

    public void nextButton(View view){
        setClientRelationship();
        Intent intent = new Intent(this, GetMarketArea.class);
        startActivity(intent);
    }
}