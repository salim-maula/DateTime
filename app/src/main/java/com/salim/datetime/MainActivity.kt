package com.salim.datetime

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import java.util.*

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var minute = 0

    var savedday = 0
    var savedmonth = 0
    var savedyear = 0
    var savedhour = 0
    var savedminute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pickDate()
    }


    private fun pickDate() {
        val btn_dt = findViewById<Button>(R.id.btn_dt)
        btn_dt.setOnClickListener {
            DatePickerDialog(this, this,  year, month,day ).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedday = dayOfMonth
        savedmonth = month
        savedyear = year

        getTimeCalendar()
        TimePickerDialog(this, this, hour, minute, true).show()
    }

    private fun getTimeCalendar() {
        val calendar = Calendar.getInstance()
        day = calendar.get(Calendar.DAY_OF_MONTH)
        month = calendar.get(Calendar.MONTH)
        year = calendar.get(Calendar.YEAR)
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedhour = hourOfDay
        savedminute = minute

        val tv_dt = findViewById<TextView>(R.id.tv_dt)
        val tv_time = findViewById<TextView>(R.id.tv_time)

        tv_dt.text = "Date : $savedday : $savedmonth : $savedyear"
        tv_time.text = "Time : $savedhour : $savedminute"

    }
}