package com.example.q3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val receivedMessageTextView: TextView = findViewById(R.id.textView)

        // Receive the message from the intent
        val message = intent.getStringExtra("EXTRA_MESSAGE")

        // Display the received message in MainActivity2
        receivedMessageTextView.text = message

        val button = findViewById<Button>(R.id.buttonTwo)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}