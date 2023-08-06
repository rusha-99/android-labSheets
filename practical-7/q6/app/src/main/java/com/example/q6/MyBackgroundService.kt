package com.example.q6

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast

class MyBackgroundService: Service() {
    private val handler = Handler(Looper.getMainLooper())
    private val toastMessage = "Background Service is running!"

    private val task = object : Runnable {
        override fun run() {
            showToast()
            handler.postDelayed(this, 10000) // 10 seconds
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        handler.post(task)
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }


    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(task)
    }

    private fun showToast() {
        Toast.makeText(applicationContext, toastMessage, Toast.LENGTH_SHORT).show()
    }
}