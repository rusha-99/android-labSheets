import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.q2.R

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometerSensor: Sensor? = null
    private lateinit var sensorValueTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorValueTextView = findViewById(R.id.sensorValueTextView)

        // Initialize SensorManager
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        // Get the default accelerometer sensor
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        if (accelerometerSensor != null) {
            val sensorName = accelerometerSensor!!.name
            val sensorNameTextView: TextView = findViewById(R.id.sensorNameTextView)
            sensorNameTextView.text = "Accelerometer Sensor: $sensorName"

            // Register your activity as a listener for accelerometer sensor
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL)
        } else {
            val sensorNameTextView: TextView = findViewById(R.id.sensorNameTextView)
            sensorNameTextView.text = "Accelerometer Sensor not available"
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val xAxisValue = event.values[0]
            sensorValueTextView.text = "X-Axis Acceleration: $xAxisValue"
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Not needed for this example
    }

    override fun onPause() {
        super.onPause()
        // Unregister the listener when the activity is paused
        sensorManager.unregisterListener(this)
    }
}
