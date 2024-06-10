
package service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.PRIORITY_MAX
import androidx.core.app.NotificationCompat.PRIORITY_MIN
import com.example.apdlab1.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import service.model.TimeModel
import java.util.Calendar
import java.util.Locale

class FirebaseService : Service(){

    private lateinit var backgroundThread : Job
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("Success" , "Service Initialized")
        val channelId = createNotificationChannel("my_service", "My Background Service")
        val notificationBuilder = NotificationCompat.Builder(this, channelId )
        val notification = notificationBuilder.setOngoing(true)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setPriority(PRIORITY_MAX)
            .setCategory(Notification.CATEGORY_SERVICE)
            .build()
        startForeground(1, notification)
        myService()
        return START_STICKY
    }
    
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(channelId: String, channelName: String): String{
        val chan = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_NONE)
        val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        service.createNotificationChannel(chan)
        return channelId
    }

    override fun onDestroy() {
        Log.e("Success" , "Service Stopped")
        backgroundThread.cancel()
        super.onDestroy()
    }
    fun myService(){
        val timeModel:TimeModel = TimeModel()
        val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        backgroundThread = GlobalScope.launch (Dispatchers.IO){
            while (true){
                val currentTime = Calendar.getInstance()
                val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                timeModel.time = timeFormat.format(currentTime.time).toString()
                Log.e("Success" , timeFormat.format(currentTime.time).toString())
                firebaseFirestore.collection("fa21_BSE_032").document("TestTime").set(timeModel)
                    .addOnSuccessListener {
                        Log.e("Success" , "Time Uploaded on Firestore Succesfully")
                    }
                    .addOnFailureListener{
                        Log.e("Failure" , "Time Uploading Failed")
                    }
                delay(5000)
            }
        }
    }
}
