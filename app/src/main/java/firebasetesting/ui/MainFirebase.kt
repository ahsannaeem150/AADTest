package firebasetesting.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.apdlab1.R
import com.example.apdlab1.databinding.FirebaseActivityBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainFirebase:AppCompatActivity() {

    lateinit var dataBinding: FirebaseActivityBinding
    lateinit var firebaseReference:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.firebase_activity)
        firebaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child("User1").child("name")
        firebaseReference.setValue("Ahsan")

    }
}