package loginpage.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.apdlab1.R
import com.example.apdlab1.databinding.A1ForgetpasswordBinding

class a1ForgetPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var dataBinding: A1ForgetpasswordBinding
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.a1_forgetpassword)

        var password: String = intent.extras?.getString("Password").toString();
        dataBinding.confirmBtn.setOnClickListener() {
            if (dataBinding.passwordTxt.text.toString() != dataBinding.confirmPasswordTxt.text.toString()) {
                Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show()
            } else {
                if (dataBinding.passwordTxt.text.toString() == password) {
                    Toast.makeText(this, "New Password Cannot Be Same As The Old Password", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Password Changed", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this , a1LoginPage::class.java)
                    intent.putExtra("Password", dataBinding.confirmPasswordTxt.text.toString());
                    startActivity(intent)
                }
            }
        }
    }
}