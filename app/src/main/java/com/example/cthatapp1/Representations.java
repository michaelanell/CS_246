package com.example.cthatapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Representations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_representations);
    }

    public void getIntemediaryStatus(View view) {
        Intent intent = new Intent(this, Intermediary.class);
        startActivity(intent);
    }
}