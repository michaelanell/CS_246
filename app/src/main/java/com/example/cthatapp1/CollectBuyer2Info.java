package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CollectBuyer2Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_buyer2_info);
    }

    public void collectAddress(View view) {
        Intent intent = new Intent(this, CollectBuyerAddress.class);
        startActivity(intent);
    }
}