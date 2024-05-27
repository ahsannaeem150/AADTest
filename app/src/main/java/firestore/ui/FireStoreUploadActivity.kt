package firestore.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.apdlab1.R
import com.example.apdlab1.databinding.ActivityTwowaybindingpracticeBinding
import com.example.apdlab1.databinding.FirestoreuploadloginBinding
import firestore.viewmodel.FirestoreUploadViewmodel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import twowaybindingpractice.viewmodel.TwoWayViewModel

class FireStoreUploadActivity:AppCompatActivity() {

    lateinit var dataBinding: FirestoreuploadloginBinding
    lateinit var viewmodel: FirestoreUploadViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.firestoreuploadlogin)
        viewmodel = ViewModelProvider(this).get(FirestoreUploadViewmodel::class.java)
        setBindings()
        setObservers()
    }
    fun setBindings(){
        dataBinding.viewmodel = viewmodel
    }
    fun setObservers(){

    }
}