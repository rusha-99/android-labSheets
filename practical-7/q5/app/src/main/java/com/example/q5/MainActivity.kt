package com.example.q5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startForegroundServiceButton = findViewById<Button>(R.id.startForegroundServiceButton)
        startForegroundServiceButton.setOnClickListener {
            startForegroundService()
        }
    }

    private fun startForegroundService() {
        val serviceIntent = Intent(this, MyForegroundService::class.java)
        startService(serviceIntent)
    }
}