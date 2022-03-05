package com.mayank.managementsevakriti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class Register2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)


        val spinner: Spinner = findViewById(R.id.spinnerGender)
        ArrayAdapter.createFromResource(this,
            R.array.spinnerGender,android.R.layout.simple_spinner_item).also { adapter -> adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }
}