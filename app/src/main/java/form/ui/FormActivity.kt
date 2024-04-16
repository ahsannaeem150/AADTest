package form.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.apdlab1.R
import com.example.apdlab1.databinding.ActivityFormScrollLayoutBinding
import form.model.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FormActivity:AppCompatActivity() {

    lateinit var dataBinding: ActivityFormScrollLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_form_scroll_layout)
        var personData: Person = Person()
        dataBinding.person = personData

        fun validateForm(person: Person): Boolean {
            with(person) {
                if (id != 0 && name?.isNotEmpty() ?: false && email?.isNotEmpty() ?: false && age?.isNotEmpty() ?: false && gender?.isNotEmpty() ?: false && phone?.isNotEmpty() ?: false && religion?.isNotEmpty() ?: false) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        GlobalScope.launch(Dispatchers.IO) {
            while(true) {
                Log.i("LOGI", "Name: ${personData.name} Email: ${personData.email} Age: ${personData.age}")
                delay(2000)
            }
        }
        
        dataBinding.checkLog.setOnClickListener{
            Log.e("LOG" , "Name: ${personData.name} Email: ${personData.email} Age: ${personData.age}")

        }
        dataBinding.loginBtn.setOnClickListener {
            with(dataBinding) {
                personData = Person(
                    id = 1,
                    name = nameText.text.toString(),
                    email = emailText.text.toString(),
                    age = ageText.text.toString(),
                    gender = genderText.text.toString(),
                    phone = phoneText.text.toString(),
                    religion = religionText.text.toString()
                )
            }
            Log.e("Output", personData.toString())
            if(validateForm(personData)){
                Toast.makeText(this, "Login Succesful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}