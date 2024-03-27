package loginpage.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.apdlab1.R
import com.example.apdlab1.databinding.IncludeExampleBinding
import loginpage.model.Person

class a1LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var homeBinding: IncludeExampleBinding
        super.onCreate(savedInstanceState)
        homeBinding = DataBindingUtil.setContentView(this, R.layout.include_example)
        val credentials:Person = Person();

        if (intent.extras != null) {
            credentials.password = intent.extras?.getString("Password").toString()
        } else {
            credentials.password = "12345678"
        }

        homeBinding.loginPage.forgetPassword.setOnClickListener() {
            val intent = Intent(this@a1LoginPage, a1ForgetPassword::class.java)
            intent.putExtra("Password", credentials.password)
            startActivity(intent)
        }
        homeBinding.loginPage.loginBtn.setOnClickListener() {
            if ((homeBinding.loginPage.usernameTxt.text.toString() == credentials.username) && (homeBinding.loginPage.passwordTxt.text.toString() == credentials.password)) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                homeBinding.loginPage.usernameTxt.setText("")
                homeBinding.loginPage.passwordTxt.setText("")
            } else if ((homeBinding.loginPage.usernameTxt.text.toString() != credentials.username) && (homeBinding.loginPage.passwordTxt.text.toString() != credentials.password)) {
                Toast.makeText(this, "Wrong Credentials!", Toast.LENGTH_SHORT).show();
            } else if (homeBinding.loginPage.usernameTxt.text.toString() != credentials.username) {
                Toast.makeText(this, "Wrong UserName", Toast.LENGTH_SHORT).show();
            } else if ((homeBinding.loginPage.passwordTxt.text.toString() != credentials.password)) {
                Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}                                                                       



