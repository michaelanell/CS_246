package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CollectBrokerageInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_brokerage_info);
    }

    /** Called when user clicks Next button **/
    public void collectDueByInfo(View view) {
        Intent intent = new Intent(this, DueBy.class);
        startActivity(intent);
    }
}