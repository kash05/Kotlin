package com.example.constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val persons = arrayOf(nameData("Kashish",21,R.drawable.ic_launcher_foreground),
    nameData("Kamal",21,R.drawable.ic_launcher_foreground),
    nameData("Gaurav",21,R.drawable.ic_launcher_foreground),
    nameData("Himanshu",21,R.drawable.ic_launcher_foreground),
    nameData("Rohan",21,R.drawable.ic_launcher_foreground),
    nameData("Praneet",21,R.drawable.ic_launcher_foreground),
    nameData("Gojo",21,R.drawable.ic_launcher_foreground))

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namesList = findViewById<RecyclerView>(R.id.names_List).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = namesAdapter()
            setHasFixedSize(true)
        }
        val showNames = findViewById<Button>(R.id.showNames)
        showNames.setOnClickListener {
            (namesList.adapter as namesAdapter).namess = persons
        }
    }
}
