package com.example.minicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.minicalculator.R.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val value1 = findViewById<TextView>(R.id.num1)
        val value2 = findViewById<TextView>(R.id.num2)
        val answer = findViewById<TextView>(R.id.ans)
        val add = findViewById<Button>(R.id.add)
        val sub = findViewById<Button>(R.id.sub)
        val multi = findViewById<Button>(R.id.multiply)
        val div = findViewById<Button>(R.id.div)

        var x = 0
        var y = 0
        var c = 0

        add.setOnClickListener {
            x = value1.text.toString().toInt()
            y = value2.text.toString().toInt()
            c = x + y
            answer.setText(c.toString())
        }

        multi.setOnClickListener {
            x = value1.text.toString().toInt()
            y = value2.text.toString().toInt()
            c = x * y
            answer.setText(c.toString())
        }

        sub.setOnClickListener {
            x = value1.text.toString().toInt()
            y = value2.text.toString().toInt()
            c = x - y
            answer.text = c.toString()
        }

        div.setOnClickListener {
            x = value1.text.toString().toInt()
            y = value2.text.toString().toInt()
            if (y == 0) {
                answer.text = getString(string.invalid)
            } else {
                c = x / y
                answer.setText(c.toString())
            }
        }
    }
}

