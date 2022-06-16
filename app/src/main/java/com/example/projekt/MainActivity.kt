package com.example.projekt

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {


lateinit var lineDataSet: BarDataSet
lateinit var barData: BarData


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Balkendiagramm
        val xvalue = ArrayList<String>()
        xvalue.add("Monday")
        xvalue.add("Tuesday")
        xvalue.add("Wensday")
        xvalue.add("Thurdday")





        val barentries = ArrayList<BarEntry>()

        barentries.add(BarEntry(1f,10f))
        barentries.add(BarEntry(2f,20f))
        barentries.add(BarEntry(3f,30f))
        barentries.add(BarEntry(4f,5f))

        lineDataSet= BarDataSet(barentries,"Test")
        barData= BarData(lineDataSet)
        lineDataSet.setColor(700000,250)
        var b1 = findViewById<com.github.mikephil.charting.charts.BarChart>(R.id.Balkendiagramm)
        b1.data=barData
        lineDataSet.valueTextColor= Color.BLACK
        lineDataSet.valueTextSize=15f




        val Ausgabe: Button = findViewById (R.id.new_Ausgabe)

        Ausgabe.setOnClickListener() {
            val intent = Intent(this,addAusgabe::class.java);
            startActivity(intent)

        }

        val Einstellungen: Button = findViewById (R.id.settingsbutton)

        Einstellungen.setOnClickListener() {
            val intent2 = Intent(this,settings::class.java);
            startActivity(intent2)

        }


    }




}