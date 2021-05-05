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

        //Handle click events
        setupEventHandlers();
    }

    /**
     * Trigger Event handlers to listen the actions
     */
    private void setupEventHandlers() {
        //click listener on Increase button
        b.incBtn.setOnClickListener(v -> {
            // Calling increase function
            incQty();
        });
        //click listener on Decrease button
        b.decBtn.setOnClickListener(v -> {
            // Calling decrease function
            decQty();
        });
    }

    /**
     * Decrease the quantity
     * update TextView
     */
    public void decQty() {
        //update quantity and textView
        b.qty.setText("" + --qty);
    }

    /**
     * Increase the quantity
     * update TextView
     */
    public void incQty() {
        //update quantity and textView
        b.qty.setText("" + ++qty);
    }
}