package com.joeljebitto.ageinminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnDatepicker).setOnClickListener { view ->
            clickDatepicker(view)
            Toast.makeText(this, "Button", Toast.LENGTH_SHORT).show()
        }
    }

    fun clickDatepicker(view: View) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val selectedDate = findViewById<TextView>(R.id.tvSelectedDate)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year_S, month_S, date_S ->
                "$date_S/$month_S/$year_S".also { selectedDate.text = it }

            },
            year,
            month,
            day
        ).show()
    }
}