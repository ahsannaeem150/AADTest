package loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.apdlab1.R
import com.example.apdlab1.databinding.A1LoginpageBinding

class a1LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var homeBinding: A1LoginpageBinding
        super.onCreate(savedInstanceState)
        homeBinding = DataBindingUtil.setContentView(this, R.layout.a1_loginpage)

        val username = "ahsannaeem150"
        var password: String;
        if (intent.extras != null) {
            password = intent.extras?.getString("Password").toString()
        } else {
            password = "12345678"
        }

        homeBinding.forgetPassword.setOnClickListener() {
            val intent = Intent(this@a1LoginPage, a1ForgetPassword::class.java)
            intent.putExtra("Password", password)
            startActivity(intent)
        }
        homeBinding.loginBtn.setOnClickListener() {
            if ((homeBinding.usernameTxt.text.toString() == username) && (homeBinding.passwordTxt.text.toString() == password)) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                homeBinding.usernameTxt.setText("")
                homeBinding.passwordTxt.setText("")
            } else if ((homeBinding.usernameTxt.text.toString() != username) && (homeBinding.passwordTxt.text.toString() != password)) {
                Toast.makeText(this, "Wrong Credentials!", Toast.LENGTH_SHORT).show();
            } else if (homeBinding.usernameTxt.text.toString() != username) {
                Toast.makeText(this, "Wrong UserName", Toast.LENGTH_SHORT).show();

            } else if ((homeBinding.passwordTxt.text.toString() != password)) {
                Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}                                                                       



