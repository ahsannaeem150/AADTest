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
        var playerTurn = true

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
            homeBinding.topLeftTxt.setOnClickListener(null)
            homeBinding.topCenterTxt.setOnClickListener(null)
            homeBinding.topRightTxt.setOnClickListener(null)
            homeBinding.middleLeftTxt.setOnClickListener(null)
            homeBinding.centerTxt.setOnClickListener(null)
            homeBinding.middleRightTxt.setOnClickListener(null)
            homeBinding.bottomLeftTxt.setOnClickListener(null)
            homeBinding.bottomCenterTxt.setOnClickListener(null)
            homeBinding.bottomRightTxt.setOnClickListener(null)
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
        fun drawLine(combination: Int){
            if(combination == 1){
                homeBinding.topLeftLine.visibility = View.VISIBLE
                homeBinding.topCenterLine.visibility = View.VISIBLE
                homeBinding.topRightLine.visibility = View.VISIBLE
                homeBinding.topLeftLine.rotation = 90F
                homeBinding.topCenterLine.rotation = 90F
                homeBinding.topRightLine.rotation = 90F
            }
        }
        fun checkResult(){
            if((homeBinding.topLeftTxt.text.toString() == homeBinding.topCenterTxt.text.toString()) && (homeBinding.topLeftTxt.text.toString() == homeBinding.topRightTxt.text.toString()) && (homeBinding.topCenterTxt.text.toString().isNotEmpty())) {
                currentPlayerWon()
                drawLine(1)
            } else if((homeBinding.middleLeftTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.middleLeftTxt.text.toString() == homeBinding.middleRightTxt.text.toString()) && (homeBinding.centerTxt.text.toString().isNotEmpty())) {
                currentPlayerWon()
            } else if((homeBinding.bottomLeftTxt.text.toString() == homeBinding.bottomCenterTxt.text.toString()) && (homeBinding.bottomLeftTxt.text.toString() == homeBinding.bottomRightTxt.text.toString())  && (homeBinding.bottomCenterTxt.text.toString().isNotEmpty())){
                currentPlayerWon()
            }  else if((homeBinding.topLeftTxt.text.toString() == homeBinding.middleLeftTxt.text.toString()) && (homeBinding.topLeftTxt.text.toString() == homeBinding.bottomLeftTxt.text.toString()) && (homeBinding.middleLeftTxt.text.toString().isNotEmpty())){
                currentPlayerWon()
            }   else if((homeBinding.topCenterTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.topCenterTxt.text.toString() == homeBinding.bottomCenterTxt.text.toString())  && (homeBinding.centerTxt.text.toString().isNotEmpty()))  {
                currentPlayerWon()
            }   else if((homeBinding.topRightTxt.text.toString() == homeBinding.middleRightTxt.text.toString()) && (homeBinding.topRightTxt.text.toString() == homeBinding.bottomRightTxt.text.toString())  && (homeBinding.middleRightTxt.text.toString().isNotEmpty())){
                currentPlayerWon()
            }   else if((homeBinding.topLeftTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.topLeftTxt.text.toString() == homeBinding.bottomRightTxt.text.toString()) && (homeBinding.bottomRightTxt.text.toString().isNotEmpty()))  {
                currentPlayerWon()
            }   else if((homeBinding.topRightTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.topRightTxt.text.toString() == homeBinding.bottomLeftTxt.text.toString()) && (homeBinding.bottomLeftTxt.text.toString().isNotEmpty())) {
                currentPlayerWon()
            }
        }

        fun ifAllBoxesFilled(){
            if(homeBinding.topLeftTxt.text.isNotEmpty() && homeBinding.topCenterTxt.text.isNotEmpty() && homeBinding.topRightTxt.text.isNotEmpty() && homeBinding.middleLeftTxt.text.isNotEmpty() && homeBinding.centerTxt.text.isNotEmpty() && homeBinding.middleRightTxt.text.isNotEmpty() && homeBinding.bottomLeftTxt.text.isNotEmpty() && homeBinding.bottomCenterTxt.text.isNotEmpty() && homeBinding.bottomRightTxt.text.isNotEmpty()) {
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
            homeBinding.middleLeftTxt.setOnClickListener{
                playerAction(homeBinding.middleLeftTxt)
            }
            homeBinding.centerTxt.setOnClickListener{
                playerAction(homeBinding.centerTxt)
            }
            homeBinding.middleRightTxt.setOnClickListener{
                playerAction(homeBinding.middleRightTxt)
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
            homeBinding.middleLeftTxt.text = ""
            homeBinding.centerTxt.text = ""
            homeBinding.middleRightTxt.text = ""
            homeBinding.bottomLeftTxt.text = ""
            homeBinding.bottomCenterTxt.text = ""
            homeBinding.bottomRightTxt.text = ""
            homeBinding.resultTxt.text = ""
            homeBinding.topLeftLine.visibility = View.GONE
            homeBinding.topCenterLine.visibility = View.GONE
            homeBinding.topRightLine.visibility = View.GONE
            homeBinding.middleLeftLine.visibility = View.GONE
            homeBinding.centerLine.visibility = View.GONE
            homeBinding.middleRightLine.visibility = View.GONE
            homeBinding.bottomLeftLine.visibility = View.GONE
            homeBinding.bottomCenterLine.visibility = View.GONE
            homeBinding.bottomRightLine.visibility = View.GONE
            playerTurn = true
            homeBinding.player.text = "Player 1"
            homeBinding.endGame.visibility = View.GONE
            setListeners()
        }
        homeBinding.endGame.setOnClickListener {
            newGame()
        }
        newGame()
    }
}