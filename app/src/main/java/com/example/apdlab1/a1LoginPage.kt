package com.example.apdlab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.apdlab1.databinding.A1LoginpageBinding

class a1LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var homeBinding: A1LoginpageBinding
        super.onCreate(savedInstanceState)
        homeBinding = DataBindingUtil.setContentView(this , R.layout.a1_loginpage)

        val username = "ahsannaeem150"
        val password = "12345678"

        homeBinding.loginBtn.setOnClickListener() {
            if ((homeBinding.usernameTxt.text.toString() == username) && (homeBinding.passwordTxt.text.toString() == password)) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                homeBinding.usernameTxt.setText("")
                homeBinding.passwordTxt.setText("")
            }
            if((homeBinding.usernameTxt.text.toString() == username) && (homeBinding.passwordTxt.text.toString() != password)){
                Toast.makeText(this , "Wrong Password!" , Toast.LENGTH_SHORT).show();
            } else if((homeBinding.passwordTxt.text.toString() == password) && (homeBinding.usernameTxt.text.toString() != username)){
                Toast.makeText(this , "Wrong Username!" , Toast.LENGTH_SHORT).show();
            } else if((homeBinding.usernameTxt.text.toString() != username) && (homeBinding.passwordTxt.text.toString() != password)){
                Toast.makeText(this , "Wrong Credentials!" , Toast.LENGTH_SHORT).show();
            }
        }
    }
}



