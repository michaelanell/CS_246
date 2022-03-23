package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CollectBuyerAddress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_buyer_address);
    }

    public void getMarketArea(View view){
        Intent intent = new Intent(this, GetMarketArea.class);
        startActivity(intent);
    }
}