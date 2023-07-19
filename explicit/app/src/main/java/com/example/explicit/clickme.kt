package com.example.explicit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class clickme : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clickme)
        val guestname:String? = intent.getStringExtra("Name")
        guestname.let {
            val name = findViewById<TextView>(R.id.name)
            name.text = "Hello {it}"

            Toast.makeText(this, "This activity was launched by $it", Toast.LENGTH_SHORT).show()
        }
    }
}