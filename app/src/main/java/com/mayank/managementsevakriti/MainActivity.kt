package com.mayank.managementsevakriti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.mayank.managementsevakriti.contractor.ContractorRegistrations
import com.mayank.managementsevakriti.worker.WorkerHome

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val spinner: Spinner = findViewById(R.id.AsType)
        ArrayAdapter.createFromResource(
            this,
            R.array.AsType, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )
            spinner.adapter = adapter
        }


            val i: TextView = findViewById(R.id.NewUserRegister)
            i.setOnClickListener { if (spinner.selectedItem.toString().lowercase() == "workers") {startActivity(Intent(this, Register2::class.java)) }
            else{
                startActivity(Intent(this, ContractorRegistrations::class.java))
            }}

        val btn:Button = findViewById(R.id.LOGIN)
        btn.setOnClickListener { startActivity(Intent(this,WorkerHome::class.java)) }

    }
}