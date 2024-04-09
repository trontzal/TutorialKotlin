package com.example.tutorialkotlin.imccalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tutorialkotlin.R

class ResultImcActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvImc: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnReCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val resultString: String? = intent.extras?.getString("IMC_RESULT")
        val result: Double = resultString?.replace(",", ".")?.toDouble() ?: -1.0




        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initUI(result: Double) {
        tvImc.text = result.toString()
        when (result) {
            in 0.00..18.50 -> {
                tvResult.text = "Bajo"
                tvDescription.text = "Tu imc indica que estar por debajo del peso recomendado"
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
            }
            in 18.51..24.99 -> {
                tvResult.text = "Normal"
                tvDescription.text = "Peso adecuado para la altura"
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
            }
            in 25.00..29.99 -> {
                tvResult.text = "Sobrepeso"
                tvDescription.text = "Demasido peso para la estatura"
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
            }
            in 30.00..99.00 -> {
                tvResult.text = "Obesidad"
                tvDescription.text = "MUY por encima del peso recomendado"
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
            }
            else->{
                tvImc.text = "error"
                tvResult.text = "error"
                tvDescription.text = "error"
            }
        }
    }

    private fun initComponents() {
        tvImc = findViewById(R.id.tvImc)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }
}