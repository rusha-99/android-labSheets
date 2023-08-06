package com.example.q8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val downloadUrl = "https://youtube.com/watch?v=XCvbzVmwnwo"

        val serviceIntent = Intent(this, FileDownloadService::class.java)
        serviceIntent.putExtra(FileDownloadService.EXTRA_DOWNLOAD_URL, downloadUrl)
        startService(serviceIntent)
    }
}