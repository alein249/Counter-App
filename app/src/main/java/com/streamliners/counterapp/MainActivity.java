package com.streamliners.counterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.streamliners.counterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    int qty = 0;
    ActivityMainBinding b;

    private String COUNT_VALUE = "countValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initializing the binding
        // To create layout using layout inflater
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        //Handle click events
        setupEventHandlers();

        //Handle Configuration Changes
        handleConfigurationChanges(savedInstanceState);
    }

    /**
     * Handle data on configuration change
     * @param savedInstanceState To get data from bundle
     */

    private void handleConfigurationChanges(Bundle savedInstanceState) {
        //Check savedInstanceState not null
        if(savedInstanceState != null){
            qty = savedInstanceState.getInt(COUNT_VALUE);
        }
        else{
            //Get data from shredPreference
            qty = getPreferences(MODE_PRIVATE).getInt(COUNT_VALUE, 0);
        }
        b.qty.setText(qty + "");
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNT_VALUE, qty);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferences(MODE_PRIVATE).edit().putInt(COUNT_VALUE, qty).apply();
    }
}