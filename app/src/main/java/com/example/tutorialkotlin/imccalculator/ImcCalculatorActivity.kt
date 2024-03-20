package com.example.tutorialkotlin.imccalculator

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.tutorialkotlin.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat
import java.util.Locale

class ImcCalculatorActivity : AppCompatActivity() {
    private var currentWeight: Int = 60
    private var currentAge: Int = 30
    private var currentHeight: Int = 160

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnAddWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnAddAge: FloatingActionButton
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponent()
        cambiarColorSeleccionado()
        initListeners()
        initUI()

        rsHeight.addOnChangeListener { rangeSlider, value, b ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
    }

    private fun initUI() {
        setWeight()
    }

    private fun initComponent() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnAddWeight = findViewById(R.id.btnAddWeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnAddAge = findViewById(R.id.btnAddAge)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        btnAddWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnAddAge.setOnClickListener{
            currentAge += 1
            setAge()
        }
        btnSubtractAge.setOnClickListener{
            currentAge -= 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            calculateImc()
        }
    }

    private fun calculateImc() {
        val currentHeightCm = currentHeight.toDouble() / 100
        val imc = currentWeight / (currentHeightCm * currentHeightCm)
        val formattedImc = String.format(Locale.getDefault(), "%.2f", imc)
        Log.i("imc", "el resultado es $formattedImc")
    }

    private fun cambiarColorSeleccionado() {
        viewMale.setOnClickListener {
            viewMale.setCardBackgroundColor(resources.getColor(R.color.background_component_selected))
            viewFemale.setCardBackgroundColor(resources.getColor(R.color.background_component))
        }

        viewFemale.setOnClickListener {
            viewFemale.setCardBackgroundColor(resources.getColor(R.color.background_component_selected))
            viewMale.setCardBackgroundColor(resources.getColor(R.color.background_component))
        }
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }
}
