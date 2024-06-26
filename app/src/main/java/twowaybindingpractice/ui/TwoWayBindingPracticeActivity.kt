package twowaybindingpractice.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.apdlab1.R
import com.example.apdlab1.databinding.ActivityTwowaybindingpracticeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import twowaybindingpractice.viewmodel.TwoWayViewModel

class TwoWayBindingPracticeActivity:AppCompatActivity() {

    lateinit var dataBinding: ActivityTwowaybindingpracticeBinding
    lateinit var viewmodel: TwoWayViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_twowaybindingpractice)
        viewmodel = ViewModelProvider(this).get(TwoWayViewModel::class.java)
        setBindings()
        setObservers()
    }
    fun setBindings(){
        dataBinding.viewmodel = viewmodel
        dataBinding.model = viewmodel.name

    }
    fun setObservers(){
        viewmodel.nameModelLD.observe(this, {
           dataBinding.nameShowTxt.text = viewmodel.nameModelLD.value
        })
    }
}