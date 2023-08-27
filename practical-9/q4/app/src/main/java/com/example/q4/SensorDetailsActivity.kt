package com.example.q4

import android.annotation.SuppressLint
import android.hardware.Sensor
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SensorDetailsActivity : AppCompatActivity() {
    private lateinit var sensor: Sensor

    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_details)

        // Get the selected sensor from the intent
        sensor = intent.getParcelableExtra("sensor")!!

        // Display sensor details
        findViewById<TextView>(R.id.typeTextView).text = getString(R.string.sensor_type, sensor.type)
        findViewById<TextView>(R.id.rangeTextView).text = getString(R.string.sensor_range, sensor.maximumRange)
        findViewById<TextView>(R.id.resolutionTextView).text = getString(R.string.sensor_resolution, sensor.resolution)
        findViewById<TextView>(R.id.powerTextView).text = getString(R.string.sensor_power, sensor.power)
    }
}
