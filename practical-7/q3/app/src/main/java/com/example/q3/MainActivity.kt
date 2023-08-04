package com.example.q3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var text: TextView // Declare the TextView variable without initializing it immediately

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.textViewOne) // Initialize the TextView after calling setContentView()

        val button: Button = findViewById(R.id.buttonOne)
        button.setOnClickListener {
            val message = "Hello from FirstActivity!"
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("EXTRA_MESSAGE", message)
            startActivity(intent)
        }
    }
}
