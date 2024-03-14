package tictactoe

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.apdlab1.R
import com.example.apdlab1.databinding.TicktactoeBinding

class TickTacToeComputer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var homeBinding: TicktactoeBinding
        super.onCreate(savedInstanceState)
        homeBinding = DataBindingUtil.setContentView(this , R.layout.ticktactoe)
        var playerTurn = true
        var winner = false
        fun switchTurn(){
            if(!winner){
            if(playerTurn){
                homeBinding.player.setText("Computer")
                homeBinding.player.setTextColor(Color.RED)
            } else {
                homeBinding.player.setText("PLAYER")
                homeBinding.player.setTextColor(Color.GREEN)
            }
            playerTurn = !playerTurn
            }
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
                homeBinding.resultTxt.text = "You Won!"
                homeBinding.resultTxt.setTextColor(Color.GREEN)
                winner = true
            } else {
                homeBinding.resultTxt.text = "You Lost!"
                homeBinding.resultTxt.setTextColor(Color.RED)
                winner = true
            }
            disableTurnsWhenSomeoneWins()
            endGame()
        }

        fun drawLineOnCombination(componentOne: View ,componentTwo: View , componentThree: View, lineDegree: Float){
            componentOne.visibility = View.VISIBLE
            componentTwo.visibility = View.VISIBLE
            componentThree.visibility = View.VISIBLE
            componentOne.rotation = lineDegree
            componentTwo.rotation = lineDegree
            componentThree.rotation = lineDegree
        }
        fun drawLine(combination: Int){
            if(combination == 1){
                drawLineOnCombination(homeBinding.topLeftLine , homeBinding.topCenterLine , homeBinding.topRightLine , 90F)
            } else if(combination == 2){
                drawLineOnCombination(homeBinding.middleLeftLine , homeBinding.centerLine , homeBinding.middleRightLine , 90F)
            } else if(combination == 3){
                drawLineOnCombination(homeBinding.bottomLeftLine , homeBinding.bottomCenterLine , homeBinding.bottomRightLine , 90F)
            } else if(combination == 4){
                drawLineOnCombination(homeBinding.topLeftLine , homeBinding.middleLeftLine , homeBinding.bottomLeftLine , 0F)
            } else if(combination == 5){
                drawLineOnCombination(homeBinding.topCenterLine , homeBinding.centerLine , homeBinding.bottomCenterLine , 0F)
            } else if(combination == 6){
                drawLineOnCombination(homeBinding.topRightLine, homeBinding.middleRightLine , homeBinding.bottomRightLine , 0F)
            } else if(combination == 7){
                drawLineOnCombination(homeBinding.topLeftLine, homeBinding.centerLine , homeBinding.bottomRightLine , 135F)
            }  else if(combination == 8){
                drawLineOnCombination(homeBinding.topRightLine, homeBinding.centerLine , homeBinding.bottomLeftLine , 45F)
            }
        }

        fun checkRow(boxOne: TextView , boxTwo: TextView, boxThree:TextView): Boolean{
           if((boxOne.text.toString() == boxTwo.text.toString()) && (boxOne.text.toString() == boxThree.text.toString()) && (boxTwo.text.toString().isNotEmpty())){
               return true
           } else {
               return false
           }
        }

        fun checkResult(){
            if(checkRow(homeBinding.topLeftTxt, homeBinding.topCenterTxt,  homeBinding.topRightTxt)) {
                currentPlayerWon()
                drawLine(1)
            } else if(checkRow(homeBinding.middleLeftTxt, homeBinding.centerTxt , homeBinding.middleRightTxt)) {
                currentPlayerWon()
                drawLine(2)
            } else if(checkRow(homeBinding.bottomLeftTxt, homeBinding.bottomCenterTxt , homeBinding.bottomRightTxt)){
                currentPlayerWon()
                drawLine(3)
            }  else if(checkRow(homeBinding.topLeftTxt, homeBinding.middleLeftTxt , homeBinding.bottomLeftTxt)){
                currentPlayerWon()
                drawLine(4)
            }   else if(checkRow(homeBinding.bottomCenterTxt, homeBinding.centerTxt , homeBinding.topCenterTxt))  {
                currentPlayerWon()
                drawLine(5)
            }   else if(checkRow(homeBinding.topRightTxt, homeBinding.middleRightTxt , homeBinding.bottomRightTxt)){
                currentPlayerWon()
                drawLine(6)
            }   else if(checkRow(homeBinding.topLeftTxt, homeBinding.centerTxt , homeBinding.bottomRightTxt))  {
                currentPlayerWon()
                drawLine(7)
            }   else if(checkRow(homeBinding.topRightTxt, homeBinding.centerTxt , homeBinding.bottomLeftTxt)) {
                currentPlayerWon()
                drawLine(8)
            }
        }

        fun ifAllBoxesFilled(){
            if(homeBinding.topLeftTxt.text.isNotEmpty() && homeBinding.topCenterTxt.text.isNotEmpty() && homeBinding.topRightTxt.text.isNotEmpty() && homeBinding.middleLeftTxt.text.isNotEmpty() && homeBinding.centerTxt.text.isNotEmpty() && homeBinding.middleRightTxt.text.isNotEmpty() && homeBinding.bottomLeftTxt.text.isNotEmpty() && homeBinding.bottomCenterTxt.text.isNotEmpty() && homeBinding.bottomRightTxt.text.isNotEmpty()) {
                homeBinding.resultTxt.text = "IT'S A TIE!"
                homeBinding.endGame.setVisibility(View.VISIBLE)
            }
        }

        fun disableIndividualListener(box: TextView){
            box.setOnClickListener(null)
        }

        fun playerAction(clickedBox: TextView){
            if(clickedBox.text.toString().isEmpty()){
                if(playerTurn){
                    clickedBox.text = "X"
                    clickedBox.setTextColor(Color.GREEN)
                } else {
                    clickedBox.text = "O"
                    clickedBox.setTextColor(Color.RED)
                }
                disableIndividualListener(clickedBox)
                ifAllBoxesFilled()
                checkResult()
                switchTurn()
            }
        }

        fun checkIfWinOrBlockAvailable(boxOne:TextView , boxTwo:TextView, boxThree:TextView , symbol: String): TextView? {
            if( boxOne.text.toString().isEmpty() && boxTwo.text.toString() == symbol && boxThree.text.toString() == symbol){
                return boxOne
            }  else if(boxOne.text.toString() == symbol && boxTwo.text.toString().isEmpty() && boxThree.text.toString() == symbol){
                return boxTwo
            }   else if(boxOne.text.toString() == symbol && boxTwo.text.toString() == symbol && boxThree.text.toString().isEmpty()){
                return boxThree
            }   else {
                return null
            }
        }
        fun checkRowAvailabilityForWinOrBlock(symbol:String):Boolean{
            if(checkIfWinOrBlockAvailable(homeBinding.topLeftTxt , homeBinding.topCenterTxt, homeBinding.topRightTxt, symbol) != null){
                checkIfWinOrBlockAvailable(homeBinding.topLeftTxt , homeBinding.topCenterTxt, homeBinding.topRightTxt, symbol)?.let { playerAction(it) }
                return true
            } else if(checkIfWinOrBlockAvailable(homeBinding.middleLeftTxt , homeBinding.centerTxt, homeBinding.middleRightTxt, symbol) != null){
                checkIfWinOrBlockAvailable(homeBinding.middleLeftTxt , homeBinding.centerTxt, homeBinding.middleRightTxt, symbol)?.let { playerAction(it) }
                return true
            } else if(checkIfWinOrBlockAvailable(homeBinding.bottomLeftTxt , homeBinding.bottomCenterTxt, homeBinding.bottomRightTxt, symbol) != null){
                checkIfWinOrBlockAvailable(homeBinding.bottomLeftTxt , homeBinding.bottomCenterTxt, homeBinding.bottomRightTxt, symbol)?.let { playerAction(it) }
                return true
            } else if(checkIfWinOrBlockAvailable(homeBinding.topLeftTxt , homeBinding.middleLeftTxt, homeBinding.bottomLeftTxt, symbol) != null){
                checkIfWinOrBlockAvailable(homeBinding.topLeftTxt , homeBinding.middleLeftTxt, homeBinding.bottomLeftTxt, symbol)?.let { playerAction(it) }
                return true
            } else if(checkIfWinOrBlockAvailable(homeBinding.topCenterTxt , homeBinding.centerTxt, homeBinding.bottomCenterTxt, symbol) != null){
                checkIfWinOrBlockAvailable(homeBinding.topCenterTxt , homeBinding.centerTxt, homeBinding.bottomCenterTxt, symbol)?.let { playerAction(it) }
                return true
            } else if(checkIfWinOrBlockAvailable(homeBinding.topRightTxt , homeBinding.middleRightTxt, homeBinding.bottomRightTxt, symbol) != null){
                checkIfWinOrBlockAvailable(homeBinding.topRightTxt , homeBinding.middleRightTxt, homeBinding.bottomRightTxt, symbol)?.let { playerAction(it) }
                return true
            } else if(checkIfWinOrBlockAvailable(homeBinding.topRightTxt , homeBinding.centerTxt, homeBinding.bottomLeftTxt, symbol) != null){
                checkIfWinOrBlockAvailable(homeBinding.topRightTxt , homeBinding.centerTxt, homeBinding.bottomLeftTxt, symbol)?.let { playerAction(it) }
                return true
            } else if(checkIfWinOrBlockAvailable(homeBinding.topLeftTxt , homeBinding.centerTxt, homeBinding.bottomRightTxt, symbol) != null){
                checkIfWinOrBlockAvailable(homeBinding.topLeftTxt , homeBinding.centerTxt, homeBinding.bottomRightTxt, symbol)?.let { playerAction(it) }
                return true
            } else {
                return false
            }
        }
        fun fillCorners(){
            if(homeBinding.topLeftTxt.text.toString().isEmpty()){
                playerAction(homeBinding.topLeftTxt)
            }  else  if(homeBinding.topRightTxt.text.toString().isEmpty()){
                playerAction(homeBinding.topRightTxt)
            } else if(homeBinding.bottomLeftTxt.text.toString().isEmpty()){
                playerAction(homeBinding.bottomLeftTxt)
            } else if(homeBinding.bottomRightTxt.text.toString().isEmpty()){
                playerAction(homeBinding.bottomRightTxt)
            }
        }
        fun areCornersEmpty():Boolean{
            if(homeBinding.topLeftTxt.text.toString().isEmpty() || homeBinding.topRightTxt.text.toString().isEmpty() || homeBinding.bottomLeftTxt.text.toString().isEmpty() || homeBinding.bottomRightTxt.text.toString().isEmpty()){
                return true
            } else {
                return false
            }
        }
        fun areSidesEmpty():Boolean{
            if(homeBinding.topCenterTxt.text.toString().isEmpty() || homeBinding.middleLeftTxt.text.toString().isEmpty() || homeBinding.middleRightTxt.text.toString().isEmpty() || homeBinding.bottomCenterTxt.text.toString().isEmpty()){
                return true
            } else {
                return false
            }
        }
        fun fillSides(){
            if(homeBinding.topCenterTxt.text.toString().isEmpty()){
                playerAction(homeBinding.topCenterTxt)
            }  else  if(homeBinding.middleLeftTxt.text.toString().isEmpty()){
                playerAction(homeBinding.middleLeftTxt)
            } else if(homeBinding.middleRightTxt.text.toString().isEmpty()){
                playerAction(homeBinding.middleRightTxt)
            } else if(homeBinding.bottomCenterTxt.text.toString().isEmpty()){
                playerAction(homeBinding.bottomCenterTxt)
            }
        }
        fun computerTurn(){
            if(homeBinding.centerTxt.text.toString().isEmpty()){
                playerAction(homeBinding.centerTxt)
            } else if(checkRowAvailabilityForWinOrBlock("O")){

            } else if(checkRowAvailabilityForWinOrBlock("X")) {

            } else if(areCornersEmpty()){
                fillCorners()
            }  else if(areSidesEmpty()){
                fillSides()
            }  else {

            }
        }

        fun setListeners(){
            homeBinding.selectOpponentButton.setOnClickListener {
                startActivity(Intent(this , SelectOpponent::class.java))
                finish()
            }
            homeBinding.topLeftTxt.setOnClickListener{
                playerAction(homeBinding.topLeftTxt)
                if(!winner){
                    computerTurn()
                }
            }
            homeBinding.topCenterTxt.setOnClickListener{
                playerAction(homeBinding.topCenterTxt)
                if(!winner){
                    computerTurn()
                }
            }
            homeBinding.topRightTxt.setOnClickListener{
                playerAction(homeBinding.topRightTxt)
                if(!winner){
                    computerTurn()
                }
            }
            homeBinding.middleLeftTxt.setOnClickListener{
                playerAction(homeBinding.middleLeftTxt)
                if(!winner){
                    computerTurn()
                }
            }
            homeBinding.centerTxt.setOnClickListener{
                playerAction(homeBinding.centerTxt)
                if(!winner){
                    computerTurn()
                }
            }
            homeBinding.middleRightTxt.setOnClickListener{
                playerAction(homeBinding.middleRightTxt)
                if(!winner){
                    computerTurn()
                }
            }
            homeBinding.bottomLeftTxt.setOnClickListener{
                playerAction(homeBinding.bottomLeftTxt)
                if(!winner){
                    computerTurn()
                }
            }
            homeBinding.bottomCenterTxt.setOnClickListener{
                playerAction(homeBinding.bottomCenterTxt)
                if(!winner){
                    computerTurn()
                }
            }
            homeBinding.bottomRightTxt.setOnClickListener{
                playerAction(homeBinding.bottomRightTxt)
                if(!winner){
                    computerTurn()
                }
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
            homeBinding.player.text = "PLAYER"
            winner = false
            homeBinding.player.setTextColor(Color.GREEN)
            homeBinding.endGame.visibility = View.GONE
            setListeners()
        }
        homeBinding.endGame.setOnClickListener {
            newGame()
        }
        newGame()
    }
}