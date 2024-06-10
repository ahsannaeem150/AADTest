package service

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apdlab1.R
import com.example.apdlab1.databinding.BroadcastActivityBinding
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BroadcastMainActivity : AppCompatActivity() {
    lateinit var databinding: BroadcastActivityBinding
    var timeFromFirebaseMLD: MutableLiveData<String>  = MutableLiveData("00:00:00")
    var timeFromFirebaseLD: LiveData<String>  = timeFromFirebaseMLD
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this , R.layout.broadcast_activity)

        GlobalScope.launch (Dispatchers.IO){
            while (true){
                getCurrentTimeFromFirebase()
                delay(1000)                         
            }
        }
        val serviceIntent = Intent(this, FirebaseService::class.java)
        databinding.startService.setOnClickListener{
            Toast.makeText(this , "Service Initiated" , Toast.LENGTH_SHORT).show()
            startService(serviceIntent)
        }
        databinding.stopService.setOnClickListener{
            Toast.makeText(this , "Service Suspended" , Toast.LENGTH_SHORT).show()
            stopService(serviceIntent)
        }
        timeFromFirebaseLD.observe(this@BroadcastMainActivity , {
            databinding.updatedTime.text = it
        })    
    }
    fun getCurrentTimeFromFirebase(){
        val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        firebaseFirestore.collection("fa21_BSE_032").document("TestTime").get()
            .addOnSuccessListener {
                timeFromFirebaseMLD.postValue(it.get("time").toString())
            }
            .addOnFailureListener {
                Log.e("Failure" , "Failure")
                timeFromFirebaseMLD.postValue("00:00:00")
            }
    }
}
