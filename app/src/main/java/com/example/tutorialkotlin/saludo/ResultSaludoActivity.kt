package com.example.tutorialkotlin.saludo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tutorialkotlin.R

class ResultSaludoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_saludo)

        val textViewSaludo = findViewById<TextView>(R.id.textViewSaludo)
        val nombre = intent.getStringExtra("nombre")

        textViewSaludo.text = "Hola $nombre"
    }
}