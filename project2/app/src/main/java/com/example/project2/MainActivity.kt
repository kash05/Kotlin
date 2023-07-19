package com.example.project2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import layout.activity_main


var count = 0
var disable_count = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<TextView>(id.name)
        val button = findViewById<Button>(id.button)
        val button2 = findViewById<Button>(id.button2)
        val message = findViewById<TextView>(id.message)
        val disable = findViewById<Button>(id.disable)
        val chip = findViewById<Button>(id.chip)

        button.setOnClickListener{
            name.text = getString(string.my_name)
            count++
            Toast.makeText(this, "Button is pressed ${count.toInt()} times", Toast.LENGTH_SHORT).show()
        }

        button2.setOnClickListener{
            Toast.makeText(this, message.text, Toast.LENGTH_SHORT).show()
        }

        disable.setOnClickListener {
            disable_count++
            if(disable_count % 2 != 0){
                button2.isEnabled = false
                Toast.makeText(this, "Messages Disabled", Toast.LENGTH_SHORT).show()
            }else{
                button2.isEnabled = true
                Toast.makeText(this, "Messages Enabled", Toast.LENGTH_SHORT).show()
            }
        }

        chip.setOnClickListener{
            val intent = Intent().apply{
                action = Intent.ACTION_VIEW
                data = Uri.parse("https://www.youtube.com/")
            }
                    startActivity(intent)
        }

    }
}