package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IsThereClientRelationship extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_there_client_relationship);
    }

    public void DefineClientRelationship(View view) {
        Intent intent = new Intent(this, DefineRelationshipToClient.class);
        startActivity(intent);
    }

    public void getMarketArea(View view){
        Intent intent = new Intent(this, GetMarketArea.class);
        startActivity(intent);
    }
}