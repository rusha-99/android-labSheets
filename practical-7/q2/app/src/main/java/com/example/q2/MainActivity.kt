package com.example.q2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var mEditTextTo: EditText
    private lateinit var mEditTextSubject: EditText
    private lateinit var mEditTextMessage: EditText
    private lateinit var buttonSend: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the EditText and Button variables after calling setContentView
        mEditTextTo = findViewById(R.id.edit_text_to)
        mEditTextSubject = findViewById(R.id.edit_text_subject)
        mEditTextMessage = findViewById(R.id.edit_text_message)
        buttonSend = findViewById(R.id.button_send)

        buttonSend.setOnClickListener {
            sendMail()
        }
    }

    private fun sendMail() {
        val recipientList: String = mEditTextTo.text.toString()
        var recipients = arrayOf<String>()

        recipients = recipientList.split(",").toTypedArray()

        val subject: String = mEditTextSubject.text.toString()
        val message: String = mEditTextMessage.text.toString()

        // Create a mailto URI with the recipients, subject, and message
        val uri = Uri.parse("mailto:")
            .buildUpon()
            .appendQueryParameter("to", recipients.joinToString(","))
            .appendQueryParameter("subject", subject)
            .appendQueryParameter("body", message)
            .build()

        // Create an intent with the action of sending an email and the mailto URI
        val intent = Intent(Intent.ACTION_SENDTO, uri)

        // Start the activity with a chooser
        startActivity(Intent.createChooser(intent, "Choose an email client"))
    }
}