package viewmodelexample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.apdlab1.R
import com.example.apdlab1.databinding.ActivityViewmodelexampleBinding
import viewmodelexample.viewmodel.MainActivityViewModel


class MainActivity:AppCompatActivity() {

    lateinit var dataBinding: ActivityViewmodelexampleBinding
    lateinit var counterViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_viewmodelexample)
        counterViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        updateCount()
       setBindings()
    }

    fun updateCount(){
        counterViewModel.counterLD.observe(this@MainActivity){
            dataBinding.countTxt.text = counterViewModel.counterLD.value?.counter.toString()
        }
    }
    fun setBindings(){
            dataBinding.viewModel = this@MainActivity.counterViewModel

    }
}