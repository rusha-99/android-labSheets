package com.example.q8

import android.app.Service
import android.content.Intent
import android.os.AsyncTask
import android.os.IBinder
import java.io.BufferedInputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class FileDownloadService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Get the download URL from the intent
        val downloadUrl = intent?.getStringExtra(EXTRA_DOWNLOAD_URL)

        // Start the file download task
        downloadUrl?.let {
            DownloadTask().execute(it)
        }

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private inner class DownloadTask : AsyncTask<String, Void, Boolean>() {

        override fun doInBackground(vararg urls: String): Boolean {
            val urlString = urls[0]
            try {
                val url = URL(urlString)
                val connection = url.openConnection() as HttpURLConnection
                connection.connect()

                val input = BufferedInputStream(url.openStream())
                val outputFile = File(cacheDir, "downloaded_file")
                val output = FileOutputStream(outputFile)

                val data = ByteArray(1024)
                var total: Long = 0
                var count: Int

                while (input.read(data).also { count = it } != -1) {
                    total += count
                    output.write(data, 0, count)
                }

                output.flush()
                output.close()
                input.close()

                return true
            } catch (e: IOException) {
                e.printStackTrace()
                return false
            }
        }

        override fun onPostExecute(result: Boolean) {
            // Handle the download completion here, e.g., show a notification or update UI
        }
    }

    companion object {
        const val EXTRA_DOWNLOAD_URL = "extra_download_url"
    }
}