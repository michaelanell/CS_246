package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DueBy extends AppCompatActivity {
    int dueDate;
    int dueTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_due_by);
    }

    /** Called when user clicks Next button **/
    public void collectBuyerInfo(View view) {
        Intent intent = new Intent(this, CollectBuyerInfo.class);
        startActivity(intent);
    }


}