package com.example.projekt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




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