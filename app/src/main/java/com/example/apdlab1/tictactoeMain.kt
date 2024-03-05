package com.example.apdlab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


        var playerTurn: Boolean = true
        fun switchTurn(){
            playerTurn = !playerTurn

        }
        fun currentPlayerWon(){
            if(playerTurn){
                homeBinding.resultTxt.text = "Winner: Player 1"
            } else {
                homeBinding.resultTxt.text = "Winner: Player 2"
            }
        }

        fun checkResult(){
            if((homeBinding.topLeftTxt.text.toString() == homeBinding.topCenterTxt.text.toString()) && (homeBinding.topLeftTxt.text.toString() == homeBinding.topRightTxt.text.toString())) {
                currentPlayerWon()
            } else if((homeBinding.centerLeftTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.centerLeftTxt.text.toString() == homeBinding.centerRightTxt.text.toString())) {
                currentPlayerWon()
            } else if((homeBinding.bottomLeftTxt.text.toString() == homeBinding.bottomCenterTxt.text.toString()) && (homeBinding.bottomLeftTxt.text.toString() == homeBinding.bottomRightTxt.text.toString())){
                currentPlayerWon()
            }  else if((homeBinding.topLeftTxt.text.toString() == homeBinding.centerLeftTxt.text.toString()) && (homeBinding.topLeftTxt.text.toString() == homeBinding.bottomLeftTxt.text.toString())){
                currentPlayerWon()
            }   else if((homeBinding.topCenterTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.topCenterTxt.text.toString() == homeBinding.bottomCenterTxt.text.toString()))  {
                currentPlayerWon()
            }   else if((homeBinding.topRightTxt.text.toString() == homeBinding.centerRightTxt.text.toString()) && (homeBinding.topRightTxt.text.toString() == homeBinding.bottomRightTxt.text.toString())){
                currentPlayerWon()
            }   else if((homeBinding.topLeftTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.topLeftTxt.text.toString() == homeBinding.bottomRightTxt.text.toString()))  {
                currentPlayerWon()
            }   else if((homeBinding.topRightTxt.text.toString() == homeBinding.centerTxt.text.toString()) && (homeBinding.topRightTxt.text.toString() == homeBinding.bottomLeftTxt.text.toString())) {
                currentPlayerWon()
            }
        }


        fun playerAction(clickedBox: TextView){
            if(clickedBox.text.toString().isEmpty()){
                if(playerTurn){
                    clickedBox.text = "X"
                } else {
                    clickedBox.text = "O"
                }
                switchTurn()
            }
        }

        homeBinding.topLeftTxt.setOnClickListener{
            playerAction(homeBinding.topLeftTxt)
        }
        homeBinding.topLeftTxt.setOnClickListener{
            playerAction(homeBinding.topLeftTxt)
        }
        homeBinding.topLeftTxt.setOnClickListener{
            playerAction(homeBinding.topLeftTxt)
        }
        homeBinding.topLeftTxt.setOnClickListener{
            playerAction(homeBinding.topLeftTxt)
        }
        homeBinding.topLeftTxt.setOnClickListener{
            playerAction(homeBinding.topLeftTxt)
        }
        homeBinding.topLeftTxt.setOnClickListener{
            playerAction(homeBinding.topLeftTxt)
        }
        homeBinding.topLeftTxt.setOnClickListener{
            playerAction(homeBinding.topLeftTxt)
        }
        homeBinding.topLeftTxt.setOnClickListener{
            playerAction(homeBinding.topLeftTxt)
        }
        homeBinding.topLeftTxt.setOnClickListener{
            playerAction(homeBinding.topLeftTxt)
        }
        homeBinding.topLeftTxt.setOnClickListener {
            if(homeBinding.topLeftTxt.text.toString().isEmpty()){
                if(playerTurn){
                    homeBinding.topLeftTxt.text = "X"
                } else {
                    homeBinding.topLeftTxt.text = "O"
                }
                switchTurn()
            }
        }
        homeBinding.topCenterTxt.setOnClickListener {
            if(homeBinding.topCenterTxt.text.toString().isEmpty()){
                if(playerTurn){
                    homeBinding.topCenterTxt.text = "X"
                } else {
                    homeBinding.topCenterTxt.text = "O"
                }
                switchTurn()
            }
        }
        homeBinding.topRightTxt.setOnClickListener {
            if(homeBinding.topRightTxt.text.toString().isEmpty()){
                if(playerTurn){
                    homeBinding.topRightTxt.text = "X"
                } else {
                    homeBinding.topRightTxt.text = "O"
                }
                switchTurn()
            }
        }
        homeBinding.centerLeftTxt.setOnClickListener {
            if(homeBinding.centerLeftTxt.text.toString().isEmpty()){
                if(playerTurn){
                    homeBinding.centerLeftTxt.text = "X"
                } else {
                    homeBinding.centerLeftTxt.text = "O"
                }
                switchTurn()
            }
        }
        homeBinding.centerTxt.setOnClickListener {
            if(homeBinding.centerTxt.text.toString().isEmpty()){
                if(playerTurn){
                    homeBinding.centerTxt.text = "X"
                } else {
                    homeBinding.centerTxt.text = "O"
                }
                switchTurn()
            }
        }
        homeBinding.centerRightTxt.setOnClickListener {
            if(homeBinding.centerRightTxt.text.toString().isEmpty()){
                if(playerTurn){
                    homeBinding.centerRightTxt.text = "X"
                } else {
                    homeBinding.centerRightTxt.text = "O"
                }
                switchTurn()
            }
        }
        homeBinding.bottomLeftTxt.setOnClickListener {
            if(homeBinding.bottomLeftTxt.text.toString().isEmpty()){
                if(playerTurn){
                    homeBinding.bottomLeftTxt.text = "X"
                } else {
                    homeBinding.bottomLeftTxt.text = "O"
                }
                switchTurn()
            }
        }
        homeBinding.bottomCenterTxt.setOnClickListener {
            if(homeBinding.bottomCenterTxt.text.toString().isEmpty()){
                if(playerTurn){
                    homeBinding.bottomCenterTxt.text = "X"
                } else {
                    homeBinding.bottomCenterTxt.text = "O"
                }
                switchTurn()
            }
        }
        homeBinding.bottomRightTxt.setOnClickListener {
            if(homeBinding.bottomRightTxt.text.toString().isEmpty()){
                if(playerTurn){
                    homeBinding.bottomRightTxt.text = "X"
                } else {
                    homeBinding.bottomRightTxt.text = "O"
                }
                switchTurn()
            }
        }
    }

}