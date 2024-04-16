package taskone.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.apdlab1.R
import taskone.model.DataModel
import com.example.apdlab1.databinding.TaskOneBinding

class TaskOne:AppCompatActivity() {

    lateinit var dataBinding: TaskOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.task_one)

        var dataModel:DataModel = DataModel()
        dataBinding.dataModel = dataModel
    }
}