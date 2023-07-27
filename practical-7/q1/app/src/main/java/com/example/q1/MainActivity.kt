package com.example.q1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

// Set an onClickListener for the button
        button.setOnClickListener {

            // Create a string variable with the web URL
            val url = "https://github.com/rusha-99"

            // Create an Intent object with the action ACTION_VIEW and the data as the web URL
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

            // Start the activity with the intent
            startActivity(intent)
        }


    }
}