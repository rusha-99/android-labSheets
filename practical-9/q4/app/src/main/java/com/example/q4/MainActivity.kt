import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.q4.R
import com.example.q4.SensorDetailsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var sensorManager: SensorManager
    private lateinit var sensorList: List<Sensor>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SensorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the SensorManager
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        // Get the list of all available sensors
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL)

        // Set up the RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SensorAdapter(sensorList, object : SensorAdapter.OnSensorClickListener {
            override fun onSensorClick(sensor: Sensor) {
                val intent = Intent(this@MainActivity, SensorDetailsActivity::class.java)
                intent.putExtra("sensor", sensor)
                startActivity(intent)
            }
        })
        recyclerView.adapter = adapter
    }

    private inner class SensorAdapter(
        private val sensors: List<Sensor>,
        private val onSensorClickListener: OnSensorClickListener
    ) : RecyclerView.Adapter<SensorAdapter.ViewHolder>() {

        interface OnSensorClickListener {
            fun onSensorClick(sensor: Sensor)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.sensor_list_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val sensor = sensors[position]
            holder.nameTextView.text = sensor.name
            holder.itemView.setOnClickListener {
                onSensorClickListener.onSensorClick(sensor)
            }
        }

        override fun getItemCount(): Int {
            return sensors.size
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        }
    }
}

private fun Any.putExtra(s: String, sensor: Sensor) {

}

//private fun Intent.putExtra(s: String, sensor: Sensor) {
//
//}
