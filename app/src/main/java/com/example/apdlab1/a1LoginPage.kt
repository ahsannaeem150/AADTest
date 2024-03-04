package com.example.apdlab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class a1LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a1_loginpage)

        var correctPassword = true
        var correctUsername = true
        val username = "ahsannaeem150"
        val password = "12345678"
        val usernameTxt:EditText = findViewById(R.id.usernameTxt)
        val passwordTxt:EditText = findViewById(R.id.passwordTxt)
        val loginBtn:Button = findViewById(R.id.loginBtn)

        loginBtn.setOnClickListener(){
            if(usernameTxt.text.toString() != username){
                correctUsername = false;
            }
            if(passwordTxt.text.toString() != password){
                correctPassword = false
            }
            if(correctUsername && correctPassword){
                Toast.makeText(this ,"Login Successful!" , Toast.LENGTH_SHORT ).show();
            }
            
        }
    }
}


