package com.example.q1

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize SensorManager
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        // Get the default accelerometer sensor
        val accelerometerSensor: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        // Display sensor name in TextView
        val sensorNameTextView: TextView = findViewById(R.id.sensorNameTextView)

        if (accelerometerSensor != null) {
            val sensorName = accelerometerSensor.name
            sensorNameTextView.text = "Accelerometer Sensor: $sensorName"
        } else {
            sensorNameTextView.text = "Accelerometer Sensor not available"
        }
    }
}