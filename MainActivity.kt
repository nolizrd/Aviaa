package com.example.av

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var picked_date :TextView
    private lateinit var btn_date : Button
    private lateinit var picked_date1 :TextView
    private lateinit var btn_date1 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        picked_date = findViewById(R.id.picked_date)
        btn_date=findViewById(R.id.btn_date)
        picked_date1 = findViewById(R.id.picked_date1)
        btn_date1=findViewById(R.id.btn_date1)

        val myCalendar= Calendar.getInstance()
        val datePicker=DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->

            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(myCalendar)
        }
        btn_date.setOnClickListener{
            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show()

        }
        btn_date1.setOnClickListener{
            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show()

        }

    }
    private fun updateLable(myCalendar: Calendar)
    {
        val myFormat="dd-MM-yyyy"
        val sdf=SimpleDateFormat(myFormat, Locale.UK)

        picked_date.setText(sdf.format(myCalendar.time))
        picked_date1.setText(sdf.format(myCalendar.time))
    }

}