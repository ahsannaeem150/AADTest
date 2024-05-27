package service

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apdlab1.R

class BroadcastMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.broadcast_activity)
        val airplaneBroadcast = AirplaneModeBroadcast()
        val intent = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(airplaneBroadcast , intent)
        val serviceIntent = Intent(this, FirebaseService::class.java)
        startService(serviceIntent)
    }

    override fun onDestroy() {
        super.onDestroy()
        val serviceIntent = Intent(this, FirebaseService::class.java)
        startService(serviceIntent)
    }
}