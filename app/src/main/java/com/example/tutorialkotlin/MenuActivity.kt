package com.example.tutorialkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnImcApp    = findViewById<Button>(R.id.btnImcApp)

        btnSaludApp.setOnClickListener{
            navigateToSaludApp()
        }
        btnImcApp.setOnClickListener{
            navigateToImcApp()
        }
    }

    private fun navigateToImcApp() {
        val intent = Intent(this, com.example.tutorialkotlin.imccalculator.ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp() {
        val intent = Intent(this, com.example.tutorialkotlin.saludo.SaludAppActivity::class.java)
        startActivity(intent)
    }
}