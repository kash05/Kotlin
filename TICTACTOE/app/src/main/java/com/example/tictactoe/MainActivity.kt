package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyboardShortcutGroup
import android.view.Menu
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener{

    var PLAYER = true
    var TurnCount = 0

    var boardStatus = Array(3){IntArray(3)}

    lateinit var board: Array<Array<Button>>

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val rstButton = findViewById<Button>(R.id.rstButton)
        val displayTurns = findViewById<TextView>(R.id.displayTurns)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        rstButton.setOnClickListener(this)
        displayTurns.setOnClickListener(this)

        board = arrayOf(
            arrayOf(button1,button2,button3),
            arrayOf(button4,button5,button6),
            arrayOf(button7,button8,button9)
        )
        initializeBoardStatus()

        rstButton.setOnClickListener{
            TurnCount = 0
            PLAYER = true
            displayTurns.text = "Player 1 Turn"
            initializeBoardStatus()

        }
    }


    private fun initializeBoardStatus() {
        for(i in 0..2){
            for(j in 0..2){
               boardStatus[i][j] = -1
            }
        }

        for(i:Array<Button> in board){
            for(button in i){
                button.isEnabled = true
                button.text = ""
            }
        }

    }


    override fun onClick(view: View?) {
        if (view != null) {
            when(view.id){
                R.id.button1->{
                    updateValues(row = 0 , col = 0 , player = PLAYER)
                }
                R.id.button2->{
                    updateValues(row = 0 , col = 1 , player = PLAYER)
                }
                R.id.button3->{
                    updateValues(row = 0 , col = 2 , player = PLAYER)
                }
                R.id.button4->{
                    updateValues(row = 1 , col = 0 , player = PLAYER)
                }
                R.id.button5->{
                    updateValues(row = 1 , col = 1 , player = PLAYER)
                }
                R.id.button6->{
                    updateValues(row = 1 , col = 2 , player = PLAYER)
                }
                R.id.button7->{
                    updateValues(row = 2 , col = 0 , player = PLAYER)
                }
                R.id.button8->{
                    updateValues(row = 2 , col = 1 , player = PLAYER)
                }
                R.id.button9->{
                    updateValues(row = 2 , col = 2 , player = PLAYER)
                }

            }
        }

        TurnCount++
        PLAYER = !PLAYER

        if(PLAYER){
            updateDisplay("Player 1 Turn")
        }else{
            updateDisplay("Player 2 Turn")
        }
        if(TurnCount == 9){
            updateDisplay("Game Draw")
        }

        checkWinner()

    }
    //horizontal
    private fun checkWinner() {
        for(i in 0..2){
            if(boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]){
                if(boardStatus[i][0] == 1){
                updateDisplay("Player 1 Wins")
                break
              }else if(boardStatus[i][0] == 0){
                    updateDisplay("Player 2 Wins")
                    break
                }
            }
        }
        //vertical
        for(i in 0..2){
            if(boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i] ){
                if(boardStatus[0][i] == 1){
                    updateDisplay("Player 1 Wins")
                    break
                }else if(boardStatus[0][i] == 0){
                    updateDisplay("Player 2 Wins")
                    break
                }
            }
        }
       //diagonal 1
        if(boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2] ){

            if(boardStatus[0][0] == 1){
                updateDisplay("Player 1 Wins")
            }else if(boardStatus[0][0] == 0){
                updateDisplay("Player 2 Wins")
            }
        }

        //diagonal 2
        if(boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0] ){

            if(boardStatus[0][2] == 1){
                updateDisplay("Player 1 Wins")
            }else if(boardStatus[0][2] == 0){
                updateDisplay("Player 2 Wins")
            }
        }

    }

    private fun updateDisplay(Text: String) {
       displayTurns.text = Text
        if(Text.contains("Wins")){
            disableButtons()
        }
    }

    private fun disableButtons(){
        for(i in 0..2){
            for(j in 0..2){
                board[i][j].isEnabled = false
            }
        }
    }


    private fun updateValues(row: Int, col: Int, player: Boolean) {
        val text = if(player) "X" else "O"
        val value = if(player) 1 else 0

        board[row][col].apply {
            isEnabled = false
            setText(text)
        }
        boardStatus[row][col] = value
   }
}