package com.example.apdlab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.apdlab1.databinding.TicktactoeBinding

class ticktactoeMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var homeBinding: TicktactoeBinding
        super.onCreate(savedInstanceState)
        homeBinding = DataBindingUtil.setContentView(this , R.layout.ticktactoe)
        var playerTurn: Boolean = true

        fun switchTurn(){
            if(playerTurn){
                homeBinding.player.setText("Player 2")
            } else {
                homeBinding.player.setText("Player 1")
            }
            playerTurn = !playerTurn
        }
        
        fun endGame(){
            homeBinding.endGame.setVisibility(View.VISIBLE);
        }

        fun disableTurnsWhenSomeoneWins(){
            homeBinding.topLeftTxt.setOnClickListener(null);
            homeBinding.topCenterTxt.setOnClickListener(null);
            homeBinding.topRightTxt.setOnClickListener(null);
            homeBinding.centerLeftTxt.setOnClickListener(null);
            homeBinding.centerTxt.setOnClickListener(null);
            homeBinding.centerRightTxt.setOnClickListener(null);
            homeBinding.bottomLeftTxt.setOnClickListener(null);
            homeBinding.bottomCenterTxt.setOnClickListener(null);
            homeBinding.bottomRightTxt.setOnClickListener(null);

        }
        fun currentPlayerWon(){
            if(playerTurn){
                homeBinding.resultTxt.text = "Winner: Player 1"
            } else {
                homeBinding.resultTxt.text = "Winner: Player 2"
            }
            disableTurnsWhenSomeoneWins()
            endGame()
        }
        fun checkResult(){
            if((homeBinding.topLeftTxt.text.toString() == homeBinding.topCenterTxt.text.toString()) && (homeBinding.topLeftTxt.text.toString() == homeBinding.topRightTxt.text.toString()) && (homeBinding.topCenterTxt.text.toString().isNotEmpty())) {
                currentPlayerWon()
            } else if((homeBinding.centerLeftTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.centerLeftTxt.text.toString() == homeBinding.centerRightTxt.text.toString()) && (homeBinding.centerTxt.text.toString().isNotEmpty())) {
                currentPlayerWon()
            } else if((homeBinding.bottomLeftTxt.text.toString() == homeBinding.bottomCenterTxt.text.toString()) && (homeBinding.bottomLeftTxt.text.toString() == homeBinding.bottomRightTxt.text.toString())  && (homeBinding.bottomCenterTxt.text.toString().isNotEmpty())){
                currentPlayerWon()
            }  else if((homeBinding.topLeftTxt.text.toString() == homeBinding.centerLeftTxt.text.toString()) && (homeBinding.topLeftTxt.text.toString() == homeBinding.bottomLeftTxt.text.toString()) && (homeBinding.centerLeftTxt.text.toString().isNotEmpty())){
                currentPlayerWon()
            }   else if((homeBinding.topCenterTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.topCenterTxt.text.toString() == homeBinding.bottomCenterTxt.text.toString())  && (homeBinding.centerTxt.text.toString().isNotEmpty()))  {
                currentPlayerWon()
            }   else if((homeBinding.topRightTxt.text.toString() == homeBinding.centerRightTxt.text.toString()) && (homeBinding.topRightTxt.text.toString() == homeBinding.bottomRightTxt.text.toString())  && (homeBinding.centerRightTxt.text.toString().isNotEmpty())){
                currentPlayerWon()
            }   else if((homeBinding.topLeftTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.topLeftTxt.text.toString() == homeBinding.bottomRightTxt.text.toString()) && (homeBinding.bottomRightTxt.text.toString().isNotEmpty()))  {
                currentPlayerWon()
            }   else if((homeBinding.topRightTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.topRightTxt.text.toString() == homeBinding.bottomLeftTxt.text.toString()) && (homeBinding.bottomLeftTxt.text.toString().isNotEmpty())) {
                currentPlayerWon()
            }
        }

        fun ifAllBoxesFilled(){
            if(homeBinding.topLeftTxt.text.isNotEmpty() && homeBinding.topCenterTxt.text.isNotEmpty() && homeBinding.topRightTxt.text.isNotEmpty() && homeBinding.centerLeftTxt.text.isNotEmpty() && homeBinding.centerTxt.text.isNotEmpty() && homeBinding.centerRightTxt.text.isNotEmpty() && homeBinding.bottomLeftTxt.text.isNotEmpty() && homeBinding.bottomCenterTxt.text.isNotEmpty() && homeBinding.bottomRightTxt.text.isNotEmpty()) {
                homeBinding.resultTxt.text = "IT'S A TIE!"
                homeBinding.endGame.setVisibility(View.VISIBLE)
            }
        }

        fun playerAction(clickedBox: TextView){
            if(clickedBox.text.toString().isEmpty()){
                if(playerTurn){
                    clickedBox.text = "X"
                } else {
                    clickedBox.text = "O"
                }
                ifAllBoxesFilled()
                checkResult()
                switchTurn()
            }
        }

        fun setListeners(){
            homeBinding.topLeftTxt.setOnClickListener{
                playerAction(homeBinding.topLeftTxt)
            }
            homeBinding.topCenterTxt.setOnClickListener{
                playerAction(homeBinding.topCenterTxt)
            }
            homeBinding.topRightTxt.setOnClickListener{
                playerAction(homeBinding.topRightTxt)
            }
            homeBinding.centerLeftTxt.setOnClickListener{
                playerAction(homeBinding.centerLeftTxt)
            }
            homeBinding.centerTxt.setOnClickListener{
                playerAction(homeBinding.centerTxt)
            }
            homeBinding.centerRightTxt.setOnClickListener{
                playerAction(homeBinding.centerRightTxt)
            }
            homeBinding.bottomLeftTxt.setOnClickListener{
                playerAction(homeBinding.bottomLeftTxt)
            }
            homeBinding.bottomCenterTxt.setOnClickListener{
                playerAction(homeBinding.bottomCenterTxt)
            }
            homeBinding.bottomRightTxt.setOnClickListener{
                playerAction(homeBinding.bottomRightTxt)
            }
        }

        fun newGame(){
            homeBinding.topLeftTxt.text = ""
            homeBinding.topCenterTxt.text = ""
            homeBinding.topRightTxt.text = ""
            homeBinding.centerLeftTxt.text = ""
            homeBinding.centerTxt.text = ""
            homeBinding.centerRightTxt.text = ""
            homeBinding.bottomLeftTxt.text = ""
            homeBinding.bottomCenterTxt.text = ""
            homeBinding.bottomRightTxt.text = ""
            homeBinding.resultTxt.text = ""
            playerTurn = true
            homeBinding.player.setText("Player 1")
            homeBinding.endGame.setVisibility(View.GONE)
            setListeners()
        }
        homeBinding.endGame.setOnClickListener {
            newGame()
        }
        newGame()
    }
}