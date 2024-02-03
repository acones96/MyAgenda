package com.example.myagenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val continueButton: Button = findViewById(R.id.continueButton)
        continueButton.setOnClickListener {
            startActivity(Intent(this, EventCreationActivity::class.java))
        }
    }
}
