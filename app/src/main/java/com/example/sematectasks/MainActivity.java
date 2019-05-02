package com.example.sematectasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Task2", "onCreate: is Running!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Task2", "onStart: is Running!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Task2", "onResume: is Running!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Task2", "onPause: is Running!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Task2", "onStop: is running!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Task2", "onRestart: is running");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Task2", "onDestroy: is running!");
    }
}
