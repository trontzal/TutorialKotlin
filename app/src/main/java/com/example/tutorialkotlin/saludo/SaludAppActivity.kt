package com.example.tutorialkotlin.saludo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tutorialkotlin.R

class SaludAppActivity : AppCompatActivity() {

    private lateinit var editTextSaludar : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salud_app)

        editTextSaludar = findViewById<EditText>(R.id.editTextSaludar)
        var btnSaludar = findViewById<Button>(R.id.btnSaludar)

        btnSaludar.setOnClickListener{
            saludar()
        }
    }

    private fun saludar() {
        var nombre = editTextSaludar.text.toString()
        if (nombre.isEmpty()){
            return
        }
        intent = Intent(this, com.example.tutorialkotlin.saludo.ResultSaludoActivity::class.java)
        intent.putExtra("nombre", nombre)
        startActivity(intent)
    }
}