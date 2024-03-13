package tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.apdlab1.R
import com.example.apdlab1.databinding.TictactoeselectorBinding
import loginpage.a1ForgetPassword

class SelectOpponent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var dataBinding: TictactoeselectorBinding
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this , R.layout.tictactoeselector)

        val mainIntent = Intent(this , TickTacToe::class.java)

        dataBinding.computerBtn.setOnClickListener {
            mainIntent.putExtra("Opponent" , true)
            startActivity(mainIntent)
            finish()
        }
        dataBinding.humanBtn.setOnClickListener {
            mainIntent.putExtra("Opponent" , false)
            startActivity(mainIntent)
            finish()
        }
    }
}