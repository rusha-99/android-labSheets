package com.example.q3

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val receivedMessageTextView: TextView = findViewById(R.id.textViewThree)

        // Receive the message from the intent
        val message = intent.getStringExtra("EXTRA_MESSAGE")

        // Display the received message in MainActivity2
        //receivedMessageTextView.text = message
        receivedMessageTextView.text = message

        val button = findViewById<Button>(R.id.buttonTwo)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}