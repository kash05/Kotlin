package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyboardShortcutGroup
import android.view.Menu
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button

class MainActivity : AppCompatActivity(),View.OnClickListener{

    val Button1 = findViewById<Button>(R.id.button1)
    val Button2 = findViewById<Button>(R.id.button2)
    val Button3 = findViewById<Button>(R.id.button3)
    val Button4 = findViewById<Button>(R.id.button4)
    val Button5 = findViewById<Button>(R.id.button5)
    val Button6 = findViewById<Button>(R.id.button6)
    val Button7 = findViewById<Button>(R.id.button7)
    val Button8 = findViewById<Button>(R.id.button8)
    val Button9 = findViewById<Button>(R.id.button9)

    var PLAYER = true
    var TurnCount = 0

    var boardStatus = Array(3){IntArray(3)}

    lateinit var board: Array<Array<Button>>

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)


        board = arrayOf(
            arrayOf(Button1,Button2,Button3),
            arrayOf(Button4,Button5,Button6),
            arrayOf(Button7,Button8,Button9)
        )
           for(i in board){
            for(button in i){
                button.setOnClickListener(this)
            }
        }
            initializeBoardStatus()


    }

    private fun initializeBoardStatus() {
        for(i in 1..2){
            for(j in 1..2){
                boardStatus[0][0] == -1
                board[0][0].isEnabled = true
                board[0][0].text = ""
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