package com.example.explicit


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val click = findViewById<Button>(R.id.click)

        click.setOnClickListener {
            val intent = Intent(this,clickme::class.java).apply{
                putExtra("Name","Kash")
            }
            startActivity(intent)
        }
    }
}