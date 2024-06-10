package recycler.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apdlab1.R
import com.example.apdlab1.databinding.RecyclerAllDataBinding
import com.google.firebase.database.DatabaseReference
import recycler.viewmodel.RecyclerViewModel
import recycler.adopter.RecylerAdopter

class RecyclerMainActivity:AppCompatActivity() {

    lateinit var dataBinding: RecyclerAllDataBinding
    lateinit var recyclerAdopter : RecylerAdopter
    lateinit var viewmodel : RecyclerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.recycler_all_data)
        viewmodel = ViewModelProvider(this).get(RecyclerViewModel::class.java)
        recyclerAdopter = RecylerAdopter(viewModel = viewmodel)
        setBindings()
        setObservers()

    }

    fun setBindings(){
        with(dataBinding) {
            lifecycleOwner = this@RecyclerMainActivity
            personRV.adapter = this@RecyclerMainActivity.recyclerAdopter
            personRV.layoutManager = LinearLayoutManager(this@RecyclerMainActivity)
        }
    }
    fun setObservers(){
        viewmodel.personsLD.observe(this){
            Log.e("data" , "${it}")
            recyclerAdopter.submitList(it)
            recyclerAdopter.notifyDataSetChanged()
        }
    }
}