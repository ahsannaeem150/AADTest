package recycler.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import recycler.model.Person

class RecyclerViewModel(application: Application):AndroidViewModel(application) {

    val firebaseFirestore : FirebaseFirestore = FirebaseFirestore.getInstance()
    val personsMLD : MutableLiveData<List<Person>> = MutableLiveData()
    val personsLD : LiveData<List<Person>> = personsMLD

    init {
        upload()
        fetchAllPersons()
    }
    fun fetchAllPersons(){
        firebaseFirestore.collection("persons").get()
            .addOnSuccessListener {
                personsMLD.value = it.toObjects(Person::class.java)
            }
    }
    fun upload(){
        firebaseFirestore.collection("persons").document("ahsan").set(Person(email = "hi" , password = "hello"))
    }
}