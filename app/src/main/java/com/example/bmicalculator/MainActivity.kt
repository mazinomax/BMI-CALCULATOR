package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightET = findViewById<EditText>(R.id.etWeight)
        val heightET = findViewById<EditText>(R.id.etHeight)
        val calculateButton = findViewById<Button>(R.id.btnCalculate)
        val tvNote = findViewById<TextView>(R.id.tvHealthNote)

        tvNote.text = " Healthy BMI range 18.5 - 24.9 "

        calculateButton.setOnClickListener {
            val weight = weightET.text.toString().toInt().toFloat()
            val height = heightET.text.toString().toInt().toFloat()
            val bmi = weight / (height * height * 0.0001)
            val bmi2digis = ((bmi * 1000.0).roundToInt() / 1000.0).toFloat()
            /*Another way to convert to 2digits
             val bmi2digits = "%.2f".format(bmi)

             */

            resultForBmi(bmi2digis)

        }



    }

    fun resultForBmi (bmi:Float) {
        val tvResultStatement = findViewById<TextView>(R.id.tvResultStatement)
        val resultBtn = findViewById<TextView>(R.id.tvResult)

        resultBtn?.text   = bmi.toString()


        var resultStatement = ""
        var color = 0

        when {

            bmi < 18.49 -> {
                resultStatement = "you are underweight"
                color = R.color.underweight
            }

            bmi in 18.50 .. 24.90 -> {
                   resultStatement = "You are Healthy"
                   color = R.color.healthy
            }

            bmi > 25.00 -> {
                   resultStatement = "You are overweight"
                   color = R.color.overweight
            }


       }

        tvResultStatement.text = resultStatement
        tvResultStatement.setTextColor(ContextCompat.getColor(this,color))




    }
}