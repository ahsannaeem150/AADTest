package covariantandcontravariant.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.apdlab1.R
import com.example.apdlab1.databinding.ActivityContravariantBinding
import covariantandcontravariant.model.BirdCatchModel
import covariantandcontravariant.model.Crow


import covariantandcontravariant.viewmodel.ContravarantViewModel

class MainContravariant:AppCompatActivity() {

    lateinit var dataBinding: ActivityContravariantBinding
    lateinit var birdViewModel:ContravarantViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_contravariant)
        birdViewModel = ViewModelProvider(this).get(ContravarantViewModel::class.java)
        setBindings()
        setObserver()
    }
    fun setBindings(){
        with(dataBinding){
            viewModel = birdViewModel
        }
    }
    fun setObserver(){
        dataBinding.viewModel?.catchStatusLD?.observe(this@MainContravariant){
            if(it){
                Toast.makeText(this@MainContravariant, "Name -> ${BirdCatchModel.onCatchSucces("Crow" , Crow().name).bird}, Size-> ${BirdCatchModel.onCatchSucces("Crow" , Crow().size).bird}", Toast.LENGTH_SHORT).show()
                dataBinding.birdImage.setImageResource(R.drawable.crow)
            }  else {
                Toast.makeText(this@MainContravariant, BirdCatchModel.onCatchFail("No Bird" , "CatchFail").bird, Toast.LENGTH_SHORT).show()
                dataBinding.birdImage.setImageResource(R.drawable.no_crow)
            }
        }
    }
}