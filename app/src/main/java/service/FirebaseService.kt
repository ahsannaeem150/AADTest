
package service

import android.app.Service
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.IBinder
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import service.model.TimeModel
import java.util.Calendar
import java.util.Locale

class FirebaseService : Service(){
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e("Success" , "Service Initialized")
        myBackgroundService()
        return START_STICKY
    }

    fun myBackgroundService(){
        val timeModel:TimeModel = TimeModel()
        val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        GlobalScope.launch (Dispatchers.IO){
            while (true){
                val currentTime = Calendar.getInstance()
                val timeFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                timeModel.time = timeFormat.format(currentTime.time).toString()
                Log.e("Success" , timeFormat.format(currentTime.time).toString())
                firebaseFirestore.collection("time").document(timeModel.time?: "00:00:00").set(timeModel)
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