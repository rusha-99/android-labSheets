package com.example.q6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Start the background service
        val serviceIntent = Intent(this, MyBackgroundService::class.java)
        startService(serviceIntent)

    }
}