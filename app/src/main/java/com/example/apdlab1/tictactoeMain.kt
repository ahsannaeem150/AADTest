package com.example.apdlab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.apdlab1.databinding.TicktactoeBinding

class ticktactoeMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var homeBinding: TicktactoeBinding

        super.onCreate(savedInstanceState)
//        setContentView(R.layout.ticktactoe)
        homeBinding = DataBindingUtil.setContentView(this , R.layout.ticktactoe)
        homeBinding.endGame.setVisibility(View.GONE);           //hiding reset button until someone wins
        homeBinding.player.setText("Player 1")
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

        fun currentPlayerWon(){
            if(playerTurn){
                homeBinding.resultTxt.text = "Winner: Player 1"
            } else {
                homeBinding.resultTxt.text = "Winner: Player 2"
            }
            endGame()
        }


        fun checkResult(){
            if((homeBinding.topLeftTxt.text.toString() == homeBinding.topCenterTxt.text.toString()) && (homeBinding.topLeftTxt.text.toString() == homeBinding.topRightTxt.text.toString()) && (homeBinding.topCenterTxt.text.toString() == "O" || homeBinding.topCenterTxt.text.toString() == "1")) {
                currentPlayerWon()
            } else if((homeBinding.centerLeftTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.centerLeftTxt.text.toString() == homeBinding.centerRightTxt.text.toString()) && (homeBinding.centerTxt.text.toString() == "O" || homeBinding.centerTxt.text.toString() == "1")) {
                currentPlayerWon()
            } else if((homeBinding.bottomLeftTxt.text.toString() == homeBinding.bottomCenterTxt.text.toString()) && (homeBinding.bottomLeftTxt.text.toString() == homeBinding.bottomRightTxt.text.toString())  && (homeBinding.bottomCenterTxt.text.toString() == "O" || homeBinding.bottomCenterTxt.text.toString() == "1")){
                currentPlayerWon()
            }  else if((homeBinding.topLeftTxt.text.toString() == homeBinding.centerLeftTxt.text.toString()) && (homeBinding.topLeftTxt.text.toString() == homeBinding.bottomLeftTxt.text.toString()) && (homeBinding.centerLeftTxt.text.toString() == "O" || homeBinding.centerLeftTxt.text.toString() == "1")){
                currentPlayerWon()
            }   else if((homeBinding.topCenterTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.topCenterTxt.text.toString() == homeBinding.bottomCenterTxt.text.toString())  && (homeBinding.centerTxt.text.toString() == "O" || homeBinding.centerTxt.text.toString() == "1"))  {
                currentPlayerWon()
            }   else if((homeBinding.topRightTxt.text.toString() == homeBinding.centerRightTxt.text.toString()) && (homeBinding.topRightTxt.text.toString() == homeBinding.bottomRightTxt.text.toString())  && (homeBinding.centerRightTxt.text.toString() == "O" || homeBinding.centerRightTxt.text.toString() == "1")){
                currentPlayerWon()
            }   else if((homeBinding.topLeftTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.topLeftTxt.text.toString() == homeBinding.bottomRightTxt.text.toString()) && (homeBinding.bottomRightTxt.text.toString() == "O" || homeBinding.bottomRightTxt.text.toString() == "1"))  {
                currentPlayerWon()
            }   else if((homeBinding.topRightTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.topRightTxt.text.toString() == homeBinding.bottomLeftTxt.text.toString()) && (homeBinding.bottomLeftTxt.text.toString() == "O" || homeBinding.bottomLeftTxt.text.toString() == "1")) {
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
        }

        homeBinding.endGame.setOnClickListener {
            newGame()
        }
    }
}