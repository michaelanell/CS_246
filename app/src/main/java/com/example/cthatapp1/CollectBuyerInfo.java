package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CollectBuyerInfo extends AppCompatActivity {

    // instance variables
    String buyerOneFirstName;
    String buyerOneLastName;
    String buyerOneEmail;
    int buyerOnePhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_buyer_info);
    }

    public void collectAddress(View view) {
        Intent intent = new Intent(this, CollectBuyerAddress.class);
        startActivity(intent);
    }

    public void twoBuyers(View view) {
        Intent intent = new Intent(this, CollectBuyer2Info.class);
        startActivity(intent);
    }
}