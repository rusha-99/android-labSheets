package com.example.q2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.simpleButton)

        button.setOnClickListener {
            // Create an intent with the action of sending an email
            val intent = Intent(Intent.ACTION_SENDTO)

            // Set the data of the intent to be a mailto URI
            intent.data = Uri.parse("mailto:")

            // Put the predefined email address, subject, and body as extras
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("example@example.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hello from Bing")
            intent.putExtra(Intent.EXTRA_TEXT, "This is a test email")

            // Check if there is an app that can handle the intent
            if (intent.resolveActivity(packageManager) != null) {
                // Start the activity with the intent
                startActivity(intent)
            } else {
                // Show a toast message if no app can handle the intent
                Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show()
            }
        }

    }
}