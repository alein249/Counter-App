package com.streamliners.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.streamliners.counterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int qty = 0;
    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initializing the binding
        // To create layout using layout inflater
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        setupEventHandlers();
    }

    private void setupEventHandlers() {
        b.incBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calling increase function
                incQty();
            }

        });
        b.decBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calling decrease function
                decQty();
            }
        });
    }
   // To decrease the quantity and update the result in Text View

    public void decQty() {

        b.qty.setText("" + --qty);
    }
    //To increase the quantity and update the result in Text View

    public void incQty() {
        b.qty.setText("" + ++qty);
    }
}