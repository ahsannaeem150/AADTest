package firestore.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import firestore.model.Person
import java.lang.Exception

class FirestoreUploadViewmodel(application: Application):AndroidViewModel(application) {

    val person:Person = Person("" , "")
    val db:FirebaseFirestore = FirebaseFirestore.getInstance()
    fun uploadFirebase(){
        Log.e("Pressed" , "Upload Initiated")
        try{
        db.collection("persons").document(person.email?: "Undefined").set(person).addOnSuccessListener {
            Log.e("Success" , "Upload Succesful")
        } .addOnFailureListener {
            Log.e("Failure" , "Upload Failed")
        }
        } catch (ex:Exception){
            Log.e("Exception" , "${ex}")
        }
    }
    
}