package com.example.myagenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EventCreationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_creation)

        val eventName: EditText = findViewById(R.id.eventName)
        val eventType: EditText = findViewById(R.id.eventType)
        val startDate: EditText = findViewById(R.id.startDate)
        val endDate: EditText = findViewById(R.id.endDate)
        val confirmButton: Button = findViewById(R.id.confirmButton)
        val cancelButton: Button = findViewById(R.id.cancelButton)

        startDate.setOnClickListener {showStartDatePicker()}
        endDate.setOnClickListener {showEndDatePicker()}

        confirmButton.setOnClickListener {
            if (eventName.length() != 0 && eventType.length() != 0 && startDate.length() != 0 && endDate.length() != 0) {
                Toast.makeText(this, "Evento creado correctamente", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(
                    this,
                    "Completa todos los campos correctamente",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        cancelButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun showStartDatePicker() {
        val datePicker = DatePickerFragment{day, month, year -> onStartDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun showEndDatePicker() {
        val datePicker = DatePickerFragment{day, month, year -> onEndDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onStartDateSelected(day:Int, month:Int, year:Int){
        val startDate: EditText = findViewById(R.id.startDate)
        startDate.setText("$day/$month/$year")
    }

    fun onEndDateSelected(day:Int, month:Int, year:Int){
        val endDate: EditText = findViewById(R.id.endDate)
        endDate.setText("$day/$month/$year")
    }
}
