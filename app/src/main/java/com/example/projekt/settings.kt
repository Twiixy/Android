package com.example.projekt

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.*
import kotlin.concurrent.thread

class settings : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_settings)
        val actionbar = supportActionBar
        actionbar!!.title="Einstellungen"
        actionbar.setDisplayHomeAsUpEnabled(true)





        val Spinner = findViewById<Spinner>(R.id.SpinnerSprachauswahl)

        val empty =  resources.getStringArray(R.array.sprachen_auswahl)
        val arrayadapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,empty)
        arrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        Spinner.adapter = arrayadapter
        Spinner.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(applicationContext,"Ausgewählte Sprache:  "+empty[p2], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }



        val Kontobutton = findViewById<Button>(R.id.buttonsettingspeichern)

                Thread {

        Kontobutton.setOnClickListener()
        {



            val t1 = findViewById<EditText>(R.id.editKontostand)  //Layout2

            val AusgabeKontostand = findViewById<TextView>(R.id.Kontostandtxt) //Layout 1


            runOnUiThread{ AusgabeKontostand.setText(t1.text.toString())}


        }
        }.start()


    }


}